package com.ternwit.common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.ternwit.common.basic.TWTArrayUtils;
import com.ternwit.common.basic.TWTFunctionUtils;
import com.ternwit.common.basic.TWTListUtils;
import com.ternwit.common.basic.TWTStringUtils;
import com.ternwit.common.date.TWTDateUtils;

/**
 * 
 * @version 1.0
 *
 */
public final class TWTExcelWriterUtils {
	
	public static final String ERR_NULL_WORKBOOK = "Workbook is not initialized";
	public static final String ERR_NULL_SHEET = "Sheet is not initilized";
	public static final String ERR_NULL_CELL = "Cell is null";
	public static final String ERR_NULL_ROW = "Row is null or empty";
	public static final String ERR_NULL_ROWS = "Rows are null or empty";
	
	public static final String ERR_NULL_FILE = "File is null or not exist";
	
	public static final String ERR_NULL_SHEET_NAME = "Sheet name is null or empty";
	public static final String ERR_NEGATIVE_SHEET_INDEX = "Sheet index is negative";
	
	public static final String ERR_COORDINATE = "Coordinate is not right";
	
	public WritableWorkbook writableWorkbook = null;
	public WritableSheet writableSheet = null;
	
	public OutputStream outputStream = null;
	
	/* create Excel with specified file */
	public WritableWorkbook createWritableWorkbook(File file) {

		validateFile(file);

//		String name = file.getAbsolutePath();

		try {
			writableWorkbook = Workbook.createWorkbook(file);
//			outputStream = new FileOutputStream(name);
//			writableWorkbook = Workbook.createWorkbook(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return writableWorkbook;
	}

	/* create default sheet */
	public WritableSheet createWritableSheet(String sheetName, int sheetIndex) {
		
		// validateSheetName
		if (TWTStringUtils.isBlank(sheetName)) {
			throw new NullPointerException(ERR_NULL_SHEET_NAME);
		}
		// validateSheetIndex
		if (0 > sheetIndex) {
			throw new IllegalArgumentException(ERR_NEGATIVE_SHEET_INDEX);
		}
		
		validateWritableWorkbook();
		
		writableSheet = writableWorkbook.createSheet(sheetName, sheetIndex);
		
		return writableSheet;
	}

	/* coordinate[0] = column, coordinate[1] = row
	 * can accept Label, Date, Number, Boolean cell type */
	private void addCell(int[] coordinate, CellType cellType, String content) {
		
		int column = coordinate[0];
		int row = coordinate[1];
		
		WritableCell writableCell = null;
		
		if (CellType.LABEL.equals(cellType)) {
			writableCell = new Label(column, row, content);
		} else if (CellType.DATE.equals(cellType)){
			writableCell = new DateTime(column, row, TWTDateUtils.getTimeFromString(content));
		} else if (CellType.NUMBER.equals(cellType)) {
			writableCell = new Number(column, row, TWTFunctionUtils.getDoubleFromString(content));
		} else if (CellType.BOOLEAN.equals(cellType)) {
			writableCell = new jxl.write.Boolean(column, row, TWTFunctionUtils.getBooleanFromString(content));
		}
		
		try {
			
			validateWritableSheet();
			
			writableSheet.addCell(writableCell);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	private void addCell(Cell cell) {
		// validate cell
		validateCell(cell);
		
		int column = cell.getColumn();
		int row = cell.getRow();
		
		/* validate column and row */
		if (0 > row || 0 > column) {
			throw new IllegalArgumentException(ERR_COORDINATE);
		}

		/* initialize cell coordinate */
		int[] coordinate = {column, row};

		/* get cell type */
		CellType cellType = cell.getType();
		
		/* get cell content */
		String content = cell.getContents();
		
		addCell(coordinate, cellType, content);
		
	}
	
	/* write single cell */
	public void writeCell(Cell cell) {
		addCell(cell);
		write();
		close();
	}

	/* write single row */
	public void writeRow(Cell[] row) {
		
		// validate row
		if (TWTArrayUtils.isEmpty(row)) {
			throw new NullPointerException(ERR_NULL_ROW);
		}
		
		for (Cell cell : row) {
			addCell(cell);
		}
		
		write();
		close();
	}
	
	/* write multiple rows */
	public void writeRows(List<Cell[]> rows){
		
		// validate rows
		if (TWTListUtils.isNullOrEmpty(rows)) {
			throw new NullPointerException(ERR_NULL_ROWS);
		}
		
		for (Cell[] row : rows) {
			for (Cell cell : row) {
				addCell(cell);
			}
		}
		
		write();
		close();
	}

	/* validate file, if not exist, create */
	private void validateFile(File file) {
		if (null == file) {
			throw new NullPointerException(ERR_NULL_FILE);
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void validateWritableWorkbook() {
		if (null == writableWorkbook) {
			throw new NullPointerException(ERR_NULL_WORKBOOK);
		}
	}
	
	private void validateWritableSheet() {
		if (null == writableSheet) {
			throw new NullPointerException(ERR_NULL_SHEET);
		}
	}
	
	private void validateCell(Cell cell) {
		if (null == cell) {
			throw new NullPointerException(ERR_NULL_CELL);
		}
	}
	
	private void write(){
		validateWritableWorkbook();
		try {
			writableWorkbook.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* close and clear job */
	private void close() {
		closeWritableWorkbook();
		closeOutputStream();
	}
	
	/* close WritableWorkbook */
	private void closeWritableWorkbook(){
		if (null != writableWorkbook) {
			try {
				writableWorkbook.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* close OutputStream */
	private void closeOutputStream(){
		if (null != outputStream) {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
