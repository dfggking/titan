package com.dfgg.util;

/**
 * @author jinyingfei - 835317619@qq.com
 * @create 2018-06-06
 */
public class FileConfigUtilsTest {

	/**
	 * @author jinyingfei - 835317619@qq.com
	 */
	public static void main(String[] args) {
		String sysName = PropertiesUtil.getProperties("sys.properties", "sys.name");
		System.out.println(sysName);
	}
	
}
