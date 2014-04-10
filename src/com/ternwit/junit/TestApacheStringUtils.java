package com.ternwit.junit;

import org.junit.Assert;
import org.junit.Test;

import com.ternwit.common.basic.TWTStringUtils;

/*
 * Audit Log
 * 2013-01-30 full test passed
 * 
 * */
public class TestApacheStringUtils {

	String nullStr = null;
	String emptyStr = "";
	String blankStr = "     ";

	@Test
	public void testIsBlank() {
		Assert.assertEquals(true, TWTStringUtils.isBlank(nullStr));
		Assert.assertEquals(true, TWTStringUtils.isBlank(emptyStr));
		Assert.assertEquals(true, TWTStringUtils.isBlank(blankStr));
	}

	@Test
	public void testIsEmpty() {
		Assert.assertEquals(true, TWTStringUtils.isEmpty(nullStr));
		Assert.assertEquals(true, TWTStringUtils.isEmpty(emptyStr));
		Assert.assertEquals(false, TWTStringUtils.isEmpty(blankStr));
	}
	
}
