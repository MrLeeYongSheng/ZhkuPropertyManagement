package com.lys.zhku.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.lys.zhku.anno.NameMapping;
import com.lys.zhku.service.ExportExcelService;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {
	
	private static Logger log = Logger.getLogger(ExportExcelServiceImpl.class);

	@Override
	public <T> void exportAll(Collection<T> coll, HttpServletResponse response, Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		Map<Integer, String> map = new HashMap<>();//用来存放Excel列号与字段名的映射
		List<String> titleList = new ArrayList<>();
		int i=0;
		for (Field field : fields) {
			NameMapping fieldNameMapping = field.getDeclaredAnnotation(NameMapping.class);
			if(fieldNameMapping!=null) {
				String mFieldName = fieldNameMapping.value();//字段名映射
				titleList.add(mFieldName);
				String fieldName = field.getName();//字段名
				map.put(i, fieldName);
				i++;
			}
		}
		int rownum = 0;//记录记录的下标
		//设置表头
		NameMapping classNameMapping = clazz.getDeclaredAnnotation(NameMapping.class);
		String mClassName = "信息表";//title,类名的映射
		if(classNameMapping!=null) {
			mClassName = classNameMapping.value();
		}
		XSSFWorkbook wk = new XSSFWorkbook();
		XSSFSheet sheet = wk.createSheet(mClassName);
		
		//标题
		//合并单元格
		CellRangeAddress region =new CellRangeAddress(0, 0, 0, i-1);
		sheet.addMergedRegion(region);
		XSSFRow firstRow = sheet.createRow(rownum++);//0
		XSSFCell firstCell = firstRow.createCell(0);
		//主标题样式
		XSSFCellStyle fstyle = wk.createCellStyle();
		fstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		fstyle.setFillForegroundColor(new XSSFColor(IndexedColors.SKY_BLUE, new DefaultIndexedColorMap()));
		fstyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		firstCell.setCellStyle(fstyle);//设置标题样式
		//标题样式 end
		firstCell.setCellValue(mClassName);
		//标题 end
		
		//子标题
		//子标题样式
		XSSFCellStyle style = wk.createCellStyle();
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFillForegroundColor(new XSSFColor(IndexedColors.YELLOW, new DefaultIndexedColorMap()));
		style.setBorderBottom(BorderStyle.THICK);
		style.setBorderTop(BorderStyle.THICK);
		style.setBorderRight(BorderStyle.THICK);
		style.setBorderLeft(BorderStyle.THICK);
		style.setAlignment(HorizontalAlignment.CENTER);//水平居中
		XSSFRow secondRow = sheet.createRow(rownum++);//1
		for(int j=0; j<i; j++) {
			sheet.setColumnWidth(j, 20*256);//设置宽度
			String titleName = titleList.get(j);
			XSSFCell iCell = secondRow.createCell(j);
			iCell.setCellStyle(style);
			iCell.setCellValue(titleName);
		}
		//设置表头 end
		
		//获取集合的元素并写到Excel
		Iterator<T> iterator = coll.iterator();
		while(iterator.hasNext()) {
			XSSFRow createRow = sheet.createRow(rownum++);
			T next = iterator.next();
			for(int j=0; j<i; j++) {
				//获取字段值
				String name = map.get(j);
				Object invokeResult = null;
				String getMethodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				try {
					invokeResult = next.getClass().getMethod(getMethodName).invoke(next);
				} catch (Exception e) {
					String isMethodName = "is" + name.substring(0, 1).toUpperCase() + name.substring(1);
					try {
						invokeResult = next.getClass().getMethod(isMethodName).invoke(next);
						if(log.isInfoEnabled()) log.info("执行方法:"+isMethodName);
					} catch (Exception e1) {
						log.error("不存在方法:"+getMethodName+", "+isMethodName, e1);
					}
				}
				//获取字段值 end
				XSSFCell createCell = createRow.createCell(j);
				createCell.setCellValue(""+ (invokeResult==null?"":invokeResult));
			}
		}
		
		//获取集合的元素并写到Excel end
		try {
			//Excel文件流返回浏览器
			//response.setCharacterEncoding("UTF-8");下面的charset=utf-8会覆盖这里
			response.setContentType("multipart/form-data;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename="+new String(mClassName.getBytes("UTF-8"),"ISO8859-1")+".xlsx");
			OutputStream outputStream = response.getOutputStream();
			wk.write(outputStream);
			outputStream.flush();
			outputStream.close();
			response.flushBuffer();
			//Excel文件流返回浏览器 end
			wk.close();
		} catch (IOException e) {
			log.error("传输Excel文件流失败", e);
		}
	}

}
