package com.lys.zhku.web.students;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.pojo.dictionary.DataDict;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.impl.DataDictServiceImpl;
import com.lys.zhku.service.students.StudentsService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping(value = "/students")
public class StudentsController {

	@Autowired
	StudentsService studentsService;

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

	/**
	 * 获取Students管理的datagrid的页面路径
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String students() {
		return "students";
	}
	
	@RequestMapping("/getStudentsPage")
	@ResponseBody public Page<Students> getStudentsPage(Pagination pagination) {
		return studentsService.getStudentsPage(pagination);
	}

	/**
	 * 获取Students管理的子功能页面路径
	 * 
	 * @param pathName
	 * @return
	 */
	@RequestMapping(value = "/{pathName}", method = RequestMethod.GET)
	public String studentsSubView(@PathVariable String pathName) {
		return "students/" + pathName;
	}

	/**
	 * 新增一个学生的信息
	 * 
	 * @param student
	 * @param userdetail
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Message studentAdd(Students student, Userdetails userdetail) {
		studentsService.insertStudent(student, userdetail);
		return new Message(StatusCode.SUCCESS, "插入成功");
	}

	@RequestMapping(value = "/getDataDictListByKey")
	@ResponseBody
	public List<DataDict> getDataDictListByKey(@RequestParam String key) {
		return new DataDictServiceImpl().getDataDictList(key);
	}

	@RequestMapping(value = "/getDataDictListByParentId")
	@ResponseBody
	public List<DataDict> getDataDictListByParentId(@RequestParam Integer parentId) {
		return new DataDictServiceImpl().getDataDictListByParentId(parentId);
	}

}
