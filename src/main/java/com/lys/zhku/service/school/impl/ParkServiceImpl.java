package com.lys.zhku.service.school.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.ParkMapper;
import com.lys.zhku.model.Park;
import com.lys.zhku.service.impl.BaseServiceImpl;
import com.lys.zhku.service.school.ParkService;

@Service
public class ParkServiceImpl extends BaseServiceImpl<Park> implements ParkService<Park> {

	@Autowired
	protected ParkMapper parkMapper;

	@Override
	public int existEntity(Park record) {
		return 0;
	}
}
