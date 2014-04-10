package jofc2.model.elements;

/*
 * This class will solve hollow dot style in line chart
 * sides, width, colour and type are tested
 * 
 * */
public class DotStyle {
	private String type;
	private String colour;
	private Float alpha;
	private Integer rotation;
	private Integer sides;
	private Integer width;

	public DotStyle() {
		this(Style.NORMAL);
	}

	public DotStyle(Style style) {
		this(style.getStyle());
	}

	public DotStyle(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Float getAlpha() {
		return alpha;
	}

	public void setAlpha(Float alpha) {
		this.alpha = alpha;
	}

	public Integer getRotation() {
		return rotation;
	}

	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}

	public Integer getSides() {
		return sides;
	}

	public void setSides(Integer sides) {
		this.sides = sides;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static enum Style {
		STAR("star"), BOW("bow"), ANCHOR("anchor"), NORMAL("dot"), SOLID_DOT(
				"solid-dot"), HOLLOW_DOT("hollow-dot");

		private String style;

		Style(String style) {
			this.style = style;
		}

		public String getStyle() {
			return style;
		}
	}
}
