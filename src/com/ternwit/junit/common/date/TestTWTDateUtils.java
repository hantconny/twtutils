package com.ternwit.junit.common.date;

import static com.ternwit.junit.TestCommonConstants.EXPECT;
import static com.ternwit.junit.TestCommonConstants.RESULT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ternwit.common.date.TWTDateUtils;

/*
 * Audit Log
 * 2013-01-31 full test passed
 * 
 * */
public class TestTWTDateUtils {

	//System.out.println(EXPECT + NAG_STR + RESULT + 
	//System.out.println(EXPECT + POS_STR + RESULT + 
	
	@Test
	public void testGetCurrentTimestampString() {
		System.out.println(TWTDateUtils.getCurrentTimestampString());
	}

	@Test
	public void testGetCurrentTimestamp() {
		System.out.println(TWTDateUtils.getCurrentTimestamp());
	}

	@Test
	public void testGetCurrentDateString() {
		System.out.println(TWTDateUtils.getCurrentDateString());
	}

	@Test
	public void testGetLastDayInMonth() {
		assertSame(31, TWTDateUtils.getLastDayInMonth(2013, 01));
		System.out.println(EXPECT + "31" + RESULT + TWTDateUtils.getLastDayInMonth(2013, 01));
	}

	@Test
	public void testGetMonthStringList() {
		List<String> expected = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			expected.add(i + "");
		}
		List<String> list = TWTDateUtils.getMonthStringList();
		assertEquals(expected, list);
	}

	@Test
	public void testGetMonthIntegerList() {
		List<Integer> expected = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			expected.add(i);
		}
		List<Integer> list = TWTDateUtils.getMonthIntegerList();
		assertEquals(expected, list);
	}

	@Test
	public void testGetCurrentYear() {
		assertTrue(TWTDateUtils.getCurrentYear() instanceof Integer);
		System.out.println("Current year is: " + TWTDateUtils.getCurrentYear());
	}

	@Test
	public void testGetCurrentYearString() {
		assertTrue(TWTDateUtils.getCurrentYearString() instanceof String);
		System.out.println("Current year is: " + TWTDateUtils.getCurrentYearString());
	}

	@Test
	public void testGetYearStringList() {
		List<String> expected = new ArrayList<String>();
		for (int i = 1988; i <= TWTDateUtils.getCurrentYear(); i++) {
			expected.add(i + "");
		}
		assertEquals(expected, TWTDateUtils.getYearStringList(1988));
	}

	@Test
	public void testGetYearIntegerList() {
		List<Integer> expected = new ArrayList<Integer>();
		for (int i = 1988; i <= TWTDateUtils.getCurrentYear(); i++) {
			expected.add(i);
		}
		assertEquals(expected, TWTDateUtils.getYearIntegerList(1988));
	}

	@Test
	public void testGet1890YearsStringList() {
		List<String> expected = new ArrayList<String>();
		for (int i = 1890; i <= TWTDateUtils.getCurrentYear(); i++) {
			expected.add(i + "");
		}
		assertEquals(expected, TWTDateUtils.get1890YearsStringList());
	}

	@Test
	public void testGet1890YearsIntegerList() {
		List<Integer> expected = new ArrayList<Integer>();
		for (int i = 1890; i <= TWTDateUtils.getCurrentYear(); i++) {
			expected.add(i);
		}
		assertEquals(expected, TWTDateUtils.get1890YearsIntegerList());
	}

	@Test
	public void testGetSimpleDateFormat() {
		System.out.println(TWTDateUtils.getSimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(TWTDateUtils.getCalendar().getTime()));
	}

	@Test
	public void testGetCalendar() {
		
	}

	@Test
	public void testGetAgeFromDOB() {
		System.out.println(TWTDateUtils.getAgeFromDOB(TWTDateUtils.getTimestampFromString("1988-12-12 12:31:42")));
	}

	@Test
	public void testGetTimeFromString() {
		
	}

	@Test
	public void testGetTimestampFromString() {
		
	}

	@Test
	public void testGetStringFromTime() {
		
	}

	@Test
	public void testGetStringFromTimestamp() {

	}

	@Test
	public void testIsLeapYear() {
		assertFalse(TWTDateUtils.isLeapYear(1998));
		assertTrue(TWTDateUtils.isLeapYear(2000));
		assertTrue(TWTDateUtils.isLeapYear(2004));
	}

}
