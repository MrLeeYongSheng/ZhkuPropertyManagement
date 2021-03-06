package com.lys.zhku.service.school.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.ClassroomScheduleMapper;
import com.lys.zhku.model.ClassroomSchedule;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.impl.BaseServiceImpl;
import com.lys.zhku.service.school.ClassroomScheduleService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.StatusCode;

@Service
public class ClassroomScheduleServiceImpl extends BaseServiceImpl<ClassroomSchedule> implements ClassroomScheduleService {
	
	@Autowired
	private ClassroomScheduleMapper classroomScheduleMapper;

	@Override
	public Page<ClassroomSchedule> getPageByPagination(Pagination pagination) {
		Page<ClassroomSchedule> page = new Page<>();
		int count = classroomScheduleMapper.selectCountByPagination(pagination);
		page.setTotal(count);
		if(count<1) {
			page.setRows(new ArrayList<>());
			return page;
		}
		List<ClassroomSchedule> list = classroomScheduleMapper.selectByPagination(pagination);
		page.setRows(list);
		return page;
	}

	@Override
	public int insertClassroomSchedule(ClassroomSchedule classroomSchedule) {
		if(classroomSchedule==null || !ModelUtils.isNotNullForAllNotNullFieldExceptPrimaryKey(classroomSchedule)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的教室安排表信息,缺失必要的请求参数");
		}
		return classroomScheduleMapper.insert(classroomSchedule);
	}

	@Override
	public int deleteClassroomSchedule(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return classroomScheduleMapper.deleteByPrimaryKeys(ids);
	}

	@Override
	public int updateClassroomSchedule(ClassroomSchedule classroomSchedule) {
		if(classroomSchedule==null || !ModelUtils.isNotNullForAllNotNullField(classroomSchedule)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的教室安排表信息,缺失必要的请求参数");
		}
		return classroomScheduleMapper.updateByPrimaryKey(classroomSchedule);
	}

	@Override
	public int existEntity(ClassroomSchedule record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
