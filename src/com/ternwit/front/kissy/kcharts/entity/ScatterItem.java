package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ScatterChart的数据集合+样式
 * 
 * */
public class ScatterItem implements Serializable {
	private static final long serialVersionUID = 7935882551419691134L;
	private String name;
	// String color = "rgba(223, 83, 83, .5)";
	private String color;
	private List<Double[]> data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Double[]> getData() {
		return data;
	}

	public void setData(List<Double[]> data) {
		this.data = data;
	}

}