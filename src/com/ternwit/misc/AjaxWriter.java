package com.ternwit.misc;

//import java.io.IOException;
//import java.io.PrintWriter;

//import org.apache.log4j.Logger;
//import org.apache.struts2.ServletActionContext;

public class AjaxWriter {
	/**
	 * @author Cai
	 * @param response
	 * @param logger
	 */
//	public static void ajaxWriteResponse(String response, Logger logger) {
//		/* need to be used at J2EE environment */
//		try {
//			/* 
//			 * get HttpServletResponse get PrintWriter
//			 */
//			PrintWriter writer = ServletActionContext.getResponse().getWriter();
//			/*
//			 * write response
//			 */
//			writer.write(response);
//			/*
//			 * flush buffer
//			 */
//			writer.flush();
//			/*
//			 * close PrinterWriter
//			 */
//			writer.close();
//		} catch (IOException e) {
//			/*
//			 * if exception occur, log error message
//			 */
//			logger.error("write response error");
//			/*
//			 * error handling
//			 */
//			e.printStackTrace();
//		}
//	}
}
