package com.ternwit.common.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ternwit.common.basic.TWTListUtils;

/*
 * Audit Log
 * 2013-01-13 change List<String> process(String rootPath) into private
 * 			  change void combine(List<String> list, String target) into private
 * 			  add public void combine(String rootPath, String target) and expose to users for invoking
 */

/* 
 * This class combine all files' content into one file
 * It recurse all folders including child folders
 * */
public final class TWTFileCombiner {

	private List<String> list = new ArrayList<String>();

	/* return a file path list according to root folder path */
	private List<String> process(String rootPath) {
		File rootDir = new File(rootPath);

		recurse(rootDir.listFiles());

		return list;
	}

	/* recurse all folder and store file path in global variable list */
	private void recurse(File[] dirs) {
		for (File tmp : dirs) {
			if (tmp.isDirectory()) {
				recurse(tmp.listFiles());
			}
			if (tmp.isFile()) {
				list.add(tmp.getAbsolutePath());
			}
		}
	}

	/* combine all files' content into target file */
	private void combine(List<String> list, String target) {
		if (TWTListUtils.isNullOrEmpty(list)) {
			throw new IllegalArgumentException("param0 list is null or empty");
		}
		
		String content = "";
		for (String str : list) {
			content += new TWTFileUtils().readFileToString(str);
		}
		new TWTFileUtils().writeFile(content, target);
	}
	
	/* expose to users to invoke*/
	public void combine(String rootPath, String target) {
		if (StringUtils.isBlank(rootPath)) {
			throw new IllegalArgumentException("param0 rootPath is null or empty");
		}
		if (StringUtils.isBlank(target)) {
			throw new IllegalArgumentException("param1 target is null or empty");
		}
		combine(process(rootPath), target);
	}

}
