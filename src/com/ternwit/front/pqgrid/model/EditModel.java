package com.ternwit.front.pqgrid.model;

import java.io.Serializable;

/**
 * 编辑模式
 */
public class EditModel implements Serializable {
	private static final long serialVersionUID = 5812775586816969724L;
	// 1鼠标单击2鼠标双击
	// default 1
	// java default 2
	private Integer clicksToEdit;
	// 对应按键的ASCII码
	// 如不设置，默认为TAB键
	// java default ENTER(13)
	private Integer saveKey;
	
	/**
	 * Default ClicksToEdit is single click<br>
	 * Default SaveKey is SaveKey.ENTER<br>
	 * */
	public EditModel() {
		super();
		this.clicksToEdit = 2;
		this.saveKey = SaveKey.ENTER.getSaveKey();
	}

	public EditModel(Integer clicksToEdit, Integer saveKey) {
		super();
		this.clicksToEdit = clicksToEdit;
		this.saveKey = saveKey;
	}
	
	public EditModel(Integer clicksToEdit, SaveKey saveKey) {
		this(clicksToEdit, saveKey.getSaveKey());
	}

	public Integer getClicksToEdit() {
		return clicksToEdit;
	}

	public void setClicksToEdit(Integer clicksToEdit) {
		this.clicksToEdit = clicksToEdit;
	}

	public Integer getSaveKey() {
		return saveKey;
	}

	public void setSaveKey(SaveKey saveKey) {
		this.saveKey = saveKey.getSaveKey();
	}

	public static enum SaveKey {
		ENTER(13);
		private Integer saveKey;

		SaveKey(Integer saveKey) {
			this.saveKey = saveKey;
		}

		public Integer getSaveKey() {
			return saveKey;
		}

	}
}
