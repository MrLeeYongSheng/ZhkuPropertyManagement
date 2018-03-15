package com.lys.zhku.web.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.ClassroomSchedule;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.school.ClassroomScheduleService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/school/classroom/schedule")
public class ClassroomScheduleController {
	
	@Autowired
	private ClassroomScheduleService classroomScheduleService;

	@ExceptionHandler
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}
	
	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String view(@PathVariable String path) {
		return "school/classroom/schedule/" + path;
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<ClassroomSchedule> getPage(Pagination pagination) {
		return classroomScheduleService.getPageByPagination(pagination);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message add(ClassroomSchedule classroomSchedule) {
		classroomSchedule.setEnable(true);
		classroomScheduleService.insertClassroomSchedule(classroomSchedule);
		return new Message(StatusCode.SUCCESS, "插入记录成功");
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		classroomScheduleService.deleteClassroomSchedule(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message edit(ClassroomSchedule classroomSchedule) {
		classroomScheduleService.updateClassroomSchedule(classroomSchedule);
		return new Message(StatusCode.SUCCESS, "修改记录成功");
	}
}
