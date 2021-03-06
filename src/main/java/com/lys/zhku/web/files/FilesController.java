package com.lys.zhku.web.files;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.ClassroomSchedule;
import com.lys.zhku.model.Files;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.ExportExcelService;
import com.lys.zhku.service.FTPClientService;
import com.lys.zhku.service.files.FilesService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Controller
@RequestMapping("/files")
public class FilesController {
	
	@Autowired
	private FilesService<Files> filesService;
	
	@Autowired
	private FTPClientService ftpClientService;
	
	@Autowired
	private ExportExcelService exportExcelService;
	
	private static Logger log = Logger.getLogger(FilesController.class);

	@ExceptionHandler(value=ErrorException.class)
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
	public Message add(@RequestPart("files") Part[] files, String parentDir) {
		
		Set<String> set = new HashSet<String>();
		for (Part part : files) {
			if(!set.add(part.getSubmittedFileName())) {
				throw new ErrorException(StatusCode.ERROR, "不允许上传具有相同名字的文件");
			}
		}
		if(CollectionUtils.isEmpty(files) || StringUtils.isEmpty(parentDir)) {
			if(log.isDebugEnabled())
				log.error("数据丢失:files.length:"+files.length + ",parentDir:"+parentDir);
			return new Message(StatusCode.MISSING_REQUEST_PARAM, "上传失败,数据丢失");
		}
		List<Files> filesList = ftpClientService.uploadFileToFtpServer(files, parentDir);
		if(log.isInfoEnabled()) {
			log.info("成功上传:" + filesList.size());
		}
		filesService.insertFiles(filesList);
		return new Message(StatusCode.SUCCESS, "插入记录成功:"+filesList.size());
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		List<Files> filesList = filesService.selectUuidNameAndPositionByPrimaryKeys(ids);
		ftpClientService.deleteByFiles(filesList);
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
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response, Integer id) {
		if(response==null || id==null) {
			log.error("HttpServletResponse is null or id is null");
			throw new ErrorException(StatusCode.ERROR, "HttpServletResponse is null or id is null");
		}
		Files file = filesService.selectByPrimaryKey(id);
		ftpClientService.downloadFilesToResponse(file,response);	
	}
		
	/**
	 * 导出所有记录信息
	 * @param response
	 */
	@RequestMapping(value="/exportAll")
	public void exportAllExcel(HttpServletResponse response) {
		List<Files> list = filesService.getAll();
		exportExcelService.exportAll(list, response, Files.class);
	}

	/**
	 * 导出pks主键集合所指定的记录
	 * @param response
	 * @param pks
	 */
	@RequestMapping(value="/exportSelections")
	public void exportSelectionsExcel(HttpServletResponse response, String[] pks) {
		List<Files> list = filesService.getByPrimaryKeys(pks);
		exportExcelService.exportAll(list, response, Files.class);
	}
}
