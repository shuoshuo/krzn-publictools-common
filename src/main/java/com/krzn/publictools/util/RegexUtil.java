package com.krzn.publictools.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangzhishuo
 * 正则验证 工具类
 * date 2016-4-6
 */
public final class RegexUtil {

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static final boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	
	/**
	 * 判断一个字符串是否是正整数数字
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static final boolean isNumber(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("[0-9]+");
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

}
