package com.lys.zhku.web.school;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Dormitory;
import com.lys.zhku.model.Park;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.school.ParkService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/school/park")
public class ParkController {
	
	@Autowired
	private ParkService<Park> parkService;

	@ExceptionHandler
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}
	
	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String view(@PathVariable String path) {
		return "school/park/" + path;
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<Park> getPage(Pagination pagination) {
		return parkService.getPageByPagination(pagination);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message add(@Valid Park park, Errors e) {
		if(e.hasErrors()) {
			park.setEnable(true);
			park.setEntryTime(new Date());
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Park>> validate = validator.validate(park);
			if(validate.size()>0) {
				return new Message(StatusCode.INCOMPLETE_MODEL_DATA, "非完整Park信息,插入记录失败");
			}
		}
		parkService.insertEntity(park);
		return new Message(StatusCode.SUCCESS, "插入记录成功");
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		parkService.deleteEntitys(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message edit(@Valid Park park, Errors e) {
		if(park.getId()==null || e.hasErrors()) {
			return new Message(StatusCode.INCOMPLETE_MODEL_DATA, "非完整Park信息,修改记录失败");
		}
		parkService.updateEntity(park);
		return new Message(StatusCode.SUCCESS, "修改记录成功");
	}
}
