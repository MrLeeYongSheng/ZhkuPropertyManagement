package com.lys.zhku.web.system;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Datadict;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.ExportExcelService;
import com.lys.zhku.service.system.DatadictService;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/system/datadict")
public class DatadictController {

	@Autowired
	private DatadictService datadictService;
	
	@Autowired
	private ExportExcelService exportExcelService;

	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String view(@PathVariable String path) {
		return "system/datadict_" + path;
	}
	
	@RequestMapping("/getPage")
	@ResponseBody
	public Page<Datadict> getPage(Pagination pagination) {
		return datadictService.getDatadictPage(pagination);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message addDatadict(Datadict datadict) {
		datadict.setEnable(true);
		datadictService.insertDatadict(datadict);
		return new Message(StatusCode.SUCCESS, "插入数据字典成功");
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message deleteDatadict(Integer[] ids) {
		datadictService.deleteDatadictByIds(ids);
		return new Message(StatusCode.SUCCESS, "删除数据记录成功");
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message editDatadict(Datadict datadict) {
		datadictService.editDatadictByIds(datadict);
		return new Message(StatusCode.SUCCESS, "修改数据记录成功");
	}
	
	@RequestMapping(value = "/getDatadictListByDatadict")
	@ResponseBody
	public List<Datadict> getDatadictListByDatadict(Datadict datadict) {
		return datadictService.getListByDatadict(datadict);
	}	
	
	/**
	 * 导出所有记录信息
	 * @param response
	 */
	@RequestMapping(value="/exportAll")
	public void exportAllExcel(HttpServletResponse response) {
		List<Datadict> list = datadictService.getAll();
		exportExcelService.exportAll(list, response, Datadict.class);
	}

	/**
	 * 导出pks主键集合所指定的记录
	 * @param response
	 * @param pks
	 */
	@RequestMapping(value="/exportSelections")
	public void exportSelectionsExcel(HttpServletResponse response, String[] pks) {
		List<Datadict> list = datadictService.getByPrimaryKeys(pks);
		exportExcelService.exportAll(list, response, Datadict.class);
	}
}
