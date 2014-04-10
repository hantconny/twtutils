package com.ternwit.common;

/*
 * Audit log
 * v1.1 add slash part
 * 2013-01-31 add some common system info keys
 * 2013-05-07 modify HTML_TAB and DOUBLE_HTML_TAB, cut them into half
 */
public interface CommonConstants {
	/*
	 * empty String and null String
	 */
	public static final String EMPTYSTRING = "";
	public static final String NULLSTRING = null;
	public static final String HTML_TAB = "&nbsp;&nbsp;&nbsp;&nbsp;";
	public static final String DOUBLE_HTML_TAB = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	
	
	/* 
	 * slashes forward and back forward
	 */
	public static final String FORWARD_SLASH = "/";
	public static final String DOUBLE_FORWARD_SLASH = "//";

	public static final String BACKWARD_SLASH = "\\";
	public static final String DOUBLE_BACKWARD_SLASH = "\\\\";
	
	
	/*
	 * Local Constants
	 */
	public static final String en_US = "en_US";
	public static final String zh_CN = "zh_CN";
	public static final String zh = "zh";
	public static final String en = "en";
	
	/*
	 * Date Format String
	 */
	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	
	/* 
	 * NEW ADD NOT TESTED YET
	 * Open Flash Chart 2
	 * */
	public static final Double MIN = 0.0;
	public static final Double MAX = 900.0;
	public static final Double STEPS = 100.0;

	public static final String LEGEND_COLOUR = "#736AFF";
	public static final String LEGEND_FONTSIZE = "15";

	public static final String LEGEND_Y_TEXT = "Y Axis";
	public static final String LEGEND_X_TEXT = "X Axis";

	public static final String TITLE_TEXT = "Open Flash Chart 2";
	public static final String TITLE_COLOUR = "#CCCCCC";
	public static final String TITLE_FONTSIZE = "18";

	public static final String GRID_COLOUR = "#ADB5C7";
	
	
	/*
	 * Common System Info Keys
	 * os.name 
	 * os.arch 
	 * os.version 
	 * file.separator 
	 * path.separator
	 * line.separator
	 * */
	public static final String OS_NAME = "os.name";
	public static final String OS_ARCH = "os.arch";
	public static final String OS_VERSION = "os.version";
	public static final String FILE_SEPARATOR = "file.separator";
	public static final String PATH_SEPARATOR = "path.separator";
	public static final String LINE_SEPARATOR = "line.separator";
}
