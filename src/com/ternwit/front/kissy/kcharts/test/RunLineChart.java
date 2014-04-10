package com.ternwit.front.kissy.kcharts.test;

import java.util.HashMap;

import com.google.gson.GsonBuilder;
import com.ternwit.front.kissy.kcharts.chart.LineChart;
import com.ternwit.front.kissy.kcharts.chart.KCharts.LineType;
import com.ternwit.front.kissy.kcharts.chart.KCharts.ThemeCls;
import com.ternwit.front.kissy.kcharts.element.Legend;
import com.ternwit.front.kissy.kcharts.element.Tip;
import com.ternwit.front.kissy.kcharts.element.Title;
import com.ternwit.front.kissy.kcharts.element.axis.XAxis;
import com.ternwit.front.kissy.kcharts.element.axis.YAxis;
import com.ternwit.front.kissy.kcharts.element.grid.Grid;
import com.ternwit.front.kissy.kcharts.element.grid.XGrid;
import com.ternwit.front.kissy.kcharts.element.grid.YGrid;
import com.ternwit.front.kissy.kcharts.entity.Anim;
import com.ternwit.front.kissy.kcharts.entity.DefineKey;
import com.ternwit.front.kissy.kcharts.entity.SeriesItem;

public class RunLineChart {

	public static void main(String[] args) {
		
		LineChart lineChart = new LineChart();
		
		lineChart.setLineType(LineType.ARC);
		lineChart.setThemeCls(ThemeCls.DEFAULT);
		
		lineChart.setComparable(true);
		
//		lineChart.setThemeCls(ThemeCls.DEFAULT);
		
		Title title = new Title();
		title.setContent("<h3><strong>This is Title</strong></h3>");
		title.setCss(new HashMap<String, String>());
		
		Title subTitle = new Title();
		subTitle.setContent("This is Sub-Title");
		subTitle.setCss(new HashMap<String, String>());
		
		Anim anim = new Anim();
		
		DefineKey defineKey = new DefineKey();
		defineKey.setX("x");
		defineKey.setY("y");
		
		XAxis xAxis = new XAxis();
		xAxis.setText(new String[]{"星期1","星期2","星期3","星期4","星期5","星期6","星期7"});
		xAxis.setCss(new HashMap<String, String>());
		
		YAxis yAxis = new YAxis();
		yAxis.setMin(0);
//		yAxis.setMax(4200);
//		yAxis.setNum(10);
		yAxis.setCss(new HashMap<String, String>());
		
		Tip tip = new Tip();
		tip.setCss(new HashMap<String, String>());
		tip.setTemplate("{{#each datas as data index}}{{#if index == 0}}<h3>{{data.week}}</h3>{{/if}}{{data.text}} <span>{{data.y}}</span> <span>元</span><br/>{{/each}}");
		
		// DefineKey的键值和X轴的数组里面的值一定要一致，否则前台会报错，让检查defineKey的值
		DefineKey[] data = new DefineKey[7];
		data[0] = new DefineKey("星期1", "700");
		data[1] = new DefineKey("星期2", "600");
		data[2] = new DefineKey("星期3", "500");
		data[3] = new DefineKey("星期4", "400");
		data[4] = new DefineKey("星期5", "300");
		data[5] = new DefineKey("星期6", "200");
		data[6] = new DefineKey("星期7", "100");
		
		SeriesItem item = new SeriesItem();
		item.setData(data);
		item.setText("Lockhart");
		
		DefineKey[] gardner = new DefineKey[7];
		gardner[0] = new DefineKey("星期1", "700");
		gardner[1] = new DefineKey("星期2", "600");
		gardner[2] = new DefineKey("星期3", "500");
		gardner[3] = new DefineKey("星期4", "400");
		gardner[4] = new DefineKey("星期5", "300");
		gardner[5] = new DefineKey("星期6", "200");
		gardner[6] = new DefineKey("星期7", "100");
		
		SeriesItem item_g = new SeriesItem();
		item_g.setData(gardner);
		item_g.setText("Gardner");
		
		SeriesItem[] seriesItems = new SeriesItem[2];
		seriesItems[0] = item;
		seriesItems[1] = item_g;
		
//		Series series = new Series();
//		series.setSeriesItems(seriesItems);
		
		Legend legend = new Legend();
		legend.setIsShow(true);
		
		Grid xGrid = new XGrid();
		xGrid.setIsShow(false);
		Grid yGrid = new YGrid();
		yGrid.setIsShow(false);
		
		lineChart.setxGrids(xGrid);
		lineChart.setyGrids(yGrid);
		
//		lineChart.setLineType(LineType.ARC);
		
		lineChart.setDefineKey(defineKey);
		lineChart.setRenderTo("#demo1");
		lineChart.setSeries(seriesItems);
		lineChart.setSubTitle(subTitle);
		lineChart.setTip(tip);
		lineChart.setTitle(title);
		lineChart.setxAxis(xAxis);
		lineChart.setyAxis(yAxis);
		lineChart.setAnim(anim);
		
		String str = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(lineChart);
		System.out.println(str);
	}

}
