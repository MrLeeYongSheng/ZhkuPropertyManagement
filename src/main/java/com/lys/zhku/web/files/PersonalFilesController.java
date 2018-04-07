package com.lys.zhku.web.files;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.FTPClientService;
import com.lys.zhku.service.files.PersonalFilesService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.StringUtils;

@Controller
@RequestMapping("/personalFiles")
public class PersonalFilesController {
	
	@Autowired
	private PersonalFilesService personalFilesService;
	
	@Autowired
	private FTPClientService ftpClientService;
	
	private static Logger log = Logger.getLogger(PersonalFilesController.class);

	@ExceptionHandler(value=ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<PersonalFiles> getPage(Pagination pagination) {
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
	
	@RequestMapping(value="/uploadHeadPicture")
	@ResponseBody
	public Message uploadHeadPicture(@RequestPart Part file, @RequestParam String username) {
		if(file==null || StringUtils.isEmpty(username)) {
			return new Message(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数,上传失败");
		}
		List<PersonalFiles> list = personalFilesService.selectPositionByUsersUsername(username);
		String parentDir = null;
		PersonalFiles pf = null;
		if(!CollectionUtils.isEmpty(list)) {
			pf = list.get(0);
		}
		if(pf==null) {
			parentDir = "/users" + generatePath(1000, 2) + "/" + username;
		} else {
			parentDir = pf.getPosition();
		}
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
	
	/**
	 * 生成绝对路径(/开头,),且非/结尾
	 * @param round 生成文件夹名字的数字范围
	 * @param level 生成文件夹的级数
	 * @return eg:/1/26/999/23
	 */
	private String generatePath(int round,int level) {
		if(level<1) {
			return "/";
		}
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i=0; i<level; i++) {
			int nextInt = random.nextInt(round);
			sb.append("/"+nextInt);
		}
		return sb.toString();
	}	
	
}
