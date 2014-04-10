package com.ternwit.front.kissy.kcharts.chart;

import com.ternwit.front.kissy.kcharts.element.Legend;
import com.ternwit.front.kissy.kcharts.element.Tip;
import com.ternwit.front.kissy.kcharts.element.axis.Axis;
import com.ternwit.front.kissy.kcharts.element.grid.Grid;
import com.ternwit.front.kissy.kcharts.entity.ColorItem;
import com.ternwit.front.kissy.kcharts.entity.DefineKey;
import com.ternwit.front.kissy.kcharts.entity.SeriesItem;

public class BarChart extends KCharts {
	private static final long serialVersionUID = -8721701847316196987L;
	// // 放置kchart的元素ID
	// // div的id为demo，那么renderTo的值为#demo
	// private String renderTo;
	// X轴
	private Axis xAxis;
	// Y轴
	private Axis yAxis;
	// 坐标点集合
	private SeriesItem[] series;
	// 定义坐标点的键名
	private DefineKey defineKey;

	// 定义线的颜色
	private ColorItem[] colors;
	// // 动画
	// private Anim anim;

	// // 主标题
	// private Title title;
	// // 副标题
	// private Title subTitle;

	// 显示X轴的竖网格线
	private Grid xGrids;
	// 显示Y轴的横网格线
	private Grid yGrids;

	// 坐标点的注释
	private Tip tip;
	// 图例
	private Legend legend;

	public Axis getxAxis() {
		return xAxis;
	}

	public void setxAxis(Axis xAxis) {
		this.xAxis = xAxis;
	}

	public Axis getyAxis() {
		return yAxis;
	}

	public void setyAxis(Axis yAxis) {
		this.yAxis = yAxis;
	}

	public SeriesItem[] getSeries() {
		return series;
	}

	public void setSeries(SeriesItem[] series) {
		this.series = series;
	}

	public DefineKey getDefineKey() {
		return defineKey;
	}

	public void setDefineKey(DefineKey defineKey) {
		this.defineKey = defineKey;
	}

	public ColorItem[] getColors() {
		return colors;
	}

	public void setColors(ColorItem[] colors) {
		this.colors = colors;
	}

	public Grid getxGrids() {
		return xGrids;
	}

	public void setxGrids(Grid xGrids) {
		this.xGrids = xGrids;
	}

	public Grid getyGrids() {
		return yGrids;
	}

	public void setyGrids(Grid yGrids) {
		this.yGrids = yGrids;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

}
