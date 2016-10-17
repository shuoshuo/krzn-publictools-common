/* **************************************************************
 *
 * 文件名称：StringUtil.java
 *
 * 包含类名：
 * 
 * 创建日期：2015-12-27
 * 创建作者：杜建君
 * 版权声明：Copyright 2015 乐视控股。
 *
 * **************************************************************/
package com.krzn.publictools.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;

import org.slf4j.Logger;

/**
 * 字符串Util类。
 * <p>
 * 字符串通用处理
 * </p>
 * 
 * 创建日期：2015-12-27 创建作者：杜建君
 */
public final class StringUtil {

	private static final String SPLITSTR = ",";

	/**
	 * 验证为空（不对入参去空格处理，" " 也表示有字符）
	 * 
	 * @param str
	 * @return true 空；false 非空
	 */
	public static final boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 验证非空（不对入参去空格处理，" " 也表示有字符）
	 * 
	 * @param str
	 * @return true 非空；false 空
	 */
	public static final boolean isNotEmpty(String str) {
		if (str != null && str.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 验证为空（会对入参去空格处理）
	 * 
	 * @param str
	 * @return true 空；false 非空
	 */
	public static final boolean isBlank(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 验证非空（会对入参去空格处理）
	 * 
	 * @param str
	 * @return true 非空；false 空
	 */
	public static final boolean isNotBlank(String str) {
		if (str != null && str.trim().length() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 字符串是否是小数或者数字
	 * 
	 * @param str
	 * @return
	 */
	public static final boolean isDecimal(String str) {
		if (isBlank(str)) {
			return false;
		}
		if (str.matches("[0-9]+\\.?[0-9]*")) {
			return true;
		}
		return false;
	}
	/**
	 * 字符串是否是纯数字
	 * 
	 * @param c
	 * @return true 数字； false 非数字
	 */
	public static final boolean isNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		char c;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 字符串为非纯数字
	 * 
	 * @param c
	 * @return true 非数字； false 数字
	 */
	public static boolean isNotNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		char c;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			if (c < '0' || c > '9') {
				return true;
			}
		}
		return false;
	}

	/**
	 * 字符是否是数字
	 * 
	 * @param c
	 * @return true 数字； false 非数字
	 */
	public static boolean isNumber(char c) {
		if (c < '0' || c > '9') {
			return false;
		}
		return true;
	}

	/**
	 * 将首字符转换为大写
	 * 
	 * @param str
	 * @return
	 */
	public static final String initcap(String str) {
		if (isBlank(str)) {
			return null;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * 输出异常的完整信息
	 * 
	 * @param e
	 *            异常
	 * @return 异常堆栈信息
	 */
	public static final String getTrace(Throwable e) {
		StringWriter stringWriter = null;
		try {
			stringWriter = new StringWriter();
			PrintWriter writer = new PrintWriter(stringWriter);
			e.printStackTrace(writer);
			StringBuffer buffer = stringWriter.getBuffer();
			return buffer.toString();
		} finally {
			if (stringWriter != null) {
				try {
					stringWriter.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 对数字四舍五入保留两位小数
	 * 
	 * @param 金额
	 * @return 处理后的数值
	 */
	public static final Double setAmountFormat(Double amount) {
		if (amount == null || amount == 0 || amount < 0) {
			return 0.00;
		}
		String result = "";

		DecimalFormat df = new DecimalFormat("###############0.00");
		result = df.format(amount);
		return Double.parseDouble(result);
	}

	/**
	 * 验证多个参数非空
	 * 
	 * @param str
	 * @param logger
	 * @param objs
	 * @return 示例 boolean check =
	 *         StringUtil.isBlank4mulField("userId,pwd,confirmPwd", logger,
	 *         userId, pwd, confirmPwd);
	 */

	public static final boolean isBlank4mulField(String str, Logger logger, String... objs) {

		String[] fieldArray = str.split(SPLITSTR);

		if (fieldArray.length != objs.length) {
			logger.error("组件配置错误");
			return false;
		}

		for (int i = 0; i < objs.length; i++) {

			if (StringUtil.isBlank(objs[i])) {
				logger.info("error::" + fieldArray[i] + " is blank!");

				return false;
			}

		}

		return true;

	}

	/**
	 * 验证多个参数非空
	 * 
	 * @param str
	 * @param 密码脱敏
	 */

	public static final String hideRealPwd4Log(String pwd) {

		if (StringUtil.isNotBlank(pwd)) {
			return "******";
		}

		return pwd;
	}
	
	/**
	 * 数字转字符串前面自动补0的实现
	 */
	public static String fillZero(String value, int length) {
	    // 0 代表前面补充0     
	    // 18 代表长度为18     
	    // d 代表参数为正数型     
		// String.format("%018d", value);
//	    String str = String.format("%0"+ length +"s", value);
		
		if (value.length() >= length) {
			return value;
		}
		
		length = length - value.length();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append("0");
		}
		builder.append(value);
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(fillZero("1", 3));
	}

}
