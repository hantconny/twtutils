package com.ternwit.misc;
//package com.ternwit.common;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//import com.ternwit.coffer.dto.YearMonthDto;
//
public class LineChartUtil {
//
//	// 生成图表主对象JFreeChart
//	public static JFreeChart createChart(DefaultCategoryDataset linedataset, YearMonthDto ymDto) {
//		// 定义图表对象
//		JFreeChart chart = ChartFactory.createLineChart(
//				ymDto.getYear() + "-" + ymDto.getMonth() + "Statistics", // chart title
//				"Date", // domain axis label
//				"Sum", // range axis label
//				linedataset, // data
//				PlotOrientation.VERTICAL, // orientation
//				true, // include legend
//				true, // tooltips
//				false // urls
//				);
//		CategoryPlot plot = chart.getCategoryPlot();
//		// customise the range axis...
//		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//		rangeAxis.setAutoRangeIncludesZero(true);
//		rangeAxis.setUpperMargin(0.20);
//		rangeAxis.setLabelAngle(Math.PI / 2.0);
//
//		return chart;
//	}
//
//	// 生成数据
//	public static DefaultCategoryDataset createDataset(List<Object[]> list) {
//		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
//
//		/* 折线图例 */
//		String series1 = "Money";
//
//		/* 
//		 * object[0] 代表每日消费金额总和
//		 * object[1] 代表日期, 1988-12-12
//		 *  */
//		for (Object[] objects : list) {
//			linedataset.addValue(Double.parseDouble(objects[0].toString()), series1, objects[1].toString());
//		}
//
//		return linedataset;
//	}
//	
//	// 写图片
//	public static String createJPG(JFreeChart jfreechart, YearMonthDto ymDto) {
//		String path = new LineChartUtil().getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//		int endIndex = 0;
//		if ((endIndex = path.indexOf("WEB-INF/")) > 0) {
//			path = path.substring(0, endIndex) + "img/" + ymDto.getYear() + "-" + ymDto.getMonth() + ".jpg";
//		}
//		try {
//			FileOutputStream fos_jpg = null;
//			fos_jpg = new FileOutputStream(path);
//			ChartUtilities.writeChartAsJPEG(fos_jpg, 1, jfreechart, 2500, 768, null);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return path;
//	}
//	
}
