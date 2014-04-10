package com.ternwit.front.ofc2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ternwit.common.basic.TWTFunctionUtils;

import jofc2.model.Chart;
import jofc2.model.axis.Label;
import jofc2.model.axis.XAxis;
import jofc2.model.axis.YAxis;
import jofc2.model.elements.BarChart;
import jofc2.model.elements.BarChart.Bar;
import jofc2.model.elements.BarChart.Style;

public class BarChartBuilder {

	public static final Double MIN = 0.0;
	public static final Double MAX = 900.0;
	public static final Double STEPS = 100.0;
	
	/**
	 * data map structure:
	 * 	0: [min, max, steps];
	 * 	1: 0.0;
	 * 	2: 1.0;
	 * */
	public String draw(Map<Object, Object> data) {
		Chart chart = new Chart();
		
		/* first element of data map is args for Y axis 
		 * [0] min
		 * [1] max
		 * [2] steps */
		Double[] yAxixArr = (Double[])data.get(0);
		if (TWTFunctionUtils.isEmpty(yAxixArr)) {
			yAxixArr = new Double[]{BarChartBuilder.MIN, BarChartBuilder.MAX, BarChartBuilder.STEPS};
		}
		
		/* create Y Axis */
		YAxis y_axis = initAxisY(yAxixArr[0], yAxixArr[1], yAxixArr[2]);
		chart.setYAxis(y_axis);
		
		/* remove first element from data map */
		data.remove(0);
		
		/* create X Axis */
		XAxis x_axis = initAxisX(data);
		chart.setXAxis(x_axis);

		/* add customize style code */
		BarChart barChart = new BarChart(Style.NORMAL);
		barChart.addBars(initBars(data));
		chart.addElements(barChart);

		String json = chart.toString();

		return json;
	}

	/**
	 * Create X Axis
	 * */
	public XAxis initAxisX(Map<Object, Object> data) {
		XAxis x_axis = new XAxis();

		x_axis.addLabels(initLabels(data));
		
		return x_axis;
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
		
		return y_axis;
	}

	/**
	 *  create labels for x Asix
	 * */
	public List<Label> initLabels(Map<Object, Object> data) {
		List<Label> list = new ArrayList<Label>();
		Label label;
		
		Iterator<Object> it = data.keySet().iterator();

		while (it.hasNext()) {
			Integer key = (Integer)it.next();
			label = new Label(key+"");
			list.add(label);
		}
		return list;
	}
	
	/**
	 * create bars 
	 * */
	public List<Bar> initBars(Map<Object, Object> data) {
		List<Bar> list = new ArrayList<Bar>();
		Bar bar;

		Iterator<Object> it = data.keySet().iterator();
		
		while (it.hasNext()) {
			Double value = (Double)data.get(it.next());
			bar = new Bar(value);
			list.add(bar);
		}
		return list;
	}
	
}
