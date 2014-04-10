package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * PieChart每个饼向外拖的线的颜色
 *
 */
public class LabelLine implements Serializable {
	private static final long serialVersionUID = -946291990454665295L;
	private Attr attr = new Attr();

	public Attr getAttr() {
		return attr;
	}

	public void setAttr(Attr attr) {
		this.attr = attr;
	}

	public class Attr {
		// stroke : "#0f0"
		// stroke : "red"
		private String stroke;

		public String getStroke() {
			return stroke;
		}

		public void setStroke(String stroke) {
			this.stroke = stroke;
		}
		
	}
}
