package com.ternwit.common.basic;

import java.util.List;

import org.apache.commons.collections.ListUtils;

/**
 * 
 * @version 1.0
 *
 * v1.2 add 
 * 			public static boolean isEmpty(List<? extends Object> list)
 */
public final class TWTListUtils extends ListUtils {
	/**
	 * @param list
	 * @return return true when list is null or empty
	 */
	public static boolean isNullOrEmpty(List<? extends Object> list) {
		/*
		 * if list is null
		 * return true
		 */
		if (isNull(list)) {
			return true;
		}
		
		/*
		 * if list is empty
		 * return true
		 */
		if (isEmpty(list)) {
			return true;
		}
		
		return false;
	}

	/**
	 * @param list
	 * @return return true when list size is one
	 */
	public static boolean isSizeOne(List<? extends Object> list) {
		/*
		 * call isNullOrEmpty method
		 * if list is null or empty
		 * return false
		 */
		if (isNullOrEmpty(list)) {
			return false;
		}
		/*
		 * if list size is not one
		 * return false
		 */
		if (1 != list.size()) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param list
	 * @return return true when list is null
	 */
	public static boolean isNull(List<? extends Object> list) {
		/*
		 * if list is null
		 * return true
		 */
		if (null == list) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * @param
	 * @return return true if input param list is empty
	 * @throws throws IllegalArgumentException is input param list is null
	 * 
	 * */
	/* added in version 1.2 */
	public static boolean isEmpty(List<? extends Object> list) {
		/*
		 * if list is null
		 * return true
		 */
		if (isNull(list)) {
			return true;
		}
		
		/* size 0, return true */
		if(0 == list.size()) {
			return true;
		}
		
		return false;
	}
}
