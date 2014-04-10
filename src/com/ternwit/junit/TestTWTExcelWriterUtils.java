package com.ternwit.junit;

//import java.io.File;
//
//import org.junit.Test;

import com.ternwit.common.file.TWTExcelWriterUtils;

public class TestTWTExcelWriterUtils {
	TWTExcelWriterUtils utils = new TWTExcelWriterUtils();
	
//	@Test(expected = NullPointerException.class)
//	public void testCreateWritableWorkbookNull() {
//
//		utils.createWritableWorkbook(null);
//	}
//	
//	@Test
//	public void testCreateWritableWorkbookNotExist() {
//		
//		utils.createWritableWorkbook(new File("d:\\t.xls"));
//	}
//	
//	@Test
//	public void testCreateWritableWorkbook() {
//		
//		utils.createWritableWorkbook(new File("d:\\t.xls"));
//	}
//	
//	@Test(expected = NullPointerException.class)
//	public void testCreateWritableSheetNullSheetName() {
//		utils.createWritableSheet(null, 0);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCreateWritableSheetNegativeSheetIndex() {
//		utils.createWritableSheet("testSheet", -1);
//	}
//	
//	@Test(expected = NullPointerException.class)
//	public void testCreateWritableSheet() {
//		utils.createWritableSheet("testSheet", 2);
//	}
//	
//	@Test
//	public void testCreateWritableSheet() {
//		utils.createWritableWorkbook(new File("d:\\b.xls"));
//		utils.createWritableSheet("testSheet", 2);
//	}
//	
//	@Test
//	public void testWriteCell() {
//		utils.createWritableWorkbook(new File("d:\\b.xls"));
//		utils.createWritableSheet("testSheet", 2);
//		
//		Cell cell = new Label(1,1,"content1");
//		utils.writeCell(cell);
//	}
//	
//	@Test
//	public void testWriteRow() {
//		Cell[] row = new Cell[]{new Label(2,2,"content2"), new Boolean(3,3,false), new Number(5, 5, 5.66)};
//		utils.createWritableWorkbook(new File("d:\\b.xls"));
//		utils.createWritableSheet("testSheet", 2);
//		utils.writeRow(row);
//	}
//	
//	@Test
//	public void testWriteRows() {
//		Cell[] row1 = new Cell[]{new Label(2,2,"content2"), new Boolean(3,3,false), new Number(5, 5, 5.66)};
//		Cell[] row2 = new Cell[]{new Label(1,1,"content1"), new Boolean(4,4,false), new Number(6, 6, 6.77)};
//		utils.createWritableWorkbook(new File("d:\\b.xls"));
//		utils.createWritableSheet("testSheet", 2);
//		
//		List<Cell[]> list = new ArrayList<Cell[]>();
//		list.add(row1);
//		list.add(row2);
//		utils.writeRows(list);
//	}
}
