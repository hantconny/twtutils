package com.ternwit.junit.common.file;

import org.junit.Test;

import com.ternwit.common.file.TWTFileCombiner;

/*
 * Audit Log
 * 2013-01-31 full test passed
 * 
 * */
public class TestTWTFileCombiner {

	@Test
	public void testCombine() {
		String rootPath = "C:\\eclipse\\workspace\\twtutils\\testResources\\combine_root";
		String target = "C:\\eclipse\\workspace\\twtutils\\testResults\\combine_result.txt";
		
		new TWTFileCombiner().combine(rootPath, target);
	}

}
