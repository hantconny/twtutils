package com.ternwit.front.kissy.kcharts.element;

import java.io.Serializable;
import java.util.Map;

/**
 * Legend/Title/Tip共有属性
 * css
 * isShow控制是否显示
 *
 */
public abstract class ElementConfig implements Serializable {
	private static final long serialVersionUID = -1669568209174743866L;
	private Map<String, String> css;
	private Boolean isShow = true;

	public Map<String, String> getCss() {
		return css;
	}

	public void setCss(Map<String, String> css) {
		this.css = css;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}
}
