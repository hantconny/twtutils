package com.ternwit.common.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ternwit.common.basic.TWTArrayUtils;
import com.ternwit.common.basic.TWTStringUtils;

/**
 * 
 * @version 1.0
 * 
 */
/*
 * only validate input, NOT validate output
 */
public final class TWTExcelReaderUtils {

	public static final String ERR_NULL_FILE = "File is null or not exist";
	public static final String ERR_NULL_WORKBOOK = "Workbook is null or empty";
	public static final String ERR_NULL_SHEET = "Sheet is null or empty";
	public static final String ERR_NULL_ROW = "Row is null or empty";
	public static final String ERR_NULL_SHEET_NAME = "Sheet name is blank or not exist";
	public static final String ERR_NULL_ARRAY = "Array is null or empty";

	public static final String ERR_SHEET_INDEX = "Sheet index is negative or out of bound";
	public static final String ERR_ROW_INDEX = "Row index is negative or out of bound";
	public static final String ERR_SKIP_LINE_NUMBER = "Skip line number is negative or out of bound";

	/* load Excel file */
	public Workbook loadExcel(File file) {

		validateFile(file);

		Workbook workbook = null;

		try {
			workbook = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* return workbook no matter it is created or null */
		return workbook;
	}

	/* get simple one sheet by sheet name */
	public Sheet getSheet(Workbook workbook, String sheetName) {

		validateWorkbook(workbook);

		validateSheetName(workbook, sheetName);

		Sheet sheet = null;

		sheet = workbook.getSheet(sheetName);

		return sheet;
	}

	/* get simple one sheet by sheet index */
	public Sheet getSheet(Workbook workbook, int sheetIndex) {

		validateWorkbook(workbook);

		validateSheetIndex(workbook, sheetIndex);

		Sheet sheet = null;

		sheet = workbook.getSheet(sheetIndex);

		return sheet;
	}

	/* get all sheets in array */
	public Sheet[] getSheetArray(Workbook workbook) {

		validateWorkbook(workbook);

		Sheet[] sheetArray = workbook.getSheets();

		return sheetArray;
	}

	/* get all sheets in list */
	public List<Sheet> getSheetList(Workbook workbook) {

		validateWorkbook(workbook);

		List<Sheet> sheetList = new ArrayList<Sheet>();

		Sheet[] sheetArray = getSheetArray(workbook);

		validateArray(sheetArray);

		for (Sheet sheet : sheetArray) {
			sheetList.add(sheet);
		}

		return sheetList;
	}

	/* get one row by row index */
	public Cell[] getRow(Sheet sheet, int rowIndex) {

		validateSheet(sheet);

		validateRowIndex(sheet, rowIndex);

		Cell[] row = null;

		row = sheet.getRow(rowIndex);

		return row;
	}

	/* get full rows */
	public List<Cell[]> getRows(Sheet sheet) {

		validateSheet(sheet);

		List<Cell[]> rows = new ArrayList<Cell[]>();

		for (int rowIndex = 0; rowIndex < sheet.getRows(); rowIndex++) {
			rows.add(sheet.getRow(rowIndex));
		}

		return rows;
	}

	/* get rows exclusive head line */
	public List<Cell[]> getRows(Sheet sheet, boolean skipHead) {

		/* no need to validate sheet, getRows(Sheet sheet) will validate sheet */
		List<Cell[]> rows = new ArrayList<Cell[]>();

		/* if skip head is null or false (NOT skip head row), return full rows */
		if (null == new Boolean(skipHead) || !skipHead) {
			rows = getRows(sheet);
			return rows;
		}

		rows = getRows(sheet);
		/* otherwise, remove head row */
		rows.remove(0);

		return rows;
	}

	/* specify skip how many lines */
	public List<Cell[]> getRows(Sheet sheet, int skipNumber) {

		/* validateSheet is required for sheet.getRows() */
		validateSheet(sheet);

		/*
		 * if skip line is greater than total row number, throw
		 * IndexOutOfBoundsException
		 */
		if (sheet.getRows() < skipNumber) {
			throw new IndexOutOfBoundsException(ERR_SKIP_LINE_NUMBER);
		}

		List<Cell[]> rows = new ArrayList<Cell[]>();

		/* if skip line is null or negative, return full rows */
		if (null == new Integer(skipNumber) || 0 >= skipNumber) {
			rows = getRows(sheet);
			return rows;
		}

		/* otherwise, remove from 0 to skipNumber(exclusive) */
		rows = getRows(sheet).subList(skipNumber, sheet.getRows() - skipNumber);

		return rows;
	}
	
	/* validate if file exist */
	private void validateFile(File file) {
		if (null == file) {
			throw new NullPointerException(ERR_NULL_FILE);
		}
		
		if (!file.exists()) {
			throw new NullPointerException(ERR_NULL_FILE);
		}
	}

	/* validate if workbook is null */
	private void validateWorkbook(Workbook workbook) {
		if (null == workbook) {
			throw new NullPointerException(ERR_NULL_WORKBOOK);
		}
	}

	/* validate if sheet is null or empty */
	private void validateSheet(Sheet sheet) {
		if (null == sheet || 0 == sheet.getRows()) {
			throw new NullPointerException(ERR_NULL_SHEET);
		}
	}

	/* validate if sheet array is null or empty */
	private <T extends Object> void validateArray(T[] array) {
		if (TWTArrayUtils.isEmpty(array)) {
			throw new NullPointerException(ERR_NULL_ARRAY);
		}
	}

	/* validate if sheet name array is null or empty */
	private void validateSheetName(Workbook workbook, String sheetName) {

		validateWorkbook(workbook);

		/* validate if sheetName is null or empty */
		if (TWTStringUtils.isBlank(sheetName)) {
			throw new NullPointerException(ERR_NULL_SHEET_NAME);
		}

		String[] sheetNames = workbook.getSheetNames();

		validateArray(sheetNames);

		/* validate if sheetName exist */
		if (!TWTArrayUtils.contains(sheetNames, sheetName)) {
			throw new NullPointerException(ERR_NULL_SHEET_NAME);
		}
	}

	/* validate if sheet index is negative or out of bound */
	private void validateSheetIndex(Workbook workbook, int sheetIndex) {

		validateWorkbook(workbook);

		/* validate if sheetIndex is negative */
		if (0 > sheetIndex) {
			throw new IndexOutOfBoundsException(ERR_SHEET_INDEX);
		}

		Sheet[] sheetArray = getSheetArray(workbook);

		validateArray(sheetArray);

		/* validate if sheetIndex exist */
		if (sheetArray.length < sheetIndex) {
			throw new IndexOutOfBoundsException(ERR_SHEET_INDEX);
		}
	}

	/* validate if row index is negative or out of bound */
	private void validateRowIndex(Sheet sheet, int rowIndex) {

		validateSheet(sheet);

		/* validate if rowIndex is negative */
		if (0 > rowIndex) {
			throw new IndexOutOfBoundsException(ERR_ROW_INDEX);
		}

		/* validate if rowIndex exist */
		if (sheet.getRows() < rowIndex) {
			throw new IndexOutOfBoundsException(ERR_ROW_INDEX);
		}
	}
	
}