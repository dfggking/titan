package com.dfgg.lang3;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {

	/**   
	 * @title: StringUtilsTest
	 * @desc: 
	 * @author: jinyf - 835317619@qq.com
	 * @create: 2018年5月11日 上午9:15:10
	 * @param args void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = StringUtils.abbreviate("17671711476a", "***", 6, 11);
		System.out.println(str);
	}

}
