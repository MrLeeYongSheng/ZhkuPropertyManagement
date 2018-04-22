package com.lys.zhku.web.files;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Files;
import com.lys.zhku.model.PersonalFiles;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.PersonalFilesPagination;
import com.lys.zhku.service.FTPClientService;
import com.lys.zhku.service.files.PersonalFilesService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private FTPClientService ftpClientService;
	
	@Autowired
	private PersonalFilesService personalFilesService;	
	
	@Autowired
	private Environment env; 
	
	private static Logger log = Logger.getLogger(VideoController.class);

	@ExceptionHandler(value=ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<PersonalFiles> getPage(PersonalFilesPagination pagination) {
		pagination.setPositionPrefixLike(env.getProperty("video.root"));
		return personalFilesService.getPageByPagination(pagination);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		List<Files> filesList = (List<Files>) personalFilesService.selectUuidNameAndPositionByPrimaryKeys(ids);
		ftpClientService.deleteByFiles(filesList);
		personalFilesService.deleteEntitys(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response, Integer id) {
		if(response==null || id==null) {
			log.error("HttpServletResponse is null or id is null");
			throw new ErrorException(StatusCode.ERROR, "HttpServletResponse is null or id is null");
		}
		PersonalFiles file = personalFilesService.selectByPrimaryKey(id);
		ftpClientService.downloadFilesToResponse(file,response);	
	}

	@RequestMapping(value="/upload")
	@ResponseBody
	public Message upload(@RequestPart Part file, @RequestParam String username) {
		if(file==null) {
			return new Message(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数,上传失败");
		}
		LocalDate date = LocalDate.now();//现在的系统时间
		String parentDir = env.getProperty("video.root","/error") + "/" + date.getYear() 
		+ "/" + date.getMonthValue() + "/" + date.getDayOfMonth();
		PersonalFiles pf = null;
		
		List<Files> files = ftpClientService.uploadFileToFtpServer(new Part[] {file}, parentDir);
		if(CollectionUtils.isEmpty(files)) {
			return new Message(StatusCode.NOT_FOUND, "上传文件到ftp服务器失败");
		}
		pf = new PersonalFiles();
		pf.convertFromFiles(files.get(0));
		pf.setUsersUsername(username);
		personalFilesService.insertEntity(pf);
		return new Message(StatusCode.SUCCESS, "上传成功");
	}
}
