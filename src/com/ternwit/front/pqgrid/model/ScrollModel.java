package com.ternwit.front.pqgrid.model;

import java.io.Serializable;

/**
 * 水平滚动条显示/滚动速率
 */
public class ScrollModel implements Serializable {
	private static final long serialVersionUID = 6613719185045898077L;
	// 是否显示水平滚动条
	// default true
	private Boolean horizontal;
	// consistent - 拖拽释放后重绘
	// optimum - 拖拽暂停时重绘
	// fast - 即时重绘
	// default fast
	private String pace;

	/**
	 * Default Pace is Pace.FAST<br>
	 * */
	public ScrollModel() {
		super();
		this.pace = Pace.FAST.getPace();
	}
	
	public ScrollModel(Boolean horizontal, String pace) {
		super();
		this.horizontal = horizontal;
		this.pace = pace;
	}
	
	public ScrollModel(Boolean horizontal, Pace pace) {
		this(horizontal, pace.getPace());
	}

	public Boolean getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(Boolean horizontal) {
		this.horizontal = horizontal;
	}

	public String getPace() {
		return pace;
	}

	public void setPace(Pace pace) {
		this.pace = pace.getPace();
	}

	public static enum Pace {
		CONSISTENT("consistent"), OPTIMUM("optimum"), FAST("fast");
		private String pace;

		Pace(String pace) {
			this.pace = pace;
		}

		public String getPace() {
			return pace;
		}

	}
}
