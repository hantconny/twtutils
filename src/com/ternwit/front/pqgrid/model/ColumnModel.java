package com.ternwit.front.pqgrid.model;

import java.io.Serializable;

/**
 * 表头定义
 */
public class ColumnModel implements Serializable {
	private static final long serialVersionUID = 8255431533961332489L;
	// 表头文本
	private String title;
	// 表头宽度
	private Integer width;
	// 表头数据类型
	private String dataType;
	// 表头是否居中
	private String align;
	// 数据内容是否允许编辑
	private Boolean editable;
	// 是否隐藏该列
	private Boolean hidden;

	/**
	 * Default editable is false<br>
	 * Default hidden is false<br>
	 * */
	public ColumnModel() {
		super();
		this.editable = false;
		this.hidden = false;
	}

	public ColumnModel(String title, Integer width, String dataType,
			String align, Boolean editable, Boolean hidden) {
		super();
		this.title = title;
		this.width = width;
		this.dataType = dataType;
		this.align = align;
		this.editable = editable;
		this.hidden = hidden;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(Align align) {
		this.align = align.getAlign();
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public static enum Align {
		LEFT("left"), CENTER("center"), RIGHT("right");

		private String align;

		Align(String align) {
			this.align = align;
		}

		public String getAlign() {
			return align;
		}

	}
}
