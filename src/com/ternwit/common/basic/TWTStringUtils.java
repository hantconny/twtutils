package com.ternwit.common.basic;

import static com.ternwit.common.CommonConstants.BACKWARD_SLASH;
import static com.ternwit.common.CommonConstants.DOUBLE_BACKWARD_SLASH;
import static com.ternwit.common.CommonConstants.DOUBLE_FORWARD_SLASH;
import static com.ternwit.common.CommonConstants.EMPTYSTRING;
import static com.ternwit.common.CommonConstants.FORWARD_SLASH;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @version 1.2
 * 
 * v1.1 added
 * 				endsWithForwardSlash
 * 				endsWithBackwardSlash
 * 				endsWithDoubleForwardSlash
 * 				endsWithDoubleBackwardSlash
 * v1.2 added
 * 				escapeLineBreakForWeb
 * 				insert(String inputStr, int fixLength, String insertStr)
 * 				split
 * 				splitWorker
 * 
 * 20130226 added
 * 					insert(String originalStr, String insertStr, int index)
 */
public final class TWTStringUtils extends StringUtils {
	
	/**
	 * @return returns true if starts with forward slash
	 */
	/*
	 * if parameter string starts with "/", this method returns true 
	 * otherwise, returns false
	 * 
	 * */
	public static boolean startsWithForwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.startsWith(inputStr, FORWARD_SLASH);
		return result;
	}

	/**
	 * @return returns true if starts with backward slash
	 */
	/*
	 * if parameter string starts with "\", this method returns true 
	 * otherwise, returns false
	 * 
	 * */
	public static boolean startsWithBackwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.startsWith(inputStr, BACKWARD_SLASH);
		return result;
	}

	/**
	 * @return returns true if starts with double forward slash
	 */
	public static boolean startsWithDoubleForwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.startsWith(inputStr, DOUBLE_FORWARD_SLASH);
		return result;
	}

	/**
	 * @return returns true if starts with double backward slash
	 */
	public static boolean startsWithDoubleBackwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.startsWith(inputStr, DOUBLE_BACKWARD_SLASH);
		return result;
	}
	
	/**
	 * @return returns true if ends with forward slash
	 */
	public static boolean endsWithForwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.endsWith(inputStr, FORWARD_SLASH);
		return result;
	}
	
	/**
	 * @return returns true if ends with backward slash
	 */
	public static boolean endsWithBackwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.endsWith(inputStr, BACKWARD_SLASH);
		return result;
	}
	
	/**
	 * @return returns true if ends with double forward slash
	 */
	public static boolean endsWithDoubleForwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.endsWith(inputStr, DOUBLE_FORWARD_SLASH);
		return result;
	}
	
	/**
	 * @return returns true if ends with double backward slash
	 */
	public static boolean endsWithDoubleBackwardSlash(String inputStr) {
		boolean result = false;
		result = StringUtils.endsWith(inputStr, DOUBLE_BACKWARD_SLASH);
		return result;
	}
	
	/**
	 * @return returns a string replaced all \r, \r\n and \n with HTML break line tag, the StringUtils can handle null input string
	 */
	public static String escapeLineBreakForWeb(String inputStr) {
		String outputStr = EMPTYSTRING;
		
		 /* should first replace \r\n, otherwise <br /> tag will be duplicate */
		outputStr = StringUtils.replace(inputStr, "\r\n", "<br />");
		outputStr = StringUtils.replace(outputStr, "\r", "<br />");
		outputStr = StringUtils.replace(outputStr, "\n", "<br />");
		
		return outputStr;
	}
	
	/*
	 * see
	 * inputStr = abced
	 * fixLength = 2
	 * insertStr = |
	 * returns ab|cd|e|
	 */
	/**
	 * @return
	 * inputStr = abced<br>
	 * fixLength = 2<br>
	 * insertStr = |<br>
	 * returns ab|cd|e|
	 * */
	public static String insert(String inputStr, int fixLength, String insertStr) {
		return StringUtils.join(splitWorker(inputStr, fixLength, insertStr)); 
	}
	
	/*
	 * see
	 * originalStr = abcde
	 * index = 2
	 * insertStr = TEST_INSERT
	 * return abTEST_INSERTcde
	 * 
	 * */
	/**
	 * @return
	 * originalStr = abcde<br>
	 * index = 2<br>
	 * insertStr = TEST_INSERT<br>
	 * return abTEST_INSERTcde
	 * */
	public static String insert(String originalStr, String insertStr, int index) {
		return originalStr.substring(0, index) + insertStr + originalStr.substring(index, originalStr.length());
	}
	
	/*
	 * see 
	 * inputStr = abcedfg
	 * fixLength = 2
	 * result String[] is [ab, cd, ef, g]
	 * */
	/**
	 * @return
	 * inputStr = abcedfg<br>
	 * fixLength = 2<br>
	 * result String[] is [ab, cd, ef, g]
	 * */
	public static String[] split(String inputStr, int fixLength) {
		return splitWorker(inputStr, fixLength, EMPTYSTRING);
	}
	
	/*
	 * see 
	 * inputStr = abcedfg
	 * fixLength = 2
	 * insertStr = |
	 * result String[] is [ab|, cd|, ef|, g|]
	 * */
	/**
	 * @return
	 * inputStr = abcedfg<br>
	 * fixLength = 2<br>
	 * insertStr = |<br>
	 * result String[] is [ab|, cd|, ef|, g|]
	 * */
	public static String[] split(String inputStr, int fixLength, String insertStr) {
		return splitWorker(inputStr, fixLength, insertStr);
	}
	
	/*
	 * fixLength can be understand as step
	 * see 1 - 3 - 5 - 7, step is 2
	 * inputStr = abcdefg
	 * fixLength = 2
	 * insertStr = %
	 * returns [ab%, cd%, ef%, g%]
	 * 
	 * */
	/**
	 * @return
	 * inputStr = abcdefg<br>
	 * fixLength = 2<br>
	 * insertStr = %<br>
	 * returns [ab%, cd%, ef%, g%]
	 * */
	private static String[] splitWorker(String inputStr, int fixLength, String insertStr) {
		if (null == inputStr) {
			return new String[]{};
		}
		if (StringUtils.isEmpty(inputStr)) {
			return new String[]{EMPTYSTRING};
		}
		if (0 >= fixLength) {
			throw new IllegalArgumentException("fixedLength can NOT be set to negative value or zero");
		}
		if (null == insertStr) {
			insertStr = EMPTYSTRING;
		}
		
		int stringLength = inputStr.length();
		
		int beginIndex = 0;
		int endIndex = fixLength;
		
		/* in case of fixedLength is greater than inputStr length */
		if (fixLength > stringLength) {
			return new String[]{inputStr + insertStr};
		}
		
		int arrayLength = stringLength / fixLength;
		arrayLength = stringLength % fixLength != 0 ? arrayLength + 1 : arrayLength;
		
		String[] array = new String[arrayLength];
		
		for (int i = 0; i < arrayLength; i++) {
			/* fix String Index Out Of Bound exception */
			if (endIndex > stringLength) {
				endIndex = stringLength;
			}

			array[i] = inputStr.substring(beginIndex, endIndex) + insertStr;

			beginIndex = endIndex;
			endIndex = beginIndex + fixLength;
		}
		
		return array;
	}
}
