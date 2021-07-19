package com.beerproject.util;

import java.util.Collection;

public class FunctionUtil {
	
	public static boolean isEmpty(Integer o) {
		return (o == null) || (o.intValue() == 0);
	}
	
	public static boolean isEmpty(String o) {
		return (o == null) || (o.trim().isEmpty());
	}

	
	public static boolean isEmpty(Object o) {
		return (o == null);
	}
	
	 public static boolean isEmpty(Collection<?> list) {
	        return (list == null || list.isEmpty() || list.size() == 0);
	    }
	
	public static boolean isEmpty(Long o) {
		return (o == null) || (o.intValue() == 0);
	}
}
