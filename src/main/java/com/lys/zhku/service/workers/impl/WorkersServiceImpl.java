package com.lys.zhku.service.workers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.zhku.mapper.UserdetailsMapper;
import com.lys.zhku.mapper.UsersRolesMapper;
import com.lys.zhku.mapper.WorkersMapper;
import com.lys.zhku.model.Userdetails;
import com.lys.zhku.model.Users;
import com.lys.zhku.model.Workers;
import com.lys.zhku.pojo.exception.ErrorException;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.users.UsersService;
import com.lys.zhku.service.workers.WorkersService;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.ModelUtils;
import com.lys.zhku.utils.PasswordUtils;
import com.lys.zhku.utils.StatusCode;

@Service
public class WorkersServiceImpl implements WorkersService {
	
	@Autowired
	private WorkersMapper workersMapper;

	@Autowired
	private UserdetailsMapper userdetailsMapper;
	
	@Autowired
	private UsersRolesMapper usersRolesMapper;
	
	@Autowired
	private UsersService usersService;
	
	@Override
	public Integer insertWorker(Workers worker, Userdetails userdetail) {
		//检查model
		if(worker==null || userdetail==null || !(ModelUtils.isNotNullForAllNotNullField(worker) && ModelUtils.isNotNullForAllNotNullField(userdetail))) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "缺失必要字段");
		}
		
		//插入用户
		Users users = new Users();
		users.setEnable(true);
		users.setNickname(worker.getName());
		users.setPassword(PasswordUtils.DEFAULT_PASSWORD);
		users.setUsername(worker.getUsersUsername());
		Integer userStatus = usersService.insertUserForworkers(users);
		if(userStatus==0) {
			throw new ErrorException(StatusCode.EXIST, "账号已存在");
		}
		//插入workers
		int workerStatus = workersMapper.insert(worker);
		//插入userDetails
		int userdetailStatus = userdetailsMapper.insert(userdetail);
		
		if(workerStatus+userdetailStatus<2) {
			throw new ErrorException(StatusCode.ERROR, "插入数据 发生内部错误");
		}
		
		return StatusCode.SUCCESS;
	}

	@Override
	public Integer updateWorker(Workers worker, Userdetails userdetail) {
		//检查model
		if(worker==null || userdetail==null || !(ModelUtils.isNotNullForAllNotNullField(worker) && ModelUtils.isNotNullForAllNotNullField(userdetail))) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "缺失必要字段");
		}
		
		//更新workers
		int workerStatus = workersMapper.updateByPrimaryKey(worker);
		//更新userDetails
		int userdetailStatus = userdetailsMapper.updateByPrimaryKey(userdetail);
		
		if(workerStatus+userdetailStatus<2) {
			throw new ErrorException(StatusCode.ERROR, "更新数据 发生内部错误");
		}
		
		return StatusCode.SUCCESS;
	}

	@Override
	public Page<Workers> getWorkersPage(Pagination pagination) {
		if(pagination.isIllegal()) {
			throw new ErrorException(StatusCode.INCOMPLETE_MODEL_DATA, "传入的数据参数有错");
		}
		Page<Workers> page = new Page<>();
		int total = workersMapper.selectTotalForPagination(pagination);
		page.setTotal(total);
		if(total<1) {
			page.setRows(new ArrayList<Workers>());
			return page;
		}
		List<Workers> list = workersMapper.selectForPagination(pagination);
		page.setRows(list);
		return page;
	}

	@Override
	public Integer deleteWorkersByUsersUsernames(String[] usersUsernames) {
		//错误逻辑交给usersService.updateUserEnableByUsernames方法处理
		return usersService.updateUserEnableByUsernames(usersUsernames, false);
	}

	@Override
	public int deleteWorkersByUsersUsernamesInMemory(String[] usersUsernames) {
		usersRolesMapper.deleteByUsernames(usersUsernames);
		workersMapper.deleteByUsernames(usersUsernames);
		userdetailsMapper.deleteByUsernames(usersUsernames);
		return usersService.deleteByUsernamesInMemory(usersUsernames);
	}
	
	@Override
	public List<Workers> getAll() {
		return workersMapper.selectAll();
	}

	@Override
	public List<Workers> getByPrimaryKeys(String[] pks) {
		if(CollectionUtils.isEmpty(pks)) {
			throw new ErrorException(StatusCode.MISSING_REQUEST_PARAM, "缺失请求参数");
		}
		return workersMapper.selectByPrimaryKeys(pks);
	}

}
