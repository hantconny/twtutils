package com.ternwit.front.ofc2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jofc2.model.Chart;
import jofc2.model.Text;
import jofc2.model.axis.Label;
import jofc2.model.axis.XAxis;
import jofc2.model.axis.YAxis;
import jofc2.model.elements.Element;

import com.ternwit.common.basic.TWTFunctionUtils;

/* 
 * NOT tested yet
 * Do NOT use this class
 *  */
public abstract class TWTChartUtils {
	public static final Double MIN = 0.0;
	public static final Double MAX = 900.0;
	public static final Double STEPS = 100.0;

	public static final String LEGEND_COLOUR = "#736AFF";
	public static final String LEGEND_FONTSIZE = "15";

	public static final String LEGEND_Y_TEXT = "Y Axis";
	
	public static final String LEGEND_X_TEXT = "X Axis";

	public static final String TITLE_TEXT = "Open Flash Chart 2";
	public static final String TITLE_COLOUR = "#CCCCCC";
	public static final String TITLE_FONTSIZE = "18";
	
	public static final String GRID_COLOUR = "#ADB5C7";

	public String draw(Map<Object, Object> data) {
		/*
		 * structure of data
		 * 
		 * target is String
		 * 
		 * title is String[]
		 * 
		 * legendX is String[]
		 * legendY is String[]
		 * 
		 * axisX is Map<Integer, TWTChartContent>
		 * axisY is Map<Integer, TWTChartContent>
		 * 
		 * TWTChartContent has two String field
		 * 
		 * target  : jofc2.model.elements.LineChart
		 * title   : {
		 * 				"Title"
		 * 				"TITLE_FONTSIZE"
		 * 				"TITLE_COLOUR"
		 * 				"TITLE_ALIGN"
		 * 			 }
		 * legendY : {
		 * 				"OFC2 Y Axis"
		 * 				"LEGEND_Y_FONTSIZE"
		 * 				"LEGEND_Y_COLOUR"
		 * 				"LEGEND_Y_ALIGN"
		 * 			 }
		 * legendX : {
		 * 				"OFC2 X Axis"
		 * 				"LEGEND_X_FONTSIZE"
		 * 				"LEGEND_X_COLOUR"
		 * 				"LEGEND_Y_ALIGN"
		 * 			 }
		 * axisX   : {}
		 * axisY   : {}
		 * */
		
		
		Chart chart = new Chart();
		
		String target = data.get("target").toString();
		Element element = initElement(target);
		
		String[] titleArgs = (String[])data.get("title");
		/*
		 * arg[0] text, eg 2012 Income Chart
		 * arg[1] font_size, eg 12
		 * arg[2] String colour, eg #CCCCCC
		 * arg[3] String align, eg center
		 * 
		 * */
		Text title = initTitle(titleArgs[0], titleArgs[1], titleArgs[2], titleArgs[3]);
		
		String[] yLegendArgs = (String[])data.get("legendY");
		Text legendY = initLegendY(yLegendArgs[0], yLegendArgs[1], yLegendArgs[2], yLegendArgs[3]);
		
		String[] xLegendArgs = (String[])data.get("legendX");
		Text legendX = initLegendX(xLegendArgs[0], xLegendArgs[1], xLegendArgs[2], xLegendArgs[3]);
		
		/* build axis Y, can be any one of two construct method (simple min/step/max or map param) */
		Object yAxisArgs = data.get("axisY");
		YAxis yAxis = initAxisY(yAxisArgs);
		
		/* build axis X, can be any one of two construct method (simple min/step/max or map param) */
		Object xAxisArgs = data.get("axisX");
		XAxis xAxis = initAxisX(xAxisArgs);
		
		chart.setTitle(title);
		chart.setYLegend(legendY);
		chart.setXLegend(legendX);
		chart.setYAxis(yAxis);
		chart.setXAxis(xAxis);
		
		/* add content to chart */
		addContent(element);
		/* add content to chart */
		
		chart.addElements(element);
		
		String json = chart.toString();
		
		return json;
	}
	
	public abstract void addContent(Element element);
	
	public XAxis initAxisX(Map<Integer, TWTChartContent> data) {
		XAxis x_axis = new XAxis();
		
		x_axis.addLabels(initLabels(data));
		
		return x_axis;
	}
	
	/**
	 * Invoke by initAxisY(Object object)
	 * A complicate iterator method
	 * */
	public YAxis initAxisY(Map<Integer, TWTChartContent> data) {
		YAxis y_axis = new YAxis();
		
		y_axis.addLabels(initLabels(data));
		
		return y_axis;
	}

	/**
	 * This method takes a Map as parameter
	 * Iterator the map and construct a jofc2.model.axis.Label list
	 * This is a ordered list
	 * 
	 * */
	public List<Label> initLabels(Map<Integer, TWTChartContent> data) {
		List<Label> list = new ArrayList<Label>();
		Label label;

		Iterator<Integer> it = data.keySet().iterator();

		while (it.hasNext()) {
			Integer key = it.next();
			label = new Label(data.get(key).getLabel());
			list.add(label);
		}
		return list;
	}
	
