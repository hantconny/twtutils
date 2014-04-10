package com.ternwit.front.kissy.kcharts.chart;

import com.ternwit.front.kissy.kcharts.element.Tip;
import com.ternwit.front.kissy.kcharts.entity.ColorItem;
import com.ternwit.front.kissy.kcharts.entity.DataItem;
import com.ternwit.front.kissy.kcharts.entity.LabelLine;

public class PieChart extends KCharts {
	private static final long serialVersionUID = -6639734035392468816L;
	// // 放置kchart的元素ID
	// // div的id为demo，那么renderTo的值为#demo
	// private String renderTo;
	// 圆心X轴坐标
	private Integer cx;
	// 圆心Y轴坐标
	private Integer cy;
	// 半径
	private Double R;
	// 如果是空心圆，空心圆半径
	private Double r;

	// 数据集合
	private DataItem[] data;
	// 自定义颜色
	private ColorItem[] colors;
	// 标签是否在原内部-无拖线
	private Boolean labelIndside;
	// // 动画
	// private Anim anim;

	// 气泡提示
	private Tip tip;
	// 拖线
	private LabelLine labelline;

	public Integer getCx() {
		return cx;
	}

	public void setCx(Integer cx) {
		this.cx = cx;
	}

	public Integer getCy() {
		return cy;
	}

	public void setCy(Integer cy) {
		this.cy = cy;
	}

	public Double getR() {
		return R;
	}

	public void setR(Double r) {
		R = r;
	}

	public Double getr() {
		return r;
	}

	public void setr(Double r) {
		this.r = r;
	}

	public DataItem[] getData() {
		return data;
	}

	public void setData(DataItem[] data) {
		this.data = data;
	}

	public ColorItem[] getColors() {
		return colors;
	}

	public void setColors(ColorItem[] colors) {
		this.colors = colors;
	}

	public Boolean getLabelIndside() {
		return labelIndside;
	}

	public void setLabelIndside(Boolean labelIndside) {
		this.labelIndside = labelIndside;
	}

	public Tip getTip() {
		return tip;
	}

	public void setTip(Tip tip) {
		this.tip = tip;
	}

	public LabelLine getLabelline() {
		return labelline;
	}

	public void setLabelline(LabelLine labelline) {
		this.labelline = labelline;
	}

}
