package com.lys.zhku.pojo.web;

public class Pagination {

	private Integer rows;// pageSize
	private Integer page;// pageNumber
	private Integer index;// 数据库的开始记录的下标

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getIndex() {
		return (page-1)*rows;
	}

	public Boolean isIllegal() {
		return rows == null || page == null || rows <= 0 || page <= 0;
	}
}
