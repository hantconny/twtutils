package com.ternwit.front.kissy.kcharts.chart;

import java.io.Serializable;

import com.ternwit.front.kissy.kcharts.entity.ColumnItem;
import com.ternwit.front.kissy.kcharts.entity.RatioStyle;

/**
 * RatioChart不继承KCharts
 * 因为和LineChart/BarChart/PieChart/ScatterChart无共同点
 *
 */
public class RatioChart implements Serializable {
	private static final long serialVersionUID = -1091274539897538828L;
	// 与LineChart/BarChart/PieChart/ScatterPie的renderTo一样
	private String container;
	// type 为1(比例条)/2(小人图)
	private Integer type;
	// ratio图的样式
	private RatioStyle styles;
	// 数据集合
	private ColumnItem[] cols;

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type.getType();
	}

	public RatioStyle getStyles() {
		return styles;
	}

	public void setStyles(RatioStyle styles) {
		this.styles = styles;
	}

	public ColumnItem[] getCols() {
		return cols;
	}

	public void setCols(ColumnItem[] cols) {
		this.cols = cols;
	}
	
	public static enum Type {
		BAR(1), MAN(2);
		
		private Integer type;

		private Type(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return type;
		}
		
	}
}
