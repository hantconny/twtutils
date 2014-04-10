package com.ternwit.common.basic;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

import com.ternwit.common.CommonConstants;

/**
 * @since version 1.1
 * 
 * */
/*
 * Audit Log
 * 2013-01-31 	add get32BitMD5 
 * 				add get16BitMD5
 * 
 * 2013-03-18 	modify get32BitMD5 using Apache Common Codec
 * 			 	modify get16BitMD5 using Apache Common Codec
 * 
 * 2013-04-10	add getUUID tested
 * */
public final class TWTFunctionUtils {

	public static BigDecimal getBigDecimalFromString(String param) {
		BigDecimal result = new BigDecimal(0);

		if (TWTStringUtils.isNotBlank(param)) {
			result = new BigDecimal(param);
		}

		return result;
	}

	public static Boolean getBooleanFromString(String param) {
		Boolean result = false;

		if (TWTStringUtils.isNotBlank(param)) {
			result = new Boolean(param);
		}

		return result;
	}

	public static Short getBooleanShortValFromString(String param) {
		Short result = new Short("0");

		if (TWTStringUtils.isNotBlank(param)) {
			if (param.equalsIgnoreCase(Boolean.TRUE.toString())) {
				result = new Short("1");
			} else {
				result = new Short("0");
			}
		}

		return result;
	}

	public static Integer getIntegerFromString(String param) {
		Integer result = 0;

		if (TWTStringUtils.isNotBlank(param))
			result = new Integer(param);

		return result;
	}

	public static Double getDoubleFromString(String param) {
		Double result = new Double(0);

		if (TWTStringUtils.isNotBlank(param)) {
			result = new Double(param);
		}

		return result;
	}

	public static Float getFloatFromString(String param) {
		Float result = new Float(0);

		if (TWTStringUtils.isNotBlank(param)) {
			result = new Float(param);
		}

		return result;
	}

	public static Long getLongFromString(String param) {
		Long result = new Long(0);

		if (TWTStringUtils.isNotBlank(param)) {
			result = new Long(param);
		}

		return result;
	}

	public static String getStringFromBigDecimal(BigDecimal param) {
		String bigDecimalString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			bigDecimalString = param.toString();
		}

		return bigDecimalString;
	}

	public static String getStringFromBoolean(Boolean param) {
		String booleanString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			booleanString = param.toString();
		}

		return booleanString;
	}

	public static String getStringFromBooleanShortVal(Short param) {
		String booleanString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			if (param.shortValue() == 0) {
				booleanString = Boolean.FALSE.toString();
			} else if (param.shortValue() == 1) {
				booleanString = Boolean.TRUE.toString();
			}
		}

		return booleanString;
	}

	public static String getStringFromInteger(Integer param) {
		String integerString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			integerString = param.toString();
		}

		return integerString;
	}

	public static String getStringFromDouble(Double param) {
		String doubleString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			doubleString = param.toString();
		}

		return doubleString;
	}

	public static String getStringFromFloat(Float param) {
		String floatString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			floatString = param.toString();
		}

		return floatString;
	}

	public static String getStringFromLong(Long param) {
		String longString = CommonConstants.EMPTYSTRING;

		if (param != null) {
			longString = param.toString();
		}

		return longString;
	}

	/*
	 * notice: this method can NOT guarantee unique id in a pretty fast machine
	 * 
	 * */
	public static Long getPrimaryKey() {
		Timestamp now = new Timestamp(System.currentTimeMillis());

		long nowInlong = now.getTime();

		Long aPK = new Long(nowInlong);

		return aPK;
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}

		return (obj.toString().trim().equals(""));
	}

	public static Object invokeMethod(Object object, String methodName,
			Class<? extends Object>[] paramTypes, Object[] params)
			throws Exception {
		if (object == null) {
			return null;
		}
		Class<? extends Object> targetClass = object.getClass();

		if (targetClass == null) {
			return null;
		}
		Method targetMethod = targetClass.getMethod(methodName, paramTypes);

		if (targetMethod == null) {
			return null;
		}
		Object result = targetMethod.invoke(object, params);

		return result;
	}
	
	public static String get32BitMD5(String plainText) {
		return DigestUtils.md5Hex(plainText);
	}
	
	public static String get16BitMD5(String plainText) {
//		MessageDigest md = null;
//		try {
//			md = MessageDigest.getInstance("MD5");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		md.update(plainText.getBytes());
//		byte b[] = md.digest();
//
//		int i;
//
//		StringBuffer buf = new StringBuffer("");
//		for (int offset = 0; offset < b.length; offset++) {
//			i = b[offset];
//			if (i < 0) {
//				i += 256;
//			}
//			if (i < 16) {
//				buf.append("0");
//			}
//			buf.append(Integer.toHexString(i));
//		}
//		
//		return buf.toString().substring(8, 24);
		
		return DigestUtils.md5Hex(plainText).substring(8, 24);
	}
	
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return TWTStringUtils.replace(uuid, "-", "");
	}
}
