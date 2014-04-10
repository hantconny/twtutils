package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * 以此为例colors:[{"DEFAULT":"#000","HOVER":"#ccc"},{"DEFAULT":"#f00","HOVER":"#ccc"}],
 * 线一是黑色，线二是红色，点在鼠标悬停时是灰色
 * 有几组线就写几组
 * 会覆盖themeCls的样式
 * 
 * */
public class ColorItem implements Serializable {
	private static final long serialVersionUID = -8923929225974595712L;
	// Must be CAP
	private String DEFAULT;
	// Must be CAP
	private String HOVER;

	public String getDEFAULT() {
		return DEFAULT;
	}

	public void setDEFAULT(String dEFAULT) {
		DEFAULT = dEFAULT;
	}

	public String getHOVER() {
		return HOVER;
	}

	public void setHOVER(String hOVER) {
		HOVER = hOVER;
	}

}
