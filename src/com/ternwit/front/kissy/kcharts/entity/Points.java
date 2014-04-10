package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * ScatterChart数据点的样式(半径，颜色)
 * */
public class Points implements Serializable {
	private static final long serialVersionUID = -3814744353636491635L;
	// 无鼠标事件时的样式
	private Attr attr = new Attr();
	// 鼠标悬停时的样式
	private Attr hoverAttr = new Attr();

	public Attr getAttr() {
		return attr;
	}

	public void setAttr(Attr attr) {
		this.attr = attr;
	}

	public Attr getHoverAttr() {
		return hoverAttr;
	}

	public void setHoverAttr(Attr hoverAttr) {
		this.hoverAttr = hoverAttr;
	}

	public class Attr {
		// stroke { string } 笔触颜色 如:"#ccc"
		private String stroke;
		// r { number } 圆点半径
		private Double r;
		// fill { string } 填充色
		private String fill;

		// 无法在Java变量名中使用dash横线
		// private Double stroke-width;

		public String getStroke() {
			return stroke;
		}

		public void setStroke(String stroke) {
			this.stroke = stroke;
		}

		public Double getR() {
			return r;
		}

		public void setR(Double r) {
			this.r = r;
		}

		public String getFill() {
			return fill;
		}

		public void setFill(String fill) {
			this.fill = fill;
		}
	}
}
