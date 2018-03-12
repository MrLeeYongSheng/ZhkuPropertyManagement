package com.lys.zhku.web.workers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Userdetails;
import com.lys.zhku.model.Workers;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/workers")
public class WorkersController {
	
	/**
	 * 用来处理异常ErrorException的情况
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ErrorException.class)
	public ResponseEntity<Message> error(ErrorException e) {
		return new ResponseEntity<Message>(new Message(e.getCode(), e.getMsg()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value="/{pathName}",method=RequestMethod.GET)
	public String workersSubView(@PathVariable String pathName) {
		return "workers/" + pathName;
	}
	
	@RequestMapping("getWorkersPage")
	@ResponseBody
	public Page<Workers> getWorkersPage(Pagination pagination){
		//TODO:模拟workers page数据
		Page<Workers> page = new Page<>();
		page.setTotal(6);
		List<Workers> list = new ArrayList<>();
		Workers w1 = new Workers();
		w1.setGender("男");
		w1.setName("w1");
		w1.setPosition("w1");
		w1.setUsersUsername("w1");
		Workers w2 = new Workers();
		w2.setGender("男");
		w2.setName("w2");
		w2.setPosition("w2");
		w2.setUsersUsername("w2");
		Workers w3 = new Workers();
		w3.setGender("男");
		w3.setName("w3");
		w3.setPosition("w3");
		w3.setUsersUsername("w3");
		list.add(w1);
		list.add(w2);
		list.add(w3);
		page.setRows(list);
		return page;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message addWorker(Workers worker, Userdetails  userdetail) {
		//TODO:模拟增加worker
		Message msg = new Message(StatusCode.SUCCESS, "成功");
		return msg;
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message updateWorker(Workers worker, Userdetails  userdetail) {
		//TODO:模拟修改worker
		Message msg = new Message(StatusCode.SUCCESS, "成功");
		return msg;
	}
	
	/**
	 * 删除多个学生的信息
	 * 
	 * @param usersUsernames
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Message deleteWorkers(String[] usersUsernames) {
		//TODO: 模拟删除
		return new Message(StatusCode.SUCCESS, "成功");
	}
}
