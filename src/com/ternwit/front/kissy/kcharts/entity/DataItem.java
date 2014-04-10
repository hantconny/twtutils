package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * PieChart的数据集合
 * 类似LineChart/BarChart的Series
 *
 */
public class DataItem implements Serializable {
	private static final long serialVersionUID = -5517101005143420901L;
	// 20 数据值，占一个园的多少
	private Integer data;
	// "20%" 显示，无所谓写什么
	private String label;
	// "per" Tip用
	private String tip;

	public DataItem() {
		super();
	}
	
	public DataItem(Integer data, String label, String tip) {
		super();
		this.data = data;
		this.label = label;
		this.tip = tip;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}
