package com.lys.zhku.web.files;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.Part;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Files;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.files.FilesService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/files")
public class FilesController {
	
	@Autowired
	private FilesService<Files> filesService;

	@ExceptionHandler
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}
	
	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String view(@PathVariable String path) {
		return "files/" + path;
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<Files> getPage(Pagination pagination) {
		return filesService.getPageByPagination(pagination);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message add(@RequestPart("files") Part[] files, @Valid Files file, Errors e) {
		
		file.setTime(new Date());
		file.setSize(100L);
		if(e.hasErrors()) {
			file.setEnable(true);
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Files>> validate = validator.validate(file);
			if(validate.size()>0) {
				return new Message(StatusCode.INCOMPLETE_MODEL_DATA, "非完整Files信息,插入记录失败");
			}
		}
		filesService.insertEntity(file);
		return new Message(StatusCode.SUCCESS, "插入记录成功");
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		filesService.deleteEntitys(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message edit(@Valid Files file, Errors e) {
		if(file.getId()==null || e.hasErrors()) {
			return new Message(StatusCode.INCOMPLETE_MODEL_DATA, "非完整Files信息,修改记录失败");
		}
		filesService.updateEntity(file);
		return new Message(StatusCode.SUCCESS, "修改记录成功");
	}
}
