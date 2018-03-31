package com.lys.zhku.service.workers;

import java.util.List;

import com.lys.zhku.model.Userdetails;
import com.lys.zhku.model.Workers;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;

public interface WorkersService {
	/**
	 * 插入一条员工记录,并创建默认账号
	 * @param worker
	 * @param userdetail
	 * @return
	 */
	Integer insertWorker(Workers worker, Userdetails userdetail);

	/**
	 * 更新一条员工记录
	 * @param worker
	 * @param userdetail
	 * @return
	 */
	Integer updateWorker(Workers worker, Userdetails userdetail);
	
	/**
	 * 获取员工的Workers表的数据分页记录
	 * @param pagination
	 * @return
	 */
	Page<Workers> getWorkersPage(Pagination pagination);
	
	/**
	 * 物理删除:根据usersUsernames数组删除对应的记录
	 * @param usersUsernames
	 * @return
	 */
	Integer deleteWorkersByUsersUsernames(String[] usersUsernames);

	int deleteWorkersByUsersUsernamesInMemory(String[] usersUsernames);
	
	/**
	 * 获取所有信息
	 * @return
	 */
	List<Workers> getAll();

	/**
	 * 根据主键数组获取对应记录
	 * @param pks
	 * @return
	 */
	List<Workers> getByPrimaryKeys(String[] pks);
}
