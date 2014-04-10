package jofc2.model.elements;

import java.util.Arrays;
import java.util.List;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.util.DotConverter;

/*
 * add DotStyle dotStyle, solve hollow dot style issue in line chart
 * */
public class LineChart extends Element {

	private static final long serialVersionUID = 8807130855547088579L;
	private static transient final Integer DEFAULT_FONTSIZE = 10;
	private Integer width;
	@Alias("dot-size")
	private Integer dotSize;
	@Alias("halo-size")
	private Integer haloSize;
	private String colour;
	private String axis;
	// my work
	@Alias("dot-style")
	private DotStyle dotStyle;
	
	// my work
	public DotStyle getDotStyle() {
		return dotStyle;
	}
	// my work
	public void setDotStyle(DotStyle dotStyle) {
		this.dotStyle = dotStyle;
	}

	public String getYaxis() {
		return axis;
	}

	public void setYAxis(String yAxis) {
		this.axis = yAxis;
	}

	/**
	 * Tells the LineChart to Use the right YAxis
	 */
	public void setRightYAxis(){
		setYAxis("right");
	}

	public LineChart() {
		this(Style.NORMAL);
	}

	public LineChart(Style style) {
		this(style.getStyle());
	}

	protected LineChart(String type) {
		super(type);
		setFontSize(DEFAULT_FONTSIZE);
	}

	public Integer getWidth() {
		return width;
	}

	public LineChart setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getDotSize() {
		return dotSize;
	}

	public LineChart setDotSize(Integer dotSize) {
		this.dotSize = dotSize;
		return this;
	}

	public String getColour() {
		return colour;
	}

	public LineChart setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public LineChart addValues(Number... values) {
		return addValues(Arrays.asList(values));
	}

	public LineChart addValues(List<Number> values) {
		// We convert all Numbers to Dots except Null Values they are Converted to a Null Element
		// as Dots with the value null are interpreted as Zero from OFC and null Values themself are interpolated
		for (Number number : values) {
			if (number == null) {
				getValues().add(new NullElement());
			} else {
				getValues().add(number);
			}
		}
		return this;
	}

	public LineChart addDots(Dot... dots) {
		return addDots(Arrays.asList(dots));
	}

	public LineChart addDots(List<Dot> dots) {
		getValues().addAll(dots);
		return this;
	}

	public Integer getHaloSize() {
		return haloSize;
	}

	public LineChart setHaloSize(Integer haloSize) {
		this.haloSize = haloSize;
		return this;
	}

	@Converter(DotConverter.class)
	public static class Dot {

		@Alias("halo-size")
		private Integer haloSize;
		@Alias("dot-size")
		private Integer dotSize;
		private Number value;
		private String colour;

		public Dot(Number value) {
			this(value, null, null, null);
		}

		public Dot(Number value, String colour) {
			this(value, colour, null, null);
		}

		public Dot(Number value, String colour, Integer dotSize, Integer haloSize) {
			setValue(value);
			setColour(colour);
			setDotSize(dotSize);
			setHaloSize(haloSize);
		}

		public Integer getHaloSize() {
			return haloSize;
		}

		public Dot setHaloSize(Integer haloSize) {
			this.haloSize = haloSize;
			return this;
		}

		public Integer getDotSize() {
			return dotSize;
		}

		public Dot setDotSize(Integer dotSize) {
			this.dotSize = dotSize;
			return this;
		}

		public Number getValue() {
			return value;
		}

		public Dot setValue(Number value) {
			this.value = value;
			return this;
		}

		public String getColour() {
			return colour;
		}

		public Dot setColour(String colour) {
			this.colour = colour;
			return this;
		}
	}

	public static enum Style {
		NORMAL("line");

		private String style;

		Style(String style) {
			this.style = style;
		}

		public String getStyle() {
			return style;
		}
	}
	
}
