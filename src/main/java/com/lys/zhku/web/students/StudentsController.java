package com.lys.zhku.web.students;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Students;

@Controller
@RequestMapping(value="/students")
public class StudentsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String students() {
		return "students";
	}
	
	@RequestMapping(value = "/{pathName}", method = RequestMethod.GET)
	public String studentsSubView(@PathVariable String pathName) {
		return "students/" + pathName;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody public Students studentAdd(Students st) {
	
		return st;
	}
}
