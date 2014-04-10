package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

/**
 * BarChart/LineChart/PieChart使用的动画
 * 和Tip的动画属性不一样
 * Tip暂时没有Anim属性
 *
 */
// easing:"easeOut",duration:1000
// default easeIn
// duration is ms
// PieChart会用type:'sector',
// easing:'bounceOut',
// duration:1000
// duration的单位和Tip的属性Anim不一样
public class Anim implements Serializable {
	private static final long serialVersionUID = 1157053252327438773L;
	// PieChart: sector
	private String type;
	// PieChart: bounceOut
	// LineChart/BarChart: default easeIn
	private String easing;
	// duration:1000
	private Long duration;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEasing() {
		return easing;
	}

	public void setEasing(String easing) {
		this.easing = easing;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

}
