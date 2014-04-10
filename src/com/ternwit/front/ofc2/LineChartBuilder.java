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
import jofc2.model.elements.DotStyle;
import jofc2.model.elements.LineChart;
import jofc2.model.elements.LineChart.Dot;
import jofc2.model.elements.LineChart.Style;

import com.ternwit.common.basic.TWTFunctionUtils;

public class LineChartBuilder {

	public static final Double MIN = 0.0;
	public static final Double MAX = 900.0;
	public static final Double STEPS = 100.0;

	public static final String LEGEND_Y_TEXT = "Y Axis";
	public static final String LEGEND_Y_COLOUR = "#736AFF";
	public static final String LEGEND_Y_FONTSIZE = "15";
	
	public static final String LEGEND_X_TEXT = "X Axis";
	public static final String LEGEND_X_COLOUR = "#736AFF";
	public static final String LEGEND_X_FONTSIZE = "15";

	public static final String TITLE_TEXT = "Open Flash Chart 2";
	public static final String TITLE_COLOUR = "#CCCCCC";
	public static final String TITLE_FONTSIZE = "18";
	
	public static final String GRID_COLOUR = "#ADB5C7";

	@SuppressWarnings("unchecked")
	public String draw(Map<Object, Object> data) {
		Chart chart = new Chart();
		LineChart lineChart = new LineChart(Style.NORMAL);

		String[] titleArgs = (String[])data.get("title");
		Text title = initTitle(titleArgs[0], titleArgs[1], titleArgs[2], titleArgs[3]);
		chart.setTitle(title);

//		Double[] yAxisArgs = (Double[])data.get("axisY");
//		YAxis axisY = initAxisY(yAxisArgs[0], yAxisArgs[1], yAxisArgs[2]);
//		chart.setYAxis(axisY);
		
		Map<Integer, Double> yAxisArgs = (Map<Integer, Double>)data.get("axisY");
		YAxis axisY = initAxisY(yAxisArgs);
		chart.setYAxis(axisY);
		
		String[] yLegendArgs = (String[])data.get("legendY");
		Text legendY = initLegendY(yLegendArgs[0], yLegendArgs[1], yLegendArgs[2], yLegendArgs[3]);
		chart.setYLegend(legendY);

		Map<Integer, Double> xAxisArgs = (Map<Integer, Double>)data.get("axisX");
		XAxis axisX = initAxisX(xAxisArgs);
		chart.setXAxis(axisX);
		
		String[] xLegendArgs = (String[])data.get("legendX");
		Text legendX = initLegendX(xLegendArgs[0], xLegendArgs[1], xLegendArgs[2], xLegendArgs[3]);
		chart.setXLegend(legendX);

		// lineChart.setTooltip("#val#%");// 设置鼠标移到点上显示的内容

		DotStyle dotStyle = initDotStyle();
		lineChart.setDotStyle(dotStyle);
		
		lineChart.addDots(initDots(xAxisArgs));

		chart.addElements(lineChart); // 把折线图加入到图表

		String json = chart.toString();// 转成 json 格式
		
		return json;
	}

	/**
	 * Create Dot Style
	 * */
	public DotStyle initDotStyle() {
		DotStyle dotStyle = new DotStyle(DotStyle.Style.HOLLOW_DOT);
		// dotStyle.setColour("");
		return dotStyle;
	}

	/**
	 * Create Dot List
	 * */
	public List<Dot> initDots(Map<Integer, Double> data) {
		Dot dot;

		List<Dot> list = new ArrayList<Dot>();

		Iterator<Integer> it = data.keySet().iterator();

		while (it.hasNext()) {
			Double value = data.get(it.next());
			dot = new Dot(value);
			list.add(dot);
		}

		return list;
	}

	/**
	 * Create Y Axis
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

//		y_axis.set3D(20);

		y_axis.setGridColour(GRID_COLOUR);
		
		return y_axis;
	}

	/**
	 * Create X Axis
	 * */
	public XAxis initAxisX(Map<Integer, Double> data) {
		XAxis x_axis = new XAxis();

		x_axis.addLabels(initLabels(data));

		return x_axis;
	}

	/**
	 * create labels for x Asix
	 * */
	public List<Label> initLabels(Map<Integer, Double> data) {
		List<Label> list = new ArrayList<Label>();
		Label label;

		Iterator<Integer> it = data.keySet().iterator();

		while (it.hasNext()) {
			Integer key = it.next();
			label = new Label(key + ".xx");
			list.add(label);
		}
		return list;
	}
	// test method
	public YAxis initAxisY(Map<Integer, Double> data) {
		YAxis y_axis = new YAxis();

		y_axis.addLabels(initLabels(data));

		return y_axis;
	}
	
	/**
	 * create Y Legend Text
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
	 * create Y Legend Text
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
	 * create title
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
