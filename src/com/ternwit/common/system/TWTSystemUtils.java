package com.ternwit.common.system;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

import com.ternwit.common.CommonConstants;

/**
 * 
 * @version 1.0
 *
 */
public final class TWTSystemUtils extends SystemUtils {
	
	/**
	 * @param key
	 * @return corresponding system variable value, if nothing is matched, return empty string ("")
	 */
	/*
	 * common key 
	 * os.name 
	 * os.arch 
	 * os.version 
	 * file.separator 
	 * path.separator
	 * line.separator
	 */
	public static String getOSInfo(String key) {
		
		String value = CommonConstants.EMPTYSTRING;;

		/* if key is whitespace, empty ("") or null */
		if (StringUtils.isBlank(key)) {
			return value;
		}

		/* initial system properties */
		Properties props = System.getProperties();
		
		Object tempValue = props.get(key);

		if (null != tempValue) {
			value = tempValue.toString();
		}
		
		return value;
	}
	
}
