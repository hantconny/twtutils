package com.ternwit.front.kissy.kcharts.test;

import com.google.gson.GsonBuilder;
import com.ternwit.front.kissy.kcharts.chart.PieChart;
import com.ternwit.front.kissy.kcharts.chart.KCharts.ThemeCls;
import com.ternwit.front.kissy.kcharts.element.Tip;
import com.ternwit.front.kissy.kcharts.entity.Anim;
import com.ternwit.front.kissy.kcharts.entity.DataItem;
import com.ternwit.front.kissy.kcharts.entity.LabelLine;

public class RunPieChart {

	public static void main(String[] args) {
		PieChart pieChart = new PieChart();
		
		pieChart.setThemeCls(ThemeCls.DEFAULT);
		
		pieChart.setRenderTo("#demo1");
		pieChart.setCx(150);
		pieChart.setCy(150);
		pieChart.setR(100.0);
		pieChart.setr(60.0);
		
		DataItem[] items = new DataItem[3];
		items[0] = new DataItem(20, "20%", "per");
		items[1] = new DataItem(30, "30%", "percen");
		items[2] = new DataItem(50, "50%", "percent");
		pieChart.setData(items);
		
		pieChart.setLabelIndside(false);
		
		Anim anim = new Anim();
		anim.setType("sector");
		anim.setEasing("bounceOut");
		anim.setDuration(new Long(1000));
		pieChart.setAnim(anim);
		
		Tip tip = new Tip();
		tip.setBoundryDetect(true);
		tip.setTpl("{{tip}} {{percent*100+'%'}}");
		pieChart.setTip(tip);
		
		LabelLine labelLine = new LabelLine();
		LabelLine.Attr attr = labelLine.new Attr();
		attr.setStroke("#0f0");
		labelLine.setAttr(attr);
		pieChart.setLabelline(labelLine);
		
		String str = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(pieChart);
		System.out.println(str);
		
	}

}
