package com.ternwit.front.kissy.kcharts.element;

/**
 * PieChart/LineChart/BarChart使用的气泡信息框
 * */
public class Tip extends ElementConfig {
	private static final long serialVersionUID = 6120865247963792398L;
	// 饼图使用属性，默认为true
	private Boolean boundryDetect = true;
	// Tip显示的模板-LineChart BarChart
	private String template;
	// Tip显示的模板-PieChart
	private String tpl;
	// 水平对齐方式 有"left" "center" "right"三种 默认 "left"
	private String alignX;
	// 水平对齐方式 有"top" "middle" "bottom"三种 默认 "top"
	private String alignY;
	// BarChart使用，气泡信息相对偏移
	private Offset offset = new Offset();

	public Boolean getBoundryDetect() {
		return boundryDetect;
	}

	public void setBoundryDetect(Boolean boundryDetect) {
		this.boundryDetect = boundryDetect;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public String getAlignX() {
		return alignX;
	}

	public void setAlignX(AlignX alignX) {
		this.alignX = alignX.getAlignX();
	}

	public String getAlignY() {
		return alignY;
	}

	public void setAlignY(AlignY alignY) {
		this.alignY = alignY.getAlignY();
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}

	// 可选配置
	public class Offset {
		private Integer x;
		private Integer y;

		public Integer getX() {
			return x;
		}

		public void setX(Integer x) {
			this.x = x;
		}

		public Integer getY() {
			return y;
		}

		public void setY(Integer y) {
			this.y = y;
		}
	}

	public static enum AlignX {
		LEFT("left"), CENTER("center"), RIGHT("right");
		private String alignX;

		AlignX(String alignX) {
			this.alignX = alignX;
		}

		public String getAlignX() {
			return alignX;
		}

	}

	public static enum AlignY {
		TOP("top"), MIDDLE("middle"), BOTTOM("bottom");
		private String alignY;

		AlignY(String alignY) {
			this.alignY = alignY;
		}

		public String getAlignY() {
			return alignY;
		}

	}
}
