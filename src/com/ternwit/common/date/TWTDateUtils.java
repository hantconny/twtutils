package com.ternwit.common.date;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;

import com.ternwit.common.CommonConstants;
import com.ternwit.common.basic.TWTStringUtils;

/**
 * 
 * @version 1.1
 * 
 * follow naming convention as 
 * get - category(Time/Date/Month/Year) - type(int/String/Timestamp/Date) - description(List) 
 * simple get methods - utility methods - time - date(including day) - month - year
 * 
 * v1.1 added 
 * 		getTimeFromString()
 * 		getTimestampFromString()
 * 		getStringFromTime()
 * 		getStringFromTimestamp()
 * 		getAgeFromDOB()
 * 		isLeapYear()
 * 		getMonthIntegerList()
 * 2013-04-16 add
 * 		getCurrentTime()
 *		getCurrentTimeString()
 *		getCurrentDate()
 * 2013-04-25 add not fully tested
 * 		initCalendarForWeek
 * 		getFirstDateOfCurrentWeek
 * 		getLastDateOfCurrentWeek
 * 		initCalendarForMonth
 * 		getFirstDateOfCurrentMonth
 * 		getLastDateOfCurrentMonth
 * 		getfirstDateOfCurrentYear
 * 		getLastDateOfCurrentYear
 */
public final class TWTDateUtils extends DateUtils {
	
	/**
	 * @return return current time in millisecond
	 */
	public static String getCurrentTimestampString() {
		return getCurrentTimestamp().toString();
	}
	
	/**
	 * @return return current time stamp
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(getCalendar().getTimeInMillis());
	}
	
	/**
	 * @return return short date string in format yyyy-MM-dd
	 */
	public static String getCurrentDateString() {
		return getCurrentTimestampString().substring(0, 10);
	}

	/**
	 * @return the last day of a specific month in a specific year
	 */
	public static Integer getLastDayInMonth(Integer yyyy, Integer mm) {
		Calendar calendar = getCalendar();

		calendar.set(Calendar.YEAR, yyyy);

		calendar.set(Calendar.MONTH, mm);

		Integer lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		return lastDay;
	}
	
