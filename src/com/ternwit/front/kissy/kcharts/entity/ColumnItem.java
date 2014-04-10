package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;
import java.util.Map;

public class ColumnItem implements Serializable {
	private static final long serialVersionUID = -12375570183184366L;
	// 标题
	private Title title = new Title();
	// 图表
	private Graph graph = new Graph();
	// 简介
	private Intro intro = new Intro();

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Intro getIntro() {
		return intro;
	}

	public void setIntro(Intro intro) {
		this.intro = intro;
	}

	public class Style {
		// 通用元素样式
		private Map<String, String> styles;

		public Map<String, String> getStyles() {
			return styles;
		}

		public void setStyles(Map<String, String> styles) {
			this.styles = styles;
		}
	}

	public class Title extends Style {
		// 标题文本
		private String text;
		// 标题HTML，使用未知
		private String html;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getHtml() {
			return html;
		}

		public void setHtml(String html) {
			this.html = html;
		}
	}

	public class Graph extends Style {
		// 真实数据比例，占条带的百分之多少
		private Integer per;

		public Integer getPer() {
			return per;
		}

		public void setPer(Integer per) {
			this.per = per;
		}
	}

	public class Intro extends Style {
		// 显示简介，如per为20，Intro.text为20%，Title.text为男女通吃
		private String text;
		// 简介HTML，使用未知
		private String html;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getHtml() {
			return html;
		}

		public void setHtml(String html) {
			this.html = html;
		}
	}
}
