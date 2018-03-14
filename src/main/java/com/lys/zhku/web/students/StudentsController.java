package com.lys.zhku.web.students;

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

import com.lys.zhku.model.Datadict;
import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.pojo.web.StudentsPagination;
import com.lys.zhku.service.students.StudentsService;
import com.lys.zhku.service.system.DatadictService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping(value = "/students")
public class StudentsController {

	@Autowired
	private StudentsService studentsService;

	@Autowired
	private DatadictService datadictService;

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
	 * 获取students的datagrid页面
	 * 
	 * @param pagination
	 * @return
	 */
	@RequestMapping("/getStudentsPage")
	@ResponseBody
	public Page<Students> getStudentsPage(StudentsPagination pagination) {
		pagination.setEnable(true);
		return studentsService.getStudentsPage(pagination);
	}

	/**
	 * 获取Students管理的功能页面路径
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
	
	/**
	 * 修改一个学生的信息
	 * 
	 * @param student
	 * @param userdetail
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Message studentEdit(Students student, Userdetails userdetail) {
		studentsService.updateStudent(student, userdetail);
		return new Message(StatusCode.SUCCESS, "修改成功");
	}	

	/**
	 * 删除多个学生的信息
	 * 
	 * @param usersUsernames
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Message studentDelete(String[] usersUsernames) {
		studentsService.deleteStudentsByUsersUsernames(usersUsernames);
		return new Message(StatusCode.SUCCESS, "修改成功");
	}	

	@RequestMapping(value = "/getDataDictListByKey")
	@ResponseBody
	public List<Datadict> getDataDictListByKey(@RequestParam String key) {
		return datadictService.getDataDictList(key);
	}

	@RequestMapping(value = "/getDataDictListByParentId")
	@ResponseBody
	public List<Datadict> getDataDictListByParentId(@RequestParam Integer parentId) {
		return datadictService.getDataDictListByParentId(parentId);
	}

	@RequestMapping(value = "/getDatadictListByDatadict")
	@ResponseBody
	public List<Datadict> getDatadictListByDatadict(Datadict datadict) {
		return datadictService.getListByDatadict(datadict);
	}

}
