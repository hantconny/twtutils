package com.ternwit.junit;

import junit.framework.Assert;

import org.junit.Test;

import com.ternwit.common.basic.TWTArrayUtils;

/*
 * Audit Log
 * 2013-01-30 full test passed
 * 
 * */
public class TestApacheArrayUtils {

	@Test
	public void testContains() {

		String[] array = { "string", "double", "char" };
		String target = "double";

		Assert.assertEquals(true, TWTArrayUtils.contains(array, target));

	}

	@Test
	public void testIsEmpty() {
		String[] emptyArray = {};
		String[] nullArray = null;
		String[] blankArray = {""};
		
		/* the isEmpty method is extends from Apache ArrayUtils.isEmpty, if array is null or empty, return true */
		Assert.assertEquals(true, TWTArrayUtils.isEmpty(emptyArray));
		Assert.assertEquals(true, TWTArrayUtils.isEmpty(nullArray));
		Assert.assertEquals(false, TWTArrayUtils.isEmpty(blankArray));
		
	}
	
}
