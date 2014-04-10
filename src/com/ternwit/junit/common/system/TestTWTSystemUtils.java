package com.ternwit.junit.common.system;

import org.junit.Test;

import com.ternwit.common.CommonConstants;
import com.ternwit.common.system.TWTSystemUtils;

/*
 * Audit Log
 * 2013-01-31 full test passed
 * 
 * */
public class TestTWTSystemUtils {

	@Test
	public void testGetOSInfo() {
		System.out.println("OS version: " + TWTSystemUtils.getOSInfo(CommonConstants.OS_VERSION));
		System.out.println("OS arch: " + TWTSystemUtils.getOSInfo(CommonConstants.OS_ARCH));
		System.out.println("OS name: " + TWTSystemUtils.getOSInfo(CommonConstants.OS_NAME));
		System.out.println("File sep: " + TWTSystemUtils.getOSInfo(CommonConstants.FILE_SEPARATOR));
		System.out.println("Path sep: " + TWTSystemUtils.getOSInfo(CommonConstants.PATH_SEPARATOR));
		System.out.println("Line sep: " + TWTSystemUtils.getOSInfo(CommonConstants.LINE_SEPARATOR));
	}

}
