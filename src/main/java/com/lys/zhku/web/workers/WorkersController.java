package com.lys.zhku.web.workers;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lys.zhku.service.workers.WorkersService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/workers")
public class WorkersController {
	
	@Autowired
	private WorkersService workersService;
	
	/**
	 * 用来处理异常ErrorException的情况
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}

	@RequestMapping(value="/{pathName}",method=RequestMethod.GET)
	public String workersSubView(@PathVariable String pathName) {
		return "workers/" + pathName;
	}
	
	@RequestMapping("getWorkersPage")
	@ResponseBody
	public Page<Workers> getWorkersPage(Pagination pagination){
		return workersService.getWorkersPage(pagination);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message addWorker(Workers worker, Userdetails  userdetail) {
		workersService.insertWorker(worker, userdetail);
		Message msg = new Message(StatusCode.SUCCESS, "成功");
		return msg;
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message updateWorker(Workers worker, Userdetails  userdetail) {
		workersService.updateWorker(worker, userdetail);
		Message msg = new Message(StatusCode.SUCCESS, "成功");
		return msg;
	}
	
	/**
	 * 删除多个工人的信息
	 * 
	 * @param usersUsernames
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Message deleteWorkers(String[] usersUsernames) {
		workersService.deleteWorkersByUsersUsernamesInMemory(usersUsernames);
		return new Message(StatusCode.SUCCESS, "成功");
	}
}
