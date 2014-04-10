package com.ternwit.front.pqgrid.model;

import java.io.Serializable;
import java.util.List;

/**
 * 数据集合
 */
public class DataModel implements Serializable {
	private static final long serialVersionUID = 2157373158237260434L;
	private List<String[]> data;

	public List<String[]> getData() {
		return data;
	}

	public void setData(List<String[]> data) {
		this.data = data;
	}

}
