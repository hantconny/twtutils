package com.ternwit.front.kissy.kcharts.test;

import java.util.HashMap;

import com.google.gson.GsonBuilder;
import com.ternwit.front.kissy.kcharts.chart.BarChart;
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

public class RunBarChart {

	public static void main(String[] args) {
		BarChart barChart = new BarChart();
		
		barChart.setThemeCls(ThemeCls.DEFAULT);
		
		barChart.setRenderTo("#demo1");
		
		Title title = new Title();
		title.setContent("<strong>Lockhart & Gardner</strong>");
		title.setCss(new HashMap<String, String>());
		barChart.setTitle(title);
		
		Title subTitle = new Title();
		subTitle.setContent("This is Sub-Title");
		subTitle.setCss(new HashMap<String, String>());
		barChart.setSubTitle(subTitle);
		
		Anim anim = new Anim();
		barChart.setAnim(anim);
		
		DefineKey defineKey = new DefineKey();
		defineKey.setX("x");
		defineKey.setY("y");
		barChart.setDefineKey(defineKey);
		
		XAxis xAxis = new XAxis();
		xAxis.setText(new String[]{"星期一","星期二","星期三","星期四","星期五","星期六","星期天"});
		xAxis.setCss(new HashMap<String, String>());
		barChart.setxAxis(xAxis);
		
		YAxis yAxis = new YAxis();
		yAxis.setMin(0);
//		yAxis.setMax(4200);
//		yAxis.setNum(10);
		yAxis.setCss(new HashMap<String, String>());
		barChart.setyAxis(yAxis);
		
		Tip tip = new Tip();
		tip.setCss(new HashMap<String, String>());
		tip.setTemplate("总支出：<span>{{y}}</span> 元<br/>");
		Tip.Offset offset = tip.new Offset();
		offset.setY(-10);
		tip.setOffset(offset);
		barChart.setTip(tip);
		
		// DefineKey的键值和X轴的数组里面的值一定要一致，否则前台会报错，让检查defineKey的值
		DefineKey[] lockhart = new DefineKey[7];
		lockhart[0] = new DefineKey("星期一", "700");
		lockhart[1] = new DefineKey("星期二", "600");
		lockhart[2] = new DefineKey("星期三", "500");
		lockhart[3] = new DefineKey("星期四", "400");
		lockhart[4] = new DefineKey("星期五", "300");
		lockhart[5] = new DefineKey("星期六", "200");
		lockhart[6] = new DefineKey("星期天", "100");
		
		SeriesItem lock_item = new SeriesItem();
		lock_item.setData(lockhart);
		lock_item.setText("Lockhart");
		
		DefineKey[] gardner = new DefineKey[7];
		gardner[0] = new DefineKey("星期一", "300");
		gardner[1] = new DefineKey("星期二", "400");
		gardner[2] = new DefineKey("星期三", "600");
		gardner[3] = new DefineKey("星期四", "400");
		gardner[4] = new DefineKey("星期五", "100");
		gardner[5] = new DefineKey("星期六", "200");
		gardner[6] = new DefineKey("星期天", "100");
		
		SeriesItem gard_item = new SeriesItem();
		gard_item.setData(gardner);
		gard_item.setText("Gardner");
		
		SeriesItem[] seriesItems = new SeriesItem[2];
		seriesItems[0] = lock_item;
		seriesItems[1] = gard_item;
		
		barChart.setSeries(seriesItems);
		
		Legend legend = new Legend();
		legend.setIsShow(true);
		barChart.setLegend(legend);
		
		Grid xGrids = new XGrid();
		xGrids.setIsShow(true);
		Grid yGrids = new YGrid();
		yGrids.setIsShow(true);
		
		barChart.setxGrids(xGrids);
		barChart.setyGrids(yGrids);
		
		String str = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(barChart);
		System.out.println(str);
	}

}
