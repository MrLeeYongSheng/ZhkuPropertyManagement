package com.lys.zhku.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Users;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.service.users.UsersService;
import com.lys.zhku.utils.PasswordUtils;
import com.lys.zhku.utils.StatusCode;
import com.lys.zhku.utils.VerifyCodeUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private String code = null;
	
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
	
	/**
	 * 获取验证码图片
	 * @param response
	 */
	@RequestMapping("/login/getVerifyCode")
	public void getVerifyCode(HttpServletResponse response) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		code = VerifyCodeUtil.drawImg(output);
		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 验证验证码
	 * @param code
	 * @return
	 */
	@RequestMapping("/login/verifyCode")
	@ResponseBody
	public Map<String, Boolean> verifyCode(@RequestParam String code) {
		boolean verify = false;
		Map<String, Boolean> map = new HashedMap<>();
		if(this.code==null) {
			map.put("verify", false);
			this.code = null;
			return map;
		} else if(this.code.equalsIgnoreCase(code)) {
			verify = true;
		}
		this.code = null;
		map.put("verify", verify);
		return map;
	}
}