	/**
	 * @return month string list
	 */
	public static List<String> getMonthStringList() {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			list.add(i + CommonConstants.EMPTYSTRING);
		}
		return list;
	}
	
	/**
	 * @return month integer list
	 */
	/* 
	 * add in v1.1 misc fix
	 * kind of a fix for twin method getMonthStringList()
	 * */
	public static List<Integer> getMonthIntegerList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			list.add(i);
		}
		return list;
	}

	/**
	 * @return current year int
	 */
	public static Integer getCurrentYear() {
		return getCalendar().get(Calendar.YEAR);
	}

	/**
	 * @return current year string
	 */
	public static String getCurrentYearString() {
		return getCurrentYear().toString();
	}
	
	/**
	 * @return year string list from param to current year
	 */
	public static List<String> getYearStringList(Integer yyyy) {
		List<String> list = new ArrayList<String>();
		
		for (int i = yyyy; i <= getCurrentYear(); i++) {
			list.add(i + CommonConstants.EMPTYSTRING);
		}
		
		return list;
	}
	
	/**
	 * @return year Integer list from param to current year
	 */
	public static List<Integer> getYearIntegerList(Integer yyyy) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = yyyy; i <= getCurrentYear(); i++) {
			list.add(i);
		}
		
		return list;
	}
	
	/**
	 * @return year string list from 1890 to current year
	 */
	public static List<String> get1890YearsStringList() {
		return getYearStringList(1890);
	}
	
	/**
	 * @return year integer list from 1890 to current year
	 */
	public static List<Integer> get1890YearsIntegerList() {
		return getYearIntegerList(1890);
	}

	/**
	 * @return return an instance of SimpleDateFormat
	 */
	public static SimpleDateFormat getSimpleDateFormat(String formatStr) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
		return simpleDateFormat;
	}
	
	/**
	 * @return return an instance of Calendar
	 */
	public static Calendar getCalendar() {
		Calendar calendar = Calendar.getInstance();
		return calendar;
	}
	
	/**
	 * @return return age in Integer
	 *
	 * This method will return current age of a person by accepting his date of birth
	 * added in v1.1
	 */
	public static Integer getAgeFromDOB(Timestamp dateOfBirth) {
		Integer result = 0;

		if (dateOfBirth != null) {
			String now = new Timestamp(System.currentTimeMillis()).toString();
			String dob = dateOfBirth + "";

			int yearNow = Integer.parseInt(now.substring(0, 4));
			int yearDob = Integer.parseInt(dob.substring(0, 4));

			int age = yearNow - yearDob;

			int dateNow = Integer.parseInt(now.substring(5, 7)
					+ now.substring(8, 10));
			int dateDob = Integer.parseInt(dob.substring(5, 7)
					+ dob.substring(8, 10));

			if (dateNow < dateDob) {
				age = age - 1;
			}

			result = new Integer(age);
		}

		return result;
	}
	
	/**
	 * This method takes a string value and parse it into java.sql.Time
	 * added in v1.1
	 */
	public static Time getTimeFromString(String param) {
		Time result = new Time(System.currentTimeMillis());

		if (TWTStringUtils.isNotBlank(param)) {
			result = Time.valueOf(param);
		}

		return result;
	}

	/**
	 * This method takes a string value and parse it into java.sql.Timestamp
	 * added in v1.1
	 */
	public static Timestamp getTimestampFromString(String param) {
		Timestamp result = new Timestamp(System.currentTimeMillis());

		if (TWTStringUtils.isNotBlank(param)) {
			result = Timestamp.valueOf(param);
		}

		return result;
	}
	
	/**
	 * This method takes a java.sql.Time value and parse it into string
	 * added in v1.1
	 */
	public static String getStringFromTime(Time param) {
		String timeString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			timeString = param.toString();
		}

		return timeString;
	}

	/**
	 * This method takes a java.sql.Timestamp value and parse it into string
	 * added in v1.1
	 */
	public static String getStringFromTimestamp(Timestamp param) {
		String timeStampString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			timeStampString = param.toString();
		}

		return timeStampString;
	}
	
	/**
	 * Is a multiple of 4, and not a multiple of 100; or multiples of 400
	 * This method judges if input year is leap year or not
	 * added in v1.1
	 */
	public static boolean isLeapYear(Integer year) {
		if (year % 4 != 0) {
			return false;
		}

		if (year % 100 == 0) {
			return (year % 400 == 0);
		}

		return true;
	}
	
	/**
	 * This method return an instance of  java.sql.Time stands for current time<br>
	 * <b>Not recommend using Time, use Timestamp instead</b>
	 * */
	public static Time getCurrentTime() {
		return new Time(getCalendar().getTimeInMillis());
	}
	
	/** 
	 * Return a String of current time like "08:00"
	 * 
	 * */
	public static String getCurrentTimeString() {
		return getCurrentTime().toString();
	}
	
	/**
	 * Return current Date
	 * 
	 * */
	public static Date getCurrentDate() {
		return getCalendar().getTime();
	}
	
	/**
	 * private method invoked by 
	 * 		getFirstDateOfCurrentWeek
	 * 		getLastDateOfCurrentWeek
	 * */
	private static Calendar initCalendarForWeek() {
		Calendar calendar = getCalendar();
		// 当前时间是本月的第几周
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		// 当前时间是几几年
		int year = calendar.get(Calendar.YEAR);
		
		calendar.clear();
		calendar.set(Calendar.WEEK_OF_MONTH, week);
		calendar.set(Calendar.YEAR, year);
		return calendar;
	}
	
	/**
	 * return first day(sunday)'s date of current week.
	 * can work with the situation when first day is in one month 
	 * while last day is in next month
	 * 
	 * */
	public static Date getFirstDateOfCurrentWeek() {
		// 当前周的第一天(星期天)
		return initCalendarForWeek().getTime();
	}
	
	/**
	 * return last day(saturday)'s date of current week.
	 * can work with the situation when first day is in one month 
	 * while last day is in next month
	 * 
	 * */
	public static Date getLastDateOfCurrentWeek() {
		Calendar calendar = initCalendarForWeek();
		// 设定为本周周六
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		// 当前周的第一天(星期六)
		return calendar.getTime();
	}
	
	/**
	 * private method invoked by 
	 * 		getFirstDateOfCurrentMonth
	 * 		getLastDateOfCurrentMonth
	 * */
	private static Calendar initCalendarForMonth() {
		Calendar calendar = getCalendar();
		// 当前时间是几月, 例如2月则month为1
		int month = calendar.get(Calendar.MONTH);
		// 当前时间是几几年
		int year = calendar.get(Calendar.YEAR);
		
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		return calendar;
	}
	
	/**
	 * return first day's date of current month.
	 * can work with leap year's Feb
	 * 
	 * */
	public static Date getFirstDateOfCurrentMonth() {
		return initCalendarForMonth().getTime();
	}
	
	/**
	 * return last day's date of current month.
	 * can work with leap year's Feb
	 * 
	 * */
	public static Date getLastDateOfCurrentMonth() {
		Calendar calendar = initCalendarForMonth();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
	
	/**
	 * return first day's date of current year.
	 * can wrok with leap year
	 * 
	 * */
	public static Date getFirstDateOfCurrentYear() {
		Calendar calendar = getCalendar();
		int st = calendar.getActualMinimum(Calendar.DAY_OF_YEAR);
		int year = calendar.get(Calendar.YEAR);
		
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, st);
		return calendar.getTime();
	}
	
	/**
	 * return last day's date of current year.
	 * can wrok with leap year
	 * 
	 * */
	public static Date getLastDateOfCurrentYear() {
		Calendar calendar = getCalendar();
		int end = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		int year = calendar.get(Calendar.YEAR);
		
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_YEAR, end);
		return calendar.getTime();
	}
}
