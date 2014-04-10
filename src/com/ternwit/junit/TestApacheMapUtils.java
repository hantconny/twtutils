package com.ternwit.junit;

import static com.ternwit.junit.TestCommonConstants.EXPECT;
import static com.ternwit.junit.TestCommonConstants.NAG_STR;
import static com.ternwit.junit.TestCommonConstants.POS_STR;
import static com.ternwit.junit.TestCommonConstants.RESULT;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

/*
 * Audit Log
 * 2013-01-30 full test passed
 * 
 * */
public class TestApacheMapUtils {

	Map<String, String> nullMap = null;
	Map<String, String> emptyMap = new HashMap<String, String>();
	
	Map<String, String> nullStrMap = new HashMap<String, String>();
	Map<String, String> emptyStrMap = new HashMap<String, String>();
	
	@Test
	public void testIsEmpty() {
		System.out.println(EXPECT + POS_STR + RESULT + MapUtils.isEmpty(nullMap));
		System.out.println(EXPECT + POS_STR + RESULT + MapUtils.isEmpty(emptyMap));
		
		emptyStrMap.put("", "");
		System.out.println(EXPECT + NAG_STR + RESULT + MapUtils.isEmpty(emptyStrMap));
		
		nullStrMap.put(null, null);
		System.out.println(EXPECT + NAG_STR + RESULT + MapUtils.isEmpty(nullStrMap));
	}

}
