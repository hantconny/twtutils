package com.ternwit.junit.common.basic;
import static com.ternwit.junit.TestCommonConstants.EXPECT;
import static com.ternwit.junit.TestCommonConstants.NAG_STR;
import static com.ternwit.junit.TestCommonConstants.POS_STR;
import static com.ternwit.junit.TestCommonConstants.RESULT;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ternwit.common.basic.TWTStringUtils;

/*
 * Audit Log
 * 2013-01-31 full test passed
 * 
 * */
public class TestTWTStringUtils {

	//System.out.println(EXPECT + NAG_STR + "\r\n" + RESULT + 
	//System.out.println(EXPECT + POS_STR + "\r\n" + RESULT + 
	
	@Test
	public void testStartsWithForwardSlash() {
		assertTrue(TWTStringUtils.startsWithForwardSlash("/aaa"));
		
		
		System.out.println(EXPECT + POS_STR + RESULT + TWTStringUtils.startsWithForwardSlash("/aaa"));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTStringUtils.startsWithForwardSlash("aaa"));
	}

	@Test
	public void testStartsWithBackwardSlash() {
		assertTrue(TWTStringUtils.startsWithBackwardSlash("\\aaa"));
		
		
		System.out.println(EXPECT + POS_STR + RESULT + TWTStringUtils.startsWithBackwardSlash("\\aaa"));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTStringUtils.startsWithBackwardSlash("aaa"));
	}

	@Test
	public void testStartsWithDoubleForwardSlash() {
		
	}

	@Test
	public void testStartsWithDoubleBackwardSlash() {
		
	}

	@Test
	public void testEndsWithForwardSlash() {
		assertTrue(TWTStringUtils.endsWithForwardSlash("aaa/"));
		
		
		System.out.println(EXPECT + POS_STR + RESULT + TWTStringUtils.endsWithForwardSlash("aaa/"));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTStringUtils.endsWithForwardSlash("aaa"));
	}

	@Test
	public void testEndsWithBackwardSlash() {
		assertTrue(TWTStringUtils.endsWithBackwardSlash("aaa\\"));

		
		System.out.println(EXPECT + POS_STR + RESULT + TWTStringUtils.endsWithBackwardSlash("aaa\\"));
		System.out.println(EXPECT + NAG_STR + RESULT + TWTStringUtils.endsWithBackwardSlash("aaa"));
	}

	@Test
	public void testEndsWithDoubleForwardSlash() {
		
	}

	@Test
	public void testEndsWithDoubleBackwardSlash() {
		
	}

	@Test
	public void testEscapeLineBreakForWeb() {
		String original = "abc\nde\rfgh\r\nij\r\r\nkl\n\n\rmnopq";
		String expected = "abc<br />de<br />fgh<br />ij<br /><br />kl<br /><br /><br />mnopq";
		
		assertEquals(expected, TWTStringUtils.escapeLineBreakForWeb(original));
	}

	@Test
	public void testInsert() {
		String original = "abcdefghijklmn";
		String expected = "abc|def|ghi|jkl|mn|";

		assertEquals(expected, TWTStringUtils.insert(original, 3, "|"));
	}

	@Test
	public void testSplitStringInt() {
		String original = "abcdefghijklmn";
		String[] expected = {"abc","def","ghi","jkl","mn"};

		assertArrayEquals(expected, TWTStringUtils.split(original, 3));
	}

	@Test
	public void testSplitStringIntString() {
		String original = "abcdefghijklmn";
		String[] expected = {"abc%","def%","ghi%","jkl%","mn%"};
		
		assertArrayEquals(expected, TWTStringUtils.split(original, 3, "%"));
	}
	
	@Test
	public void testInsertStringStringInt() {
		String originalStr = "abcde";
		String insertStr = "TEST_INSERT";
		int index = 1;
		assertEquals("aTEST_INSERTbcde", TWTStringUtils.insert(originalStr, insertStr, index));
	}

}
