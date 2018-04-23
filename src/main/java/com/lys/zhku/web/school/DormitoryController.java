package com.lys.zhku.web.school;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Dormitory;
import com.lys.zhku.model.Files;
import com.lys.zhku.model.PersonalFiles;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.pojo.web.PersonalFilesPagination;
import com.lys.zhku.service.ExportExcelService;
import com.lys.zhku.service.FTPClientService;
import com.lys.zhku.service.files.PersonalFilesService;
import com.lys.zhku.service.school.DormitoryService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.StatusCode;

@Controller
@RequestMapping("/school/dormitory")
public class DormitoryController {
	
	private static Logger log = Logger.getLogger(DormitoryController.class);
	
	@Autowired
	private DormitoryService dormitoryService;
	
	@Autowired
	private ExportExcelService exportExcelService;
	
	@Autowired
	private PersonalFilesService personalFilesService;
	
	@Autowired
	private FTPClientService ftpClientService;
	
	@Autowired
	private Environment env; 

	@ExceptionHandler
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}
	
	@RequestMapping(value="/{path}", method=RequestMethod.GET)
	public String view(@PathVariable String path) {
		return "school/dormitory/" + path;
	}

	@RequestMapping(value="/getPage")
	@ResponseBody
	public Page<Dormitory> getPage(Pagination pagination) {
		return dormitoryService.getPageByPagination(pagination);
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public Message add(Dormitory dormitory) {
		dormitory.setEnable(true);
		dormitory.setNumber(0);
		dormitoryService.insertDormitory(dormitory);
		return new Message(StatusCode.SUCCESS, "插入记录成功");
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public Message delete(Integer[] ids) {
		dormitoryService.deleteDormitorys(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public Message edit(Dormitory dormitory) {
		dormitoryService.updateDormitory(dormitory);
		return new Message(StatusCode.SUCCESS, "修改记录成功");
	}
	
	/**
	 * 导出所有记录信息
	 * @param response
	 */
	@RequestMapping(value="/exportAll")
	public void exportAllExcel(HttpServletResponse response) {
		List<Dormitory> list = dormitoryService.getAll();
		exportExcelService.exportAll(list, response, Dormitory.class);
	}

	/**
	 * 导出pks主键集合所指定的记录
	 * @param response
	 * @param pks
	 */
	@RequestMapping(value="/exportSelections")
	public void exportSelectionsExcel(HttpServletResponse response, String[] pks) {
		List<Dormitory> list = dormitoryService.getByPrimaryKeys(pks);
		exportExcelService.exportAll(list, response, Dormitory.class);
	}
	
	/**
	 * 上传宿舍维修表
	 * @param file
	 * @param username
	 * @return
	 */
	@RequestMapping(value="/uploadFixExcel")
	@ResponseBody
	public Message uploadFixExcel(@RequestPart Part file, @RequestParam String username) {
		Dormitory dormitory = dormitoryService.getFromStudentsByUserUsername(username);
		if(dormitory==null) {
			return new Message(StatusCode.NOT_FOUND, "学生所在宿舍不存在,上传失败");
		}
		String fileName = file.getSubmittedFileName();
		int index = fileName.indexOf(".");
		int length = fileName.length();
		boolean indexFlag = (index!=-1) && (index!=length); 
		if(!indexFlag || !(".xls".equals(fileName.substring(index, length)) || 
						".xlsx".equals(fileName.substring(index, length)))) {
			return new Message(StatusCode.ERROR, "非xls,xlsx文件,上传失败");
		}
		String parentDir = env.getProperty("dormitory.root","/error") + 
				"/" + dormitory.getCampus() + "/" + dormitory.getName();
		PersonalFiles pf = null;
		
		List<Files> files = ftpClientService.uploadFileToFtpServer(new Part[] {file}, parentDir);
		if(CollectionUtils.isEmpty(files)) {
			return new Message(StatusCode.NOT_FOUND, "上传文件到ftp服务器失败");
		}
		pf = new PersonalFiles();
		pf.convertFromFiles(files.get(0));
		pf.setUsersUsername(username);
		personalFilesService.insertEntity(pf);
		return new Message(StatusCode.SUCCESS, "上传成功");
	}	
	
	/**
	 * 获取宿舍维修表分页
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/getFixExcelPage")
	@ResponseBody
	public Page<PersonalFiles> getFixExcelPage(PersonalFilesPagination pagination) {
		pagination.setPositionPrefixLike(env.getProperty("dormitory.root"));
		return personalFilesService.getPageByPagination(pagination);
	}

	/**
	 * 删除宿舍维修表
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/deleteFixExcel", method=RequestMethod.POST)
	@ResponseBody
	public Message deleteFixExcel(Integer[] ids) {
		List<Files> filesList = (List<Files>) personalFilesService.selectUuidNameAndPositionByPrimaryKeys(ids);
		ftpClientService.deleteByFiles(filesList);
		personalFilesService.deleteEntitys(ids);
		return new Message(StatusCode.SUCCESS, "删除记录成功");
	}
	
	/**
	 * 下载宿舍维修表
	 * @param response
	 * @param id
	 */
	@RequestMapping("/downloadFixExcel")
	public void downloadFixExcel(HttpServletResponse response, Integer id) {
		if(response==null || id==null) {
			log.error("HttpServletResponse is null or id is null");
			throw new ErrorException(StatusCode.ERROR, "HttpServletResponse is null or id is null");
		}
		PersonalFiles file = personalFilesService.selectByPrimaryKey(id);
		ftpClientService.downloadFilesToResponse(file,response);	
	}	
}
