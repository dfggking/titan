package com.dfgg.util;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * properties工具类
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-06-06
 */
public class PropertiesUtil {
	
	/** 属性文件列表 */
	private static Map<String, Properties> propertiesMap = new ConcurrentHashMap<String, Properties>();
	private final static ReadWriteLock rwl = new ReentrantReadWriteLock();
	private static Map<String, Boolean> fileMap = new ConcurrentHashMap<String, Boolean>();
	volatile static Boolean cacheValid;

	/**
	 * 根据属性文件名称和属性名获取属性值
	 * 
	 * @param propertiesFileName
	 *            属性文件名称
	 * @param key
	 *            属性名称
	 * @return 属性值
	 * @throws Exception
	 */
	public static String getProperties(String propertiesFileName, String key) {
		if (null != propertiesFileName && 0 < propertiesFileName.trim().length()) {
			String value = null;
			rwl.readLock().lock();
			cacheValid = fileMap.get(propertiesFileName);
			if (cacheValid == null || !cacheValid) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (cacheValid == null || !cacheValid) {
						Properties properties = new Properties();
						properties.load(
								PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesFileName.trim()));
						propertiesMap.put(propertiesFileName, properties);
						fileMap.put(propertiesFileName, true);
					}
					rwl.readLock().lock();
				} catch (Exception e) {
				} finally {
					rwl.writeLock().unlock();
				}
			}
			try {
				value = propertiesMap.get(propertiesFileName).getProperty(key);
			} finally {
				rwl.readLock().unlock();
			}
			return value;
		}
		return null;
	}

}
