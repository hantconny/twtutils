package com.ternwit.front.kissy.kcharts.chart;

import com.ternwit.front.kissy.kcharts.element.Legend;
import com.ternwit.front.kissy.kcharts.element.Tip;
import com.ternwit.front.kissy.kcharts.element.axis.Axis;
import com.ternwit.front.kissy.kcharts.element.grid.Grid;
import com.ternwit.front.kissy.kcharts.entity.Points;
import com.ternwit.front.kissy.kcharts.entity.ScatterItem;

public class ScatterChart extends KCharts {
	private static final long serialVersionUID = 8739496833791749015L;
	// X轴
	private Axis xAxis;
	// Y轴
	private Axis yAxis;
	// X轴纵向网格线
	private Grid xGrids;
	// Y轴横向网格线
	private Grid yGrids;
	// 图例
	private Legend legend;
	// 气泡信息框
	private Tip tip;
	// 数据集合
	private ScatterItem[] series;
	// 数据点样式
	private Points points;

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

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public ScatterItem[] getSeries() {
		return series;
	}

	public void setSeries(ScatterItem[] series) {
		this.series = series;
	}

	public Points getPoints() {
		return points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}

}
