package com.ternwit.front.kissy.kcharts.chart;

import java.io.Serializable;

import com.ternwit.front.kissy.kcharts.element.Title;
import com.ternwit.front.kissy.kcharts.entity.Anim;

/**
 * 抽取几类图表共同的属性
 * 
 */
public abstract class KCharts implements Serializable {
	private static final long serialVersionUID = -3461078064191990834L;
	// 放置kchart的元素ID
	// div的id为demo，那么renderTo的值为#demo
	private String renderTo;
	private String lineType;
	private String themeCls;

	// 主标题
	private Title title;
	// 副标题
	private Title subTitle;
	// 动画
	private Anim anim;

	public String getRenderTo() {
		return renderTo;
	}

	public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}

	public String getLineType() {
		return lineType;
	}

	public void setLineType(LineType lineType) {
		this.lineType = lineType.getLineType();
	}

	public String getThemeCls() {
		return themeCls;
	}

	public void setThemeCls(ThemeCls themeCls) {
		this.themeCls = themeCls.getThemeCls();
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Title getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(Title subTitle) {
		this.subTitle = subTitle;
	}

	public Anim getAnim() {
		return anim;
	}

	public void setAnim(Anim anim) {
		this.anim = anim;
	}

	public static enum LineType {
		STRAIGHT("straight"), ARC("arc");

		private String lineType;

		LineType(String lineType) {
			this.lineType = lineType;
		}

		public String getLineType() {
			return lineType;
		}

	}

	public static enum ThemeCls {
		DEFAULT("ks-chart-default"), ANALYTIKS("ks-chart-analytiks"), RAINBOW(
				"ks-chart-rainbow");

		private String themeCls;

		ThemeCls(String themeCls) {
			this.themeCls = themeCls;
		}

		public String getThemeCls() {
			return themeCls;
		}

	}
}
