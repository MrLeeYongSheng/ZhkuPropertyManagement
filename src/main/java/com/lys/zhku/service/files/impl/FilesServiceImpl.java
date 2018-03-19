package com.lys.zhku.service.files.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.FilesMapper;
import com.lys.zhku.model.Files;
import com.lys.zhku.service.files.FilesService;
import com.lys.zhku.service.impl.BaseServiceImpl;

@Service
public class FilesServiceImpl extends BaseServiceImpl<Files> implements FilesService<Files> {

	@Autowired
	private FilesMapper filesMapper;

	@Override
	public int existEntity(Files record) {
		return 0;
	}
}
