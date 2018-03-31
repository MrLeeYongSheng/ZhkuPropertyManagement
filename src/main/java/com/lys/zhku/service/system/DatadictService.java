package com.lys.zhku.service.system;

import java.util.List;

import com.lys.zhku.model.Datadict;
import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.service.BaseService;


public interface DatadictService extends BaseService<Datadict> {

	int insertDatadict(Datadict datadict);

	/**
	 * 获取数据字典分页
	 * @param pagination 其Boolean enable为null时enable为true及false的记录均获取
	 * @return
	 */
	Page<Datadict> getDatadictPage(Pagination pagination);

	/**
	 * 根据主键数组删除记录
	 * @param ids
	 * @return
	 */
	int deleteDatadictByIds(Integer[] ids);

	/**
	 * 修改数据字典
	 * @param datadict
	 * @return
	 */
	int editDatadictByIds(Datadict datadict);
	
	/**
	 * 根据数据字典的字段进行查询
	 * @param datadict
	 * @return
	 */
	List<Datadict> getListByDatadict(Datadict datadict);
}