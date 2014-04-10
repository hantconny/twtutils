package com.ternwit.front.kissy.kcharts.element.axis;

/**
 * X轴
 *
 */
public class XAxis extends Axis {
	private static final long serialVersionUID = 5713158931420224650L;
	// X轴的每个轴文本
	private String[] text;
//	// X轴的横线是否显示
//	// 不是X轴的文字
//	// 对于X轴几乎看不出来，显示的时候灰度会高一点
//	// 已抽取到ElementConfig中
//	private Boolean isShow;

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}

}
