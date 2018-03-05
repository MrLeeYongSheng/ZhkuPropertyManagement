package com.lys.zhku.pojo.web;

import java.util.Collection;

public class Page<T> {

	private Integer total;//数据库的总记录数
	private Collection<T> rows;//实际的记录集合
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Collection<T> getRows() {
		return rows;
	}
	public void setRows(Collection<T> rows) {
		this.rows = rows;
	}

}
