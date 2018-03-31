package com.lys.zhku.service;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

public interface ExportExcelService {

	<T> void exportAll(Collection<T> coll, HttpServletResponse response, Class<?> clazz);

}
