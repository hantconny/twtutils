package com.ternwit.junit;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.Assert;
import org.junit.Test;

import com.ternwit.common.file.TWTExcelReaderUtils;

public class TestTwExcelUtils {

// // To test validateXXX() method, change private to public
//	@Test(expected = NullPointerException.class)
//	public void testValidateWorkbook() {
//		Workbook nullWorkbook = null;
//		new TwExcelUtils().validateWorkbook(nullWorkbook);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testValidateSheet() {
//		Sheet nullSheet = null;
//		new TwExcelUtils().validateSheet(nullSheet);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testValidateArray() {
//		Object[] nullArr = null;
//		Object[] emptyArr = {};
//		Object[] blankArr = {null};
//		new TwExcelUtils().validateArray(nullArr);
//		new TwExcelUtils().validateArray(emptyArr);
//		new TwExcelUtils().validateArray(blankArr);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testValidateSheetName() {
//		/* null workbook, null sheet name */
//		new TwExcelUtils().validateSheetName(null, null);
//		/* null workbook, empty sheet name */
//		new TwExcelUtils().validateSheetName(null, "");
//		/* null workbook, blank sheet name */
//		new TwExcelUtils().validateSheetName(null, "   ");
//		
//		Workbook workbook = null;
//		try {
//			workbook = Workbook.getWorkbook(new File("d:\\acount.xls"));
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		/* null sheet name */
//		new TwExcelUtils().validateSheetName(workbook, null);
//		/* empty sheet name */
//		new TwExcelUtils().validateSheetName(workbook, "");
//		/* blank sheet name */
//		new TwExcelUtils().validateSheetName(workbook, "   ");
//		/* not exist sheet name */
//		new TwExcelUtils().validateSheetName(workbook, "test");
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testValidateSheetIndexNull() {
//		/* null workbook, negative sheet index */
//		new TwExcelUtils().validateSheetIndex(null, -10);
//		/* null workbook, greater sheet index */
//		new TwExcelUtils().validateSheetIndex(null, 80000);
//	}
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testValidateSheetIndex() {
//		Workbook workbook = null;
//		try {
//			workbook = Workbook.getWorkbook(new File("d:\\acount.xls"));
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		/* negative sheet index */
//		new TwExcelUtils().validateSheetIndex(workbook, -10);
//		/* greater sheet index */
//		new TwExcelUtils().validateSheetIndex(workbook, 80000);
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testValidateRowIndexNull() {
//		/* null sheet, negative index */
//		new TwExcelUtils().validateRowIndex(null, -2);
//		/* null sheet, greater index */
//		new TwExcelUtils().validateRowIndex(null, 8000);
//	}
//	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testValidateRowIndex() {
//		Workbook workbook = null;
//		try {
//			workbook = Workbook.getWorkbook(new File("d:\\acount.xls"));
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Sheet sheet = workbook.getSheet(0);
//		
//		/* negative index */
//		new TwExcelUtils().validateRowIndex(sheet, -2);
//		/* greater index */
//		new TwExcelUtils().validateRowIndex(sheet, 8000);
//	}

	@Test(expected = NullPointerException.class)
	public void testLoadExcelNull() {
		new TWTExcelReaderUtils().loadExcel(null);
	}
	
	@Test
	public void testLoadExcel() {
		new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
	}

	@Test(expected = NullPointerException.class)
	public void testGetSheetWorkbookStringNull() {
		/* null workbook, null sheet */
		new TWTExcelReaderUtils().getSheet(null, null);
		/* null workbook, empty sheet */
		new TWTExcelReaderUtils().getSheet(null, "");
		/* null workbook, blank sheet */
		new TWTExcelReaderUtils().getSheet(null, "   ");
		/* null workbook, not exist sheet */
		new TWTExcelReaderUtils().getSheet(null, "5月");
		
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		/* null sheet */
		new TWTExcelReaderUtils().getSheet(workbook, null);
		/* empty sheet */
		new TWTExcelReaderUtils().getSheet(workbook, "");
		/* blank sheet */
		new TWTExcelReaderUtils().getSheet(workbook, "   ");
		/* not exist sheet */
		new TWTExcelReaderUtils().getSheet(workbook, "5月");
		
	}
	
	@Test
	public void testGetSheetWorkbookString() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		Sheet sheet = new TWTExcelReaderUtils().getSheet(workbook, "6月");
		Assert.assertNotNull(sheet);
	}
	

	@Test
	public void testGetSheetWorkbookInt() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		Sheet sheet = new TWTExcelReaderUtils().getSheet(workbook, 0);
		Assert.assertNotNull(sheet);
	}

	@Test
	public void testGetSheetArray() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		Sheet[] sheets = new TWTExcelReaderUtils().getSheetArray(workbook);
		assertEquals(2, sheets.length);
	}

	@Test
	public void testGetSheetList() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		List<Sheet> list = new TWTExcelReaderUtils().getSheetList(workbook);
		assertEquals(2, list.size());
	}

	@Test
	public void testGetRow() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		Cell[] cells = new TWTExcelReaderUtils().getRow(workbook.getSheet(0), 0);
		assertEquals("日期", cells[0].getContents());
		assertEquals("名目", cells[1].getContents());
		assertEquals("价格", cells[2].getContents());
		assertEquals("小计", cells[3].getContents());
		assertEquals("总计", cells[4].getContents());
	}

	@Test
	public void testGetRowsSheet() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		List<Cell[]> rows = new TWTExcelReaderUtils().getRows(workbook.getSheet(0));
		
		Cell[] row = rows.get(0);
		assertEquals("日期", row[0].getContents());
		assertEquals("名目", row[1].getContents());
		assertEquals("价格", row[2].getContents());
		assertEquals("小计", row[3].getContents());
		assertEquals("总计", row[4].getContents());
	}

	@Test
	public void testGetRowsSheetBoolean() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		List<Cell[]> rows = new TWTExcelReaderUtils().getRows(workbook.getSheet(0), false);
		
		Cell[] row = rows.get(0);
		assertEquals("日期", row[0].getContents());
		assertEquals("名目", row[1].getContents());
		assertEquals("价格", row[2].getContents());
		assertEquals("小计", row[3].getContents());
		assertEquals("总计", row[4].getContents());
		
		rows = new TWTExcelReaderUtils().getRows(workbook.getSheet(0), true);
		
		row = rows.get(0);
		assertEquals("12-6-1", row[0].getContents());
		assertEquals("早饭", row[1].getContents());
		assertEquals("2", row[2].getContents());
		assertEquals("30", row[3].getContents());
		assertEquals("92", row[4].getContents());
	}

	@Test
	public void testGetRowsSheetInt() {
		Workbook workbook = new TWTExcelReaderUtils().loadExcel(new File("d:\\acount.xls"));
		List<Cell[]> rows = new TWTExcelReaderUtils().getRows(workbook.getSheet(0), 5);
		
		Cell[] row = rows.get(0);
		assertEquals("12-6-2", row[0].getContents());
		assertEquals("早饭", row[1].getContents());
		assertEquals("2", row[2].getContents());
		assertEquals("37", row[3].getContents());
		
	}

}
