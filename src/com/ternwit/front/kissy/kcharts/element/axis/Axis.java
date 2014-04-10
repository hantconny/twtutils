package com.ternwit.front.kissy.kcharts.element.axis;

import com.ternwit.front.kissy.kcharts.element.ElementConfig;

public abstract class Axis extends ElementConfig {
	private static final long serialVersionUID = -1149649971151062061L;
	// Y轴有几个间隔
	private Integer num;
	// Y轴最小值
	private Integer min;
	// Y轴最大值
	private Integer max;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
}
