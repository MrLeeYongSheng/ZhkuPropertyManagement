package com.lys.zhku.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.sun.xml.internal.txw2.IllegalAnnotationException;

public class PropertiesUtils {
	
	private static final String SEPARATOR = System.getProperty("file.separator","/");

	private static final String DEFAULT_ENCODING = "UTF-8";

	private static Properties prop = null;
	
	private static ConcurrentMap<String, Properties> map = new ConcurrentHashMap<>();
	
	private PropertiesUtils() {}
	
	/**
	 * Using the properties file. It will loading the properties file if not loading.<br>
	 * please call setPath before!
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 * @see #use(String, String)
	 */
	public static Properties use(String fileName) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		if(fileName.contains("\\")) {
			int lastIndexOf = fileName.lastIndexOf("\\");
			return use(fileName.substring(0, lastIndexOf), fileName.substring(lastIndexOf+1),DEFAULT_ENCODING);
		} else if(fileName.contains("/")) {
			int lastIndexOf = fileName.lastIndexOf("/");
			return use(fileName.substring(0, lastIndexOf), fileName.substring(lastIndexOf+1),DEFAULT_ENCODING);
		}
		return use("", fileName, DEFAULT_ENCODING);
	}
	
	/**
	 * Using the properties file. It will loading the properties file if not loading.<br>
	 * please call setPath before!
	 * <p>
	 * Example:<br>
	 * use("config.txt", "UTF-8");<br>
	 * use("other_config.txt", "UTF-8");<br><br>
	 * String userName = get("userName");<br>
	 * String password = get("password");<br><br>
	 * 
	 * userName = use("other_config.txt").get("userName");<br>
	 * password = use("other_config.txt").get("password");<br><br>
	 * 
	 * use("com/jfinal/config_in_sub_directory_of_classpath.txt");
	 * 
	 * @param fileName the properties file's name in classpath or the sub directory of classpath
	 * @param basePath the parent dir path
	 * @param encoding the encoding
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	public static Properties use(String basePath, String fileName,String encoding) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		Properties result = map.get(fileName);
		if (result == null) {
			if(basePath==null) {
				throw new NullPointerException("basePath can't be null");
			}
			if(StringUtils.isEmpty(fileName)) {
				throw new IllegalArgumentException("fileName can't be null or empty(\"\")");
			}
			if(basePath!="" && basePath.lastIndexOf("\\")!=basePath.length()-1 && basePath.lastIndexOf("/")!=basePath.length()-1) {
				basePath = basePath + SEPARATOR;
			}
			result = new Properties();
			result.load(new InputStreamReader(new FileInputStream(basePath+fileName), encoding));
			map.put(fileName, result);
			if (PropertiesUtils.prop == null)
				PropertiesUtils.prop = result;
		}
		return result;
	}
	
	/**
	 * Using the properties file bye File object. It will loading the properties file if not loading.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 * @see #use(File, String)
	 */
	public static Properties use(File file) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		return use(file, DEFAULT_ENCODING);
	}
	
	/**
	 * Using the properties file bye File object. It will loading the properties file if not loading.
	 * <p>
	 * Example:<br>
	 * use(new File("/var/config/my_config.txt"), "UTF-8");<br>
	 * Strig userName = use("my_config.txt").get("userName");
	 * 
	 * @param file the properties File object
	 * @param encoding the encoding
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	public static Properties use(File file, String encoding) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		Properties result = map.get(file.getName());
		if (result == null) {
			result = new Properties();
			result.load(new InputStreamReader(new FileInputStream(file), encoding));
			map.put(file.getName(), result);
			if (prop == null)
				prop = result;
		}
		return result;
	}
	
	public static Properties useless(String fileName) {
		Properties previous = map.remove(fileName);
		if (prop == previous)
			prop = null;
		return previous;
	}
	
	public static void clear() {
		prop = null;
		map.clear();
	}
	
	public static Properties getProp() {
		if (prop == null)
			throw new IllegalStateException("Load propties file by invoking use(String fileName) method first.");
		return prop;
	}
	
	public static Properties getProp(String fileName) {
		return map.get(fileName);
	}
	
	public static String get(String key) {
		return getProp().getProperty(key);
	}
	
	public static String get(String key, String defaultValue) {
		return getProp().getProperty(key, defaultValue);
	}
	
	public static Integer getInt(String key) {
		return Integer.valueOf(getProp().getProperty(key));
	}
	
	public static Integer getInt(String key, Integer defaultValue) {
		Integer result = null;
		try {
			result = Integer.valueOf(getProp().getProperty(key));
		} catch (Exception e) {
			result = defaultValue;
		}
		return result;
	}
	
	public static Long getLong(String key) {
		return Long.valueOf(getProp().getProperty(key));
	}
	
	public static Long getLong(String key, Long defaultValue) {
		Long result = null;
		try {
			result = Long.valueOf(getProp().getProperty(key));
		} catch (Exception e) {
			result = defaultValue;
		}
		return result;
	}
	
	public static Boolean getBoolean(String key) {
		return Boolean.valueOf(getProp().getProperty(key));
	}
	
	public static Boolean getBoolean(String key, Boolean defaultValue) {
		Boolean result = null;
		try {
			result = Boolean.valueOf(getProp().getProperty(key));
		} catch (Exception e) {
			result = defaultValue;
		}
		return result;
	}
	
	public static boolean containsKey(String key) {
		return getProp().containsKey(key);
	}
}
