package com.ternwit.junit.common.basic;

import static com.ternwit.junit.TestCommonConstants.EXPECT;
import static com.ternwit.junit.TestCommonConstants.NAG_STR;
import static com.ternwit.junit.TestCommonConstants.POS_STR;
import static com.ternwit.junit.TestCommonConstants.RESULT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ternwit.common.basic.TWTListUtils;

/*
 * Audit Log
 * 2013-01-30 full test passed
 * 
 * */
public class TestTWTListUtils {

	List<String> nullList = null;
	List<String> emptyList = new ArrayList<String>();
	List<String> posList = new ArrayList<String>();
	
	@Test
	public void testIsNullOrEmpty() {
		assertTrue(TWTListUtils.isNullOrEmpty(nullList));
		assertTrue(TWTListUtils.isNullOrEmpty(emptyList));
		
		System.out.println(EXPECT + POS_STR + RESULT + TWTListUtils.isNullOrEmpty(nullList));
		System.out.println(EXPECT + POS_STR + RESULT + TWTListUtils.isNullOrEmpty(emptyList));
	}

	@Test
	public void testIsSizeOne() {
		assertFalse(TWTListUtils.isSizeOne(nullList));
		assertFalse(TWTListUtils.isSizeOne(emptyList));
		
		System.out.println(EXPECT + NAG_STR + RESULT + TWTListUtils.isSizeOne(nullList));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTListUtils.isSizeOne(emptyList));
		
		posList.add(null);
		assertTrue(TWTListUtils.isSizeOne(posList));
		System.out.println(EXPECT + POS_STR + RESULT + TWTListUtils.isSizeOne(posList));
	}

	@Test
	public void testIsNull() {
		assertTrue(TWTListUtils.isNull(nullList));
		System.out.println(EXPECT + POS_STR + RESULT + TWTListUtils.isNull(nullList));
		
		assertFalse(TWTListUtils.isNull(emptyList));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTListUtils.isNull(emptyList));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(TWTListUtils.isEmpty(nullList));
		System.out.println(EXPECT + POS_STR + RESULT + TWTListUtils.isEmpty(nullList));
		
		assertTrue(TWTListUtils.isEmpty(emptyList));
		System.out.println(EXPECT + POS_STR + RESULT + TWTListUtils.isEmpty(emptyList));
	}

}
