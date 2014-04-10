package com.ternwit.front.kissy.kcharts.entity;

import java.io.Serializable;

public class RatioStyle implements Serializable {
	private static final long serialVersionUID = 1763667411127717528L;
	private ContainerStyle containerStyles = new ContainerStyle();
	private ItemStyle itemStyles = new ItemStyle();
	private TitleStyle titleStyles = new TitleStyle();
	private BackStyle backStyles = new BackStyle();
	private FrontStyle frontStyles = new FrontStyle();
	private IntroStyle introStyles = new IntroStyle();

	public ContainerStyle getContainerStyles() {
		return containerStyles;
	}

	public void setContainerStyles(ContainerStyle containerStyles) {
		this.containerStyles = containerStyles;
	}

	public ItemStyle getItemStyles() {
		return itemStyles;
	}

	public void setItemStyles(ItemStyle itemStyles) {
		this.itemStyles = itemStyles;
	}

	public TitleStyle getTitleStyles() {
		return titleStyles;
	}

	public void setTitleStyles(TitleStyle titleStyles) {
		this.titleStyles = titleStyles;
	}

	public BackStyle getBackStyles() {
		return backStyles;
	}

	public void setBackStyles(BackStyle backStyles) {
		this.backStyles = backStyles;
	}

	public FrontStyle getFrontStyles() {
		return frontStyles;
	}

	public void setFrontStyles(FrontStyle frontStyles) {
		this.frontStyles = frontStyles;
	}

	public IntroStyle getIntroStyles() {
		return introStyles;
	}

	public void setIntroStyles(IntroStyle introStyles) {
		this.introStyles = introStyles;
	}

	/* Inner Classes Below */

	public class Style {
		private Integer width;
		private Integer height;

		public Integer getWidth() {
			return width;
		}

		public void setWidth(Integer width) {
			this.width = width;
		}

		public Integer getHeight() {
			return height;
		}

		public void setHeight(Integer height) {
			this.height = height;
		}
	}

	public class ContainerStyle extends Style {
		private Integer paddingTop;

		public Integer getPaddingTop() {
			return paddingTop;
		}

		public void setPaddingTop(Integer paddingTop) {
			this.paddingTop = paddingTop;
		}
	}

	public class ItemStyle extends Style {
		private Integer marginBottom;

		public Integer getMarginBottom() {
			return marginBottom;
		}

		public void setMarginBottom(Integer marginBottom) {
			this.marginBottom = marginBottom;
		}
	}

	public class TitleStyle extends Style {
		private Integer fontSize;

		public Integer getFontSize() {
			return fontSize;
		}

		public void setFontSize(Integer fontSize) {
			this.fontSize = fontSize;
		}
	}

	public class BackStyle extends Style {
		private String background;

		public String getBackground() {
			return background;
		}

		public void setBackground(String background) {
			this.background = background;
		}
	}

	public class FrontStyle extends Style {
		private String background;

		public String getBackground() {
			return background;
		}

		public void setBackground(String background) {
			this.background = background;
		}
	}

	public class IntroStyle extends Style {
		private Integer fontSize;
		private String color;

		public Integer getFontSize() {
			return fontSize;
		}

		public void setFontSize(Integer fontSize) {
			this.fontSize = fontSize;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
}
