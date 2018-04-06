package com.lys.zhku.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lys.zhku.model.Users;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.service.users.UsersService;
import com.lys.zhku.utils.PasswordUtils;
import com.lys.zhku.utils.StatusCode;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UsersService usersService;
	
	@ExceptionHandler(ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		logger.error("发生异常:code:"+e.getCode()+",msg:"+e.getMsg(),e);
		return new Message(e.getCode(), e.getMsg());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = {"/index","/"})
	public String index() {
		return "index";
	}

	@RequestMapping(value = {"/home/modifyPassword"})
	@ResponseBody
	public Message modifyPassword(Users user) {
		Users selectUser = usersService.getByPrimaryKey(user.getUsername());
		selectUser.setPassword(PasswordUtils.encode(user.getPassword()));
		usersService.updateByPrimaryKey(selectUser);
		Message msg = new Message(StatusCode.SUCCESS, "修改密码成功");
		return msg ;
	}

	@RequestMapping(value = "/subviews/{pathName}/{fileName}", method = RequestMethod.GET)
	public String subviews(@PathVariable String pathName, @PathVariable String fileName) {
		return "subviews/" + pathName +"/"+ fileName;
	}
	
	@RequestMapping(value="/home/uploadHeadPicture")
	@ResponseBody
	public Message uploadHeadPicture(@RequestPart Part file) {
		InputStream is;
		try {
			is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream("D:/"+file.getSubmittedFileName());
			byte[] buff = new byte[1024];
			int len=0;
			while((len=is.read(buff))>0) {
				fos.write(buff, 0, len);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Message(StatusCode.SUCCESS, "测试");
	}
	
	//@RequestMapping(value="/home/uploadHeadPicture")
	@ResponseBody
	public Message uploadHeadPictureBackup(Part file) {
		InputStream is;
		try {
			is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream("D:/"+file.getSubmittedFileName());
			byte[] buff = new byte[1024];
			int len=0;
			while((len=is.read(buff))>0) {
				fos.write(buff, 0, len);
			}
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Message(StatusCode.SUCCESS, "测试");
	}
}
