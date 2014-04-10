package com.ternwit.front.kissy.kcharts.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.ternwit.front.kissy.kcharts.chart.ScatterChart;
import com.ternwit.front.kissy.kcharts.chart.KCharts.ThemeCls;
import com.ternwit.front.kissy.kcharts.element.Tip;
import com.ternwit.front.kissy.kcharts.element.Title;
import com.ternwit.front.kissy.kcharts.element.Tip.AlignX;
import com.ternwit.front.kissy.kcharts.element.Tip.AlignY;
import com.ternwit.front.kissy.kcharts.element.axis.XAxis;
import com.ternwit.front.kissy.kcharts.element.axis.YAxis;
import com.ternwit.front.kissy.kcharts.element.grid.XGrid;
import com.ternwit.front.kissy.kcharts.element.grid.YGrid;
import com.ternwit.front.kissy.kcharts.entity.Anim;
import com.ternwit.front.kissy.kcharts.entity.Points;
import com.ternwit.front.kissy.kcharts.entity.ScatterItem;

public class RunScatterChart {

	public static void main(String[] args) {
		ScatterChart scatterChart = new ScatterChart();
		
		scatterChart.setThemeCls(ThemeCls.DEFAULT);
		
		scatterChart.setRenderTo("#demo1");
		
		Title title = new Title();
		title.setContent("中文Title");
		scatterChart.setTitle(title);
		
		Title subTitle = new Title();
		subTitle.setContent("中文副Title");
		scatterChart.setSubTitle(subTitle);
		
		Points points = new Points();
		Points.Attr attr = points.new Attr();
		attr.setR(3.0);
		points.setAttr(attr);
		scatterChart.setPoints(points);
		
		Anim anim = new Anim();
		scatterChart.setAnim(anim);
		
		XGrid xGrids = new XGrid();
		scatterChart.setxGrids(xGrids);
		
		YGrid yGrids = new YGrid();
		scatterChart.setyGrids(yGrids);
		
		XAxis xAxis = new XAxis();
		xAxis.setNum(10);
		scatterChart.setxAxis(xAxis);
		
		YAxis yAxis = new YAxis();
		yAxis.setNum(10);
		scatterChart.setyAxis(yAxis);
		
		Tip tip = new Tip();
		tip.setTemplate("信息: {{y[0]}}, {{y[1]}}");
		
		Tip.Offset offset = tip.new Offset();
		offset.setX(-10);
		offset.setY(-10);
		tip.setOffset(offset);
		
		tip.setAlignX(AlignX.CENTER);
		tip.setAlignY(AlignY.MIDDLE);
		
		scatterChart.setTip(tip);
		
		ScatterItem[] series = new ScatterItem[2];
		
		ScatterItem item1 = new ScatterItem();
		item1.setColor("rgba(223, 83, 83, .5)");
		item1.setName("Female");
		List<Double[]> data1 = new ArrayList<Double[]>();
		data1.add(new Double[]{161.2, 51.6});
		data1.add(new Double[]{176.5, 71.8});
		data1.add(new Double[]{157.5, 76.8});
		item1.setData(data1);
		
		ScatterItem item2 = new ScatterItem();
		item2.setColor("rgba(119, 152, 191, .5)");
		item2.setName("Male");
		List<Double[]> data2 = new ArrayList<Double[]>();
		data2.add(new Double[]{174.0, 65.6});
		data2.add(new Double[]{175.3, 71.8});
		data2.add(new Double[]{180.3, 83.2});
		item2.setData(data2);
		
		series[0] = item1;
		series[1] = item2;
		
		scatterChart.setSeries(series);
		
		String str = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(scatterChart);
		System.out.println(str);
	}

}
