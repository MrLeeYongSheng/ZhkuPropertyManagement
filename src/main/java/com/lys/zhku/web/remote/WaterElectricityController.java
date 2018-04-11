package com.lys.zhku.web.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lys.zhku.model.Dormitory;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Message;
import com.lys.zhku.service.school.DormitoryService;
import com.lys.zhku.utils.StatusCode;
import com.waterelectricity.we.pojo.Charge;
import com.waterelectricity.we.service.WaterElectricityService;

@Controller
@RequestMapping("/remote/waterElectricity")
public class WaterElectricityController {
	
	@Autowired
	private WaterElectricityService waterElectricityService;
	
	@Autowired
	private DormitoryService dormitoryService;

	@ExceptionHandler(value=ErrorException.class)
	@ResponseBody
	public Message error(ErrorException e) {
		return new Message(e.getCode(), e.getMsg());
	}

	@RequestMapping(value="/dormitory/weChargeByDormId")
	@ResponseBody
	public Charge dormitoryWeChargeByDormCampus(@RequestParam Integer id) {
		return waterElectricityService.getChargeByDormitoryId(id);
	}

	@RequestMapping(value="/dormitory/weChargeByUsername")
	@ResponseBody
	public Charge dormitoryWeCharge(@RequestParam String usersUsername) {
		Dormitory dorm = dormitoryService.getFromStudentsByUserUsername(usersUsername);
		if(dorm==null) {
			throw new ErrorException(StatusCode.ERROR, "宿舍不存在,查询失败");
		}
		return waterElectricityService.getChargeByDormitoryId(dorm.getId());
	}
}
