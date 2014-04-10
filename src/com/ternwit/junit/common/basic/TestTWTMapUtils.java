package com.ternwit.junit.common.basic;

import static com.ternwit.junit.TestCommonConstants.EXPECT;
import static com.ternwit.junit.TestCommonConstants.NAG_STR;
import static com.ternwit.junit.TestCommonConstants.POS_STR;
import static com.ternwit.junit.TestCommonConstants.RESULT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ternwit.common.basic.TWTMapUtils;

/*
 * Audit Log
 * 2013-01-30 full test passed
 * 
 * */
public class TestTWTMapUtils {

	Map<String, String> nullMap = null;
	Map<String, String> emptyMap = new HashMap<String, String>();
	Map<String, String> posMap = new HashMap<String, String>();
	
	@Test
	public void testIsSizeOne() {
		posMap.put(null, null);
		
		assertTrue(TWTMapUtils.isSizeOne(posMap));
		
		assertFalse(TWTMapUtils.isSizeOne(nullMap));
		assertFalse(TWTMapUtils.isSizeOne(emptyMap));
		
		System.out.println(EXPECT + NAG_STR + RESULT + TWTMapUtils.isSizeOne(nullMap));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTMapUtils.isSizeOne(emptyMap));
		System.out.println(EXPECT + POS_STR + RESULT + TWTMapUtils.isSizeOne(posMap));
	}

}
