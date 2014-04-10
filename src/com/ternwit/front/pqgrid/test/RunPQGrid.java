package com.ternwit.front.pqgrid.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.ternwit.front.pqgrid.grid.PQGrid;
import com.ternwit.front.pqgrid.grid.PQGrid.HoverMode;
import com.ternwit.front.pqgrid.model.ColumnModel;
import com.ternwit.front.pqgrid.model.DataModel;
import com.ternwit.front.pqgrid.model.EditModel;
import com.ternwit.front.pqgrid.model.ScrollModel;
import com.ternwit.front.pqgrid.model.SelectionModel;

public class RunPQGrid {

	public static void main(String[] args) {
		PQGrid grid = new PQGrid();
		grid.setWidth(700);
		grid.setHeight(400);
		grid.setSortable(true);
		grid.setResizable(true);
		grid.setFlexHeight(true);
		grid.setFlexWidth(false);
		grid.setHoverMode(HoverMode.ROW);
		grid.setNumberCellWidth(100);
		grid.setTitle("World 100");
		grid.setWrap(false);
		
		List<String[]> data = new ArrayList<String[]>();
		data.add(new String[]{"1","Exxon Mobil 超长字符串 It determines the behaviour of cell content which doesn't fit in a single line within the width of the cell. The text in the cells wraps to next line if wrap = true otherwise the overflowing text becomes hidden and continuation symbol ... is displayed at the end.","339,938.0","36,130.0"});
		data.add(new String[]{"2","Wal-Mart Stores","315,654.0","11,231.0"});
		data.add(new String[]{"3","Royal Dutch Shell","306,731.0","25,311.0"});
		data.add(new String[]{"4","BP","267,600.0","22,341.0"});
		data.add(new String[]{"5","General Motors","192,604.0","-10,567.0"});
		data.add(new String[]{"6","Chevron","189,481.0","14,099.0"});
		data.add(new String[]{"7","DaimlerChrysler","186,106.3","3,536.3"});
		data.add(new String[]{"8","Toyota Motor","185,805.0","12,119.6"});
		data.add(new String[]{"9","Ford Motor","177,210.0","2,024.0"});
		data.add(new String[]{"10","ConocoPhillips","166,683.0","13,529.0"});
		data.add(new String[]{"11","General Electric","157,153.0","16,353.0"});
		data.add(new String[]{"12","Total","152,360.7","15,250.0"});
		data.add(new String[]{"13","ING Group","138,235.3","8,958.9"});
		data.add(new String[]{"14","Citigroup","131,045.0","24,589.0"});
		data.add(new String[]{"15","AXA","129,839.2","5,186.5"});
		data.add(new String[]{"16","Allianz","121,406.0","5,442.4"});
		data.add(new String[]{"17","Volkswagen","118,376.6","1,391.7"});
		data.add(new String[]{"18","Fortis","112,351.4","4,896.3"});
		data.add(new String[]{"19","Crédit Agricole","110,764.6","7,434.3"});
		data.add(new String[]{"20","American Intl. Group","108,905.0","10,477.0"});
		
		DataModel dataModel = new DataModel();
		dataModel.setData(data);
		
		grid.setDataModel(dataModel);
		
		ColumnModel[] colModel = new ColumnModel[4]; 
		
		ColumnModel item = new ColumnModel();
		item.setTitle("Rank");
		item.setWidth(100);
		item.setDataType("integer");
		item.setEditable(true);
		colModel[0] = item;
		
		item = new ColumnModel();
		item.setTitle("Company");
		item.setWidth(200);
		item.setDataType("string");
		colModel[1] = item;
		
		item = new ColumnModel();
		item.setTitle("Revenues");
		item.setWidth(150);
		item.setDataType("float");
		colModel[2] = item;
		
		item = new ColumnModel();
		item.setTitle("Profits");
		item.setWidth(150);
		item.setDataType("float");
		colModel[3] = item;
		
		grid.setColModel(colModel);
		
		ScrollModel scrollModel = new ScrollModel();
		scrollModel.setHorizontal(true);
		grid.setScrollModel(scrollModel);
		
		EditModel editModel = new EditModel();
		grid.setEditModel(editModel);
		
		SelectionModel selectionModel = new SelectionModel();
		grid.setSelectionModel(selectionModel);
		
		System.out.println(new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(grid));
	}

}
