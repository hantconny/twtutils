package com.ternwit.front.kissy.kcharts.test;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.ternwit.front.kissy.kcharts.chart.RatioChart;
import com.ternwit.front.kissy.kcharts.chart.RatioChart.Type;
import com.ternwit.front.kissy.kcharts.entity.ColumnItem;
import com.ternwit.front.kissy.kcharts.entity.RatioStyle;

public class RunRatioChart {

	public static void main(String[] args) {
		RatioChart ratioChart = new RatioChart();
		ratioChart.setContainer("#demo1");
		ratioChart.setType(Type.MAN);
		
		RatioStyle styles = new RatioStyle();
		RatioStyle.ContainerStyle containerStyles = styles.new ContainerStyle();
		containerStyles.setPaddingTop(100);
		styles.setContainerStyles(containerStyles);
		
		RatioStyle.ItemStyle itemStyles = styles.new ItemStyle();
		itemStyles.setWidth(950);
		itemStyles.setHeight(90);
		itemStyles.setMarginBottom(20);
		styles.setItemStyles(itemStyles);
		
		RatioStyle.TitleStyle titleStyles = styles.new TitleStyle();
		titleStyles.setWidth(120);
		titleStyles.setHeight(50);
		titleStyles.setFontSize(14);
		styles.setTitleStyles(titleStyles);
		
		RatioStyle.BackStyle backStyles = styles.new BackStyle();
		backStyles.setWidth(700);
		backStyles.setHeight(50);
		backStyles.setBackground("#ccc");
		styles.setBackStyles(backStyles);
		
		RatioStyle.FrontStyle frontStyles = styles.new FrontStyle();
		frontStyles.setHeight(50);
		frontStyles.setBackground("#3c89b5");
		styles.setFrontStyles(frontStyles);
		
		RatioStyle.IntroStyle introStyles = styles.new IntroStyle();
		introStyles.setWidth(400);
		introStyles.setHeight(30);
		introStyles.setFontSize(24);
		introStyles.setColor("#3c89b5");
		styles.setIntroStyles(introStyles);
		
		ratioChart.setStyles(styles);
		
		ColumnItem[] cols = new ColumnItem[3];
		ColumnItem item0 = new ColumnItem();
		ColumnItem item1 = new ColumnItem();
		ColumnItem item2 = new ColumnItem();
		
		ColumnItem.Title title = item0.new Title();
		title.setText("男女通吃");
		title.setHtml("");
		title.setStyles(new HashMap<String, String>());
		item0.setTitle(title);
		
		ColumnItem.Graph graph = item0.new Graph();
		graph.setPer(20);
		Map<String, String> g_styles = new HashMap<String, String>();
		g_styles.put("backgroundColor", "#f44");
		graph.setStyles(g_styles);
		item0.setGraph(graph);
		
		ColumnItem.Intro intro = item0.new Intro();
		intro.setText("20%");
		intro.setHtml("");
		intro.setStyles(new HashMap<String, String>());
		item0.setIntro(intro);
		
		cols[0] = item0;
		
		title = item1.new Title();
		title.setText("喜欢男人");
		title.setHtml("");
		title.setStyles(new HashMap<String, String>());
		item1.setTitle(title);
		
		graph = item1.new Graph();
		graph.setPer(40);
		item1.setGraph(graph);
		
		intro = item1.new Intro();
		intro.setText("40%");
		intro.setHtml("");
		intro.setStyles(new HashMap<String, String>());
		item1.setIntro(intro);
		
		cols[1] = item1;
		
		title = item2.new Title();
		title.setText("喜欢女人");
		title.setHtml("");
		title.setStyles(new HashMap<String, String>());
		item2.setTitle(title);
		
		graph = item2.new Graph();
		graph.setPer(80);
		item2.setGraph(graph);
		
		intro = item2.new Intro();
		intro.setText("80%");
		intro.setHtml("");
		intro.setStyles(new HashMap<String, String>());
		item2.setIntro(intro);
		
		cols[2] = item2;
		
		ratioChart.setCols(cols);
		
		String str = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(ratioChart);
		System.out.println(str);
		
	}

}
