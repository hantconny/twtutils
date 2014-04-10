package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * LineChart/BarChart的数据集合
 *
 */
public class SeriesItem implements Serializable {
	private static final long serialVersionUID = -5360301535251085910L;
	// 数据
	private DefineKey[] data;
	// 如果显示Legend，会作为图例文字显示
	private String text;

	public DefineKey[] getData() {
		return data;
	}

	public void setData(DefineKey[] data) {
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
