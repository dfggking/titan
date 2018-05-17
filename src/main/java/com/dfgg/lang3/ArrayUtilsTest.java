package com.dfgg.lang3;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsTest {

	public static void main(String [] args) {
		Integer[] arr = new Integer[] {0,3,2,6,7};
		
		boolean result = ArrayUtils.isSorted(arr);
		System.out.println(result);
	}
	
//	public static void getResult() {
//	}
}
