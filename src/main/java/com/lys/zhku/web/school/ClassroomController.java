package com.lys.zhku.web.school;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Classroom;
import com.lys.zhku.model.Datadict;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.ExportExcelService;
import com.lys.zhku.service.school.ClassroomService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/school/classroom")
public class ClassroomController {
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private ExportExcelService exportExcelService;

	@ExceptionHandler
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}
	
	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String view(@PathVariable String path) {
		return "school/classroom/" + path;
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<Classroom> getPage(Pagination pagination) {
		return classroomService.getPageByPagination(pagination);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message add(Classroom classroom) {
		classroom.setEnable(true);
		classroomService.insertClassroom(classroom);
		return new Message(StatusCode.SUCCESS, "插入记录成功");
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		classroomService.deleteClassrooms(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message edit(Classroom classroom) {
		classroomService.updateClassroom(classroom);
		return new Message(StatusCode.SUCCESS, "修改记录成功");
	}
	
	/**
	 * 导出所有记录信息
	 * @param response
	 */
	@RequestMapping(value="/exportAll")
	public void exportAllExcel(HttpServletResponse response) {
		List<Classroom> list = classroomService.getAll();
		exportExcelService.exportAll(list, response, Classroom.class);
	}

	/**
	 * 导出pks主键集合所指定的记录
	 * @param response
	 * @param pks
	 */
	@RequestMapping(value="/exportSelections")
	public void exportSelectionsExcel(HttpServletResponse response, String[] pks) {
		List<Classroom> list = classroomService.getByPrimaryKeys(pks);
		exportExcelService.exportAll(list, response, Classroom.class);
	}
}
