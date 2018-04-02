package com.lys.zhku.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Userdetails;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.service.UserDetailsService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/userdetails")
public class UserdetailsController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping("/getUserdetailsByUsersUsername")
	@ResponseBody 
	public Userdetails getUserdetailsByUsersUsername(String usersUsername) {
		
		Userdetails userdetail = userDetailsService.getUserdetailsByUsersUsername(usersUsername);
		return userdetail;
	}

	@RequestMapping("/edit")
	@ResponseBody 
	public Message edit(Userdetails ud) {
		userDetailsService.updateByUsersUsername(ud);
		return new Message(StatusCode.SUCCESS, "操作成功");
	}
	
	@ExceptionHandler(ErrorException.class)
	public ResponseEntity<Message> error(ErrorException e){
		return new ResponseEntity<Message>(new Message(e.getCode(), e.getMsg()), HttpStatus.NOT_FOUND);
	}
}