	/**
	 * Create Specific Chart - LineChart, BarChart, PieChart, etc
	 * */
	public Element initElement(String target) {
		Element element = null;
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(target);
			element = (Element)clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	/**
	 * If input is a Double Array, we will create axis with min, max and step, which is a simple and auto
	 * If input is a Map, we will create axis by iterating the map.
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public YAxis initAxisY(Object object) {
		if (object instanceof Map) {
			/* iterator the map for each label */
			return initAxisY((Map<Integer, TWTChartContent>) object);
		} else {
			/* simple min step max method */
			Double[] yAxisArgs = (Double[]) object;
			return initAxisY(yAxisArgs[0], yAxisArgs[1], yAxisArgs[2]);
		}
	}
	
	@SuppressWarnings("unchecked")
	public XAxis initAxisX(Object object) {
		if (object instanceof Map) {
			return initAxisX((Map<Integer, TWTChartContent>) object);
		} else {
			Double[] xAxisArgs = (Double[]) object;
			return initAxisX(xAxisArgs[0], xAxisArgs[1], xAxisArgs[2]);
		}
	}
	
	/**
	 * Invoke by initAxisY(Object object)
	 * A simple min step max method
	 * */
	public YAxis initAxisY(Double min, Double max, Double steps) {
		YAxis y_axis = new YAxis();

		if (TWTFunctionUtils.isEmpty(min)) {
			min = BarChartBuilder.MIN;
		}
		if (TWTFunctionUtils.isEmpty(max)) {
			max = BarChartBuilder.MAX;
		}
		if (TWTFunctionUtils.isEmpty(steps)) {
			steps = BarChartBuilder.STEPS;
		}

		y_axis.setMin(min);
		y_axis.setMax(max);
		y_axis.setSteps(steps);

//		y_axis.set3D(0);

		y_axis.setGridColour(GRID_COLOUR);
		
		y_axis.setColour("#d000d0");
		
		return y_axis;
	}
	
	/**
	 * Create Axis Y
	 * */
	public XAxis initAxisX(Double min, Double max, Double steps) {
		XAxis x_axis = new XAxis();
		
		if (TWTFunctionUtils.isEmpty(min)) {
			min = BarChartBuilder.MIN;
		}
		if (TWTFunctionUtils.isEmpty(max)) {
			max = BarChartBuilder.MAX;
		}
		if (TWTFunctionUtils.isEmpty(steps)) {
			steps = BarChartBuilder.STEPS;
		}
		
		x_axis.setMin(min);
		x_axis.setMax(max);
		x_axis.setSteps(steps);
		
//		x_axis.set3D(0);
		
//		x_axis.setGridColour(GRID_COLOUR);
		
		return x_axis;
	}

	/**
	 * Create Y Legend Text
	 * */
	public Text initLegendY(String text, String font_size, String colour, String align) {

		if (TWTFunctionUtils.isEmpty(text)) {
			text = LineChartBuilder.LEGEND_Y_TEXT;
		}
		if (TWTFunctionUtils.isEmpty(font_size)) {
			font_size = LineChartBuilder.LEGEND_Y_FONTSIZE;
		}
		if (TWTFunctionUtils.isEmpty(colour)) {
			colour = LineChartBuilder.LEGEND_Y_COLOUR;
		}
		if (TWTFunctionUtils.isEmpty(align)) {
			align = Text.TEXT_ALIGN_CENTER;
		}

		return initText(text, new Integer(font_size), colour, align);
	}
	
	/**
	 * Create Y Legend Text
	 * */
	public Text initLegendX(String text, String font_size, String colour, String align) {
		
		if (TWTFunctionUtils.isEmpty(text)) {
			text = LineChartBuilder.LEGEND_X_TEXT;
		}
		if (TWTFunctionUtils.isEmpty(font_size)) {
			font_size = LineChartBuilder.LEGEND_X_FONTSIZE;
		}
		if (TWTFunctionUtils.isEmpty(colour)) {
			colour = LineChartBuilder.LEGEND_X_COLOUR;
		}
		if (TWTFunctionUtils.isEmpty(align)) {
			align = Text.TEXT_ALIGN_CENTER;
		}
		
		return initText(text, new Integer(font_size), colour, align);
	}

	/**
	 * Create Chart Title
	 * */
	public Text initTitle(String text, String font_size, String colour, String align) {
		
		if (TWTFunctionUtils.isEmpty(text)) {
			text = LineChartBuilder.TITLE_TEXT;
		}
		if (TWTFunctionUtils.isEmpty(font_size)) {
			font_size = LineChartBuilder.TITLE_FONTSIZE;
		}
		if (TWTFunctionUtils.isEmpty(colour)) {
			colour = LineChartBuilder.TITLE_COLOUR;
		}
		if (TWTFunctionUtils.isEmpty(align)) {
			align = Text.TEXT_ALIGN_CENTER;
		}
		
		return initText(text, new Integer(font_size), colour, align);
	}

	private Text initText(String text, Integer font_size, String colour, String align) {
		Text txt = new Text(text);
		txt.setStyle(Text.createStyle(font_size, colour, align));
		return txt;
	}
}
