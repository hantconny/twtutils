package com.ternwit.front.pqgrid.grid;

import java.io.Serializable;

import com.ternwit.front.pqgrid.model.ColumnModel;
import com.ternwit.front.pqgrid.model.DataModel;
import com.ternwit.front.pqgrid.model.EditModel;
import com.ternwit.front.pqgrid.model.ScrollModel;
import com.ternwit.front.pqgrid.model.SelectionModel;

public class PQGrid implements Serializable {
	private static final long serialVersionUID = -590802291871314916L;
	// 宽度
	private Integer width;
	// 高度
	private Integer height;
	// 数据集合
	private DataModel dataModel;
	// 表头定义
	private ColumnModel[] colModel;
	// 自适应高度，不会显示垂直滚动条
	// 因为分页，所以一般单页数据不会太多
	private Boolean flexHeight = true;
	// 自适应宽度，但是仍然会显示水平滚动条
	// 如想隐藏水平滚动条，请设置ScrollModel
	private Boolean flexWidth = true;
	// 这个Grid允许缩放
	// 影响页面布局
	private Boolean resizable = false;
	// 允许排序
	private Boolean sortable = true;
	// 整个Grid允许拖拽
	private Boolean draggable = false;
	// Ctrl/Shift功能键
	private SelectionModel selectionModel;
	// 鼠标悬停时是悬停单元格还是整行
	private String hoverMode;
	// 指定前几列
	private Integer freezeCols;
	// 是否显示行号
	private Boolean numberCell = false;
	// 行号的宽度，仅当numberCell为true时有效
	private Integer numberCellWidth = 20;
	// Grid的标题，仅当topVisible为true时可见
	private String title;
	// 控制是否显示标题
	private Boolean topVisible;
	// 当文本过长时如何处理
	// true - 换行
	// false - 超出部分以……显示，拖拽可以显示全部
	private Boolean wrap = false;
	// 是否显示数据区域列的边框
	// default true
	private Boolean columnBorders;
	// 水平滚动条的滚动模式（隐藏/滚动速率）
	private ScrollModel scrollModel;
	// 每个单元格的编辑方式
	// 仅当ColumnModel的editable为true是生效
	private EditModel editModel;
	
	public PQGrid() {
		super();
		this.hoverMode = HoverMode.ROW.getHoverMode();
	}

	private PQGrid(String hoverMode) {
		super();
		this.hoverMode = hoverMode;
	}
	
	public PQGrid(HoverMode hoverMode) {
		this(hoverMode.getHoverMode());
	}

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

	public DataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public ColumnModel[] getColModel() {
		return colModel;
	}

	public void setColModel(ColumnModel[] colModel) {
		this.colModel = colModel;
	}

	public Boolean getFlexHeight() {
		return flexHeight;
	}

	public void setFlexHeight(Boolean flexHeight) {
		this.flexHeight = flexHeight;
	}

	public Boolean getFlexWidth() {
		return flexWidth;
	}

	public void setFlexWidth(Boolean flexWidth) {
		this.flexWidth = flexWidth;
	}

	public Boolean getResizable() {
		return resizable;
	}

	public void setResizable(Boolean resizable) {
		this.resizable = resizable;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public Boolean getDraggable() {
		return draggable;
	}

	public void setDraggable(Boolean draggable) {
		this.draggable = draggable;
	}

	public SelectionModel getSelectionModel() {
		return selectionModel;
	}

	public void setSelectionModel(SelectionModel selectionModel) {
		this.selectionModel = selectionModel;
	}

	public String getHoverMode() {
		return hoverMode;
	}

	// 设置HoverMode
	public void setHoverMode(HoverMode hoverMode) {
		this.hoverMode = hoverMode.getHoverMode();
	}

	public Integer getFreezeCols() {
		return freezeCols;
	}

	public void setFreezeCols(Integer freezeCols) {
		this.freezeCols = freezeCols;
	}

	public Boolean getNumberCell() {
		return numberCell;
	}

	public void setNumberCell(Boolean numberCell) {
		this.numberCell = numberCell;
	}

	public Integer getNumberCellWidth() {
		return numberCellWidth;
	}

	public void setNumberCellWidth(Integer numberCellWidth) {
		this.numberCellWidth = numberCellWidth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getTopVisible() {
		return topVisible;
	}

	public void setTopVisible(Boolean topVisible) {
		this.topVisible = topVisible;
	}

	public Boolean getWrap() {
		return wrap;
	}

	public void setWrap(Boolean wrap) {
		this.wrap = wrap;
	}

	public Boolean getColumnBorders() {
		return columnBorders;
	}

	public void setColumnBorders(Boolean columnBorders) {
		this.columnBorders = columnBorders;
	}

	public ScrollModel getScrollModel() {
		return scrollModel;
	}

	public void setScrollModel(ScrollModel scrollModel) {
		this.scrollModel = scrollModel;
	}

	public EditModel getEditModel() {
		return editModel;
	}

	public void setEditModel(EditModel editModel) {
		this.editModel = editModel;
	}

	public static enum HoverMode {
		CELL("cell"), ROW("row");
		private String hoverMode;

		HoverMode(String hoverMode) {
			this.hoverMode = hoverMode;
		}

		public String getHoverMode() {
			return hoverMode;
		}
	}
}
