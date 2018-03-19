package com.lys.zhku.service;

import com.lys.zhku.pojo.web.Page;
import com.lys.zhku.pojo.web.Pagination;

/**
 * 使用规则:<br>
 * 1.Service接口必须继承BaseSchoolService接口<br>
 * 
 * 2.ServiceImpl必须继承BaseSchoolServiceImpl
 * 
 * 3.Service必须有注入其Model相关的Mapper,<br>
 * 且名字要符合首字母小写的model名后面再加"Mapper"的命名规范<br>
 * 如:其Model名为Hello则其Mapper名需要定义为helloMapper
 * 
 * @author MrLeeYongSheng
 *
 * @param <T> 填充的泛型为使用者的Model
 */
public interface BaseService<T> {

	/**
	 * 根据分页参数查询分页记录
	 * @param pagination
	 * @return
	 */
	Page<T> getPageByPagination(Pagination pagination);

	/**
	 * 插入记录
	 * @param record
	 * @return
	 */
	int insertEntity(T record);

	/**
	 * 记录是否存在
	 * @param record
	 * @return
	 */
	int existEntity(T record);

	/**
	 * 根据传进来的数组id删除对应记录
	 * @param ids
	 * @return
	 */
	int deleteEntitys(Integer[] ids);

	/**
	 * 根据主键修改记录
	 * @param record
	 * @return
	 */
	int updateEntity(T record);

}
