package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * LineChart/BarChart用
 * 定义SeriesItem里面的键名
 * 因为还没有办法写成淘宝推荐的样子，所以就用x和y也能工作
 * 
 * */
public class DefineKey implements Serializable {
	private static final long serialVersionUID = -582818735566055353L;
	// X轴
	private String x;
	// Y轴
	private String y;

	public DefineKey(String x, String y) {
		super();
		this.x = x;
		this.y = y;
	}

	public DefineKey() {
		super();
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

}
