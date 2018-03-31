package com.lys.zhku.service.school.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.ClassroomMapper;
import com.lys.zhku.model.Classroom;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.impl.BaseServiceImpl;
import com.lys.zhku.service.school.ClassroomService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.StatusCode;

@Service
public class ClassroomServiceImpl extends BaseServiceImpl<Classroom> implements ClassroomService {
	
	@Autowired
	private ClassroomMapper classroomMapper;

	@Override
	public Page<Classroom> getPageByPagination(Pagination pagination) {
		Page<Classroom> page = new Page<>();
		int count = classroomMapper.selectCountByPagination(pagination);
		page.setTotal(count);
		if(count<1) {
			page.setRows(new ArrayList<>());
			return page;
		}
		List<Classroom> list = classroomMapper.selectByPagination(pagination);
		page.setRows(list);
		return page;
	}

	@Override
	public int insertClassroom(Classroom classroom) {
		if(classroom==null || !ModelUtils.isNotNullForAllNotNullFieldExceptPrimaryKey(classroom)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的教室信息,缺失必要的请求参数");
		}
		return classroomMapper.insert(classroom);
	}

	@Override
	public int deleteClassrooms(Integer[] ids) {
		if(CollectionUtils.isEmpty(ids)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return classroomMapper.deleteByPrimaryKeys(ids);
	}

	@Override
	public int updateClassroom(Classroom classroom) {
		if(classroom==null || !ModelUtils.isNotNullForAllNotNullField(classroom)) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "不完整的教室信息,缺失必要的请求参数");
		}
		return classroomMapper.updateByPrimaryKey(classroom);
	}

	@Override
	public int existEntity(Classroom record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
