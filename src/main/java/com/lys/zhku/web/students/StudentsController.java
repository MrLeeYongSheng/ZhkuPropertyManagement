package com.lys.zhku.web.students;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Students;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.model.dictionary.DataDict;
import com.lys.zhku.service.DataDictService;

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
	@ResponseBody public Students studentAdd(Students student, Userdetails userdetail) {
		System.out.println(userdetail);
		return student;
	}

	@RequestMapping(value="/getDataDictListByKey")
	@ResponseBody public List<DataDict> getDataDictListByKey(@RequestParam String key) {
		return new DataDictService().getDataDictList(key);
	}

	@RequestMapping(value="/getDataDictListByParentId")
	@ResponseBody public List<DataDict> getDataDictListByParentId(@RequestParam Integer parentId) {
		return new DataDictService().getDataDictListByParentId(parentId);
	}
}
