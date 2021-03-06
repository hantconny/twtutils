package jofc2.model.elements;

import java.util.Arrays;
import java.util.List;

import jofc2.model.metadata.Alias;
import jofc2.model.metadata.Converter;
import jofc2.util.BarConverter;

/*
 * Add Style Enum to fix JOFC2 bar chart style bug
 * */
public class BarChart extends Element {

	private static final long serialVersionUID = 6695611795831460343L;
	private String colour;

	public BarChart() {
		this(Style.NORMAL);
	}

	public BarChart(Style style) {
		super(style.getStyle());
	}

	protected BarChart(String style) {
		super(style);
	}

	public BarChart addValues(Number... values) {
		return addValues(Arrays.asList(values));
	}

	public BarChart addValues(List<Number> values) {
		for (Number number : values) {
			if (number!=null){
			this.addBars(new Bar(number));
			}
		}
		return this;
	}

	public BarChart addBars(Bar... bars) {
		return addBars(Arrays.asList(bars));

	}

	public BarChart addBars(List<Bar> bars) {
		getValues().addAll(bars);
		return this;
	}

	public String getColour() {
		return colour;
	}

	public BarChart setColour(String colour) {
		this.colour = colour;
		return this;
	}

	public static enum Style {
		NORMAL("bar"),
		THREED("bar_3d"),
		GLASS("bar_glass"),
		SKETCH("bar_sketch"),
		CYLINDER("bar_cylinder"),
		CYLINDER_OUTLINE("bar_cylinder_outline"),
		DOME("bar_dome"),
		ROUND("bar_round"),
		ROUND_GLASS("bar_round_glass"),
		ROUND3D("bar_round3d"),
		FILLED("bar_filled"),
		PLASTIC("bar_plastic"),
		PLASTIC_FLAT("bar_plastic_flat");

		private String style;

		Style(String style) {
			this.style = style;
		}

		public String getStyle() {
			return style;
		}
	}

	@Converter(BarConverter.class)
	public static class Bar {

		private Number top;
		private Number bottom;
		private String colour;
		@Alias("tip")
		private String tooltip;

		public Bar(Number top, Number bottom, String colour) {
			setTop(top);
			setBottom(bottom);
			setColour(colour);
		}

		public Bar(Number top, Number bottom) {
			this(top, bottom, null);
		}

		public Bar(Number top, String colour) {
			this(top, null, colour);
		}

		public Bar(Number top) {
			this(top, null, null);
		}

		public Number getTop() {
			return top;
		}

		public Bar setTop(Number top) {
			this.top = top;
			return this;
		}

		public Number getBottom() {
			return bottom;
		}

		public Bar setBottom(Number bottom) {
			this.bottom = bottom;
			return this;
		}

		public String getColour() {
			return colour;
		}

		public Bar setColour(String colour) {
			this.colour = colour;
			return this;
		}

		public String getTooltip() {
			return tooltip;
		}

		public Bar setTooltip(String tooltip) {
			this.tooltip = tooltip;
			return this;
		}
	}
}
