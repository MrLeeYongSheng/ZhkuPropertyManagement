package com.lys.zhku.common;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.lys.zhku.anno.NameMapping;
import com.lys.zhku.model.Files;
import com.lys.zhku.model.Park;
import com.lys.zhku.model.PersonalFiles;
import com.lys.zhku.model.Students;
import com.lys.zhku.service.impl.ExportExcelServiceImpl;
import com.lys.zhku.utils.StringUtils;

//@RunWith(value=SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=RootConfig.class)
public class CommonTest {
	
	private static Logger log = Logger.getLogger(CommonTest.class);

	//@Autowired
	//Environment env;
	
	

	
	@Test
	public void test() throws Exception {
	}

	@Test
	public void testExcel() throws Exception {
		File file = new File("D:/a.xls");
		Workbook create = new HSSFWorkbook();
		
		/*workbook.setSheetName(0, "hello");
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("hello");
		workbook.close();*/
		//Workbook create = WorkbookFactory.create();
		Sheet sheet = create.createSheet("hello");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("hello");		
		create.write(new FileOutputStream(file));
		create.close();
	}
	
	
	
	
	@Test
	public void testProperties() throws Exception {
		NameMapping typeAnno = TestNameMappingAnno.class.getDeclaredAnnotation(NameMapping.class);
		System.out.println(typeAnno.value());
		Field[] declaredFields = TestNameMappingAnno.class.getDeclaredFields();
		for (Field field : declaredFields) {
			String name = field.getName();
			NameMapping declaredAnnotation = field.getDeclaredAnnotation(NameMapping.class);
			if(declaredAnnotation!=null) {
				String value = declaredAnnotation.value();
				System.out.println(name+" -- " + value);
			}
		}
	}

	@Test
	public void testTx() throws Exception {
		ExportExcelServiceImpl e = new ExportExcelServiceImpl();
		Collection<Students> coll = new ArrayList<>();
		Students s1 = new Students();
		s1.setCampus("cam1");
		s1.setClassnum(1);
		s1.setDepartment("depart1");
		s1.setDormitory("a1");
		s1.setGender("n1");
		s1.setGrade(1);
		s1.setMajor("ma1");
		s1.setName("s1");
		s1.setUsersUsername("11");
		coll.add(s1);
		Students s2 = new Students();
		s2.setCampus("cam2");
		s2.setClassnum(2);
		s2.setDepartment("depart2");
		s2.setDormitory("a2");
		s2.setGender("n2");
		s2.setGrade(2);
		s2.setMajor("ma2");
		s2.setName("s2");
		s2.setUsersUsername("22");
		coll.add(s2);
		Students s3 = new Students();
		s3.setCampus("cam3");
		s3.setDepartment("depart3");
		s3.setDormitory("a3");
		s3.setGrade(3);
		s3.setName("s3");
		coll.add(s3);
		e.exportAll(coll , null, Students.class);
	}
	

	@Test
	public void testSet() {
		Park park = new Park();
		park.setEnable(true);
		park.setBook(true);
		park.setEntryTime(new Date());
		park.setCampus("");
		park.setSiteNum("");
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Park>> validate = validator.validate(park);
		System.out.println(validate.size());
	}

	@Test
	public void testSimpleGrantedAuthority() {
		assertEquals(new SimpleGrantedAuthority("a"), new SimpleGrantedAuthority("a"));
	}
}
