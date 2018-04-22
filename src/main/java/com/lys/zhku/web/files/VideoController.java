package com.lys.zhku.web.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.lys.zhku.utils.StringUtils;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	private FTPClientService ftpClientService;
	
	private static Logger log = Logger.getLogger(VideoController.class);

	@ExceptionHandler(value=ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<PersonalFiles> getPage(PersonalFilesPagination pagination) {
		return null;
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}
	
	@RequestMapping("/download")
	public void download(HttpServletResponse response, Integer id) {
		if(response==null || id==null) {
			log.error("HttpServletResponse is null or id is null");
			throw new ErrorException(StatusCode.ERROR, "HttpServletResponse is null or id is null");
		}

	}
	
	@RequestMapping(value="/upload")
	@ResponseBody
	public Message upload(@RequestPart Part file) {
		try {
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream("D:\\"+file.getSubmittedFileName());
			int len = 0;
			byte[] buff = new byte[1024];
			while((len=is.read(buff))>0) {
				fos.write(buff, 0, len);
			}
			is.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
