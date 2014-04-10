package com.ternwit.front.pqgrid.model;

import java.io.Serializable;

/**
 * 单元格选择模式
 */
public class SelectionModel implements Serializable {
	private static final long serialVersionUID = -5527667565037656107L;
	// 鼠标点击选择时，是整行还是单个单元格
	private String type;
	// 按Ctrl和Shift键时如何选择
	// single禁用了功能键
	// block模仿了MS-Excel的Shift风格
	// range则不一样
	private String mode;

	/**
	 * Default Type is Type.CELL<br>
	 * Default Mode is Type.BLOCK
	 * */
	public SelectionModel() {
		super();
		this.type = Type.CELL.getType();
		this.mode = Mode.BLOCK.getMode();
	}

	public SelectionModel(String type, String mode) {
		super();
		this.type = type;
		this.mode = mode;
	}

	public SelectionModel(Type type, Mode mode) {
		this(type.getType(), mode.getMode());
	}

	public String getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type.getType();
	}

	public String getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode.getMode();
	}

	public static enum Type {
		ROW("row"), CELL("cell");

		private String type;

		Type(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	public static enum Mode {
		SINGLE("single"), RANGE("range"), BLOCK("block");

		private String mode;

		Mode(String mode) {
			this.mode = mode;
		}

		public String getMode() {
			return mode;
		}
	}
}
