package com.krzn.publictools.util;

import java.security.MessageDigest;

/**
 * Document Start
 * MD5工具类
 * Document End
 * yangzhishuo
 * 2015年12月22日 下午3:22:16
 */
public class MD5Util {

	//安全前缀
	public static final String SECKEY_SUFFIX = "@pay2016!#![]";

	/**
	 * Document Start
	 * MD5 Hash计算
	 * Document End
	 * lining6@letv.com
	 * 乐视控股（北京）有限公司
	 * 2015年12月22日 下午3:26:01
	 * @param inputString 收入字符串
	 * @param charsetname 编码格式为空 用字符串默认编码
	 * @return
	 */
	public static String MD5Encode(String inputString, String charsetname) {
		String resultString = null;
		String tempString = SECKEY_SUFFIX + inputString;
		try {
			//获取MD5实例
			MessageDigest md = MessageDigest.getInstance("MD5");
			//编码后为二进制 为显示方便转换成十六进制
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(tempString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(tempString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	
	/**
	 * Document Start
	 * MD5 Hash计算
	 * Document End
	 * lining6@letv.com
	 * 乐视控股（北京）有限公司
	 * 2015年12月22日 下午3:26:01
	 * @param inputString 收入字符串
	 * @param charsetname 编码格式为空 用字符串默认编码
	 * @return
	 */
	public static String MD5Encode(String inputString){
		
		return  MD5Encode( inputString, "");
	}

	/**
	 * Document Start
	 * 转换成十六进制
	 * Document End
	 * lining6@letv.com
	 * 乐视控股（北京）有限公司
	 * 2015年12月22日 下午3:50:37
	 * @param b
	 * @return
	 */
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	/**
	 * Document Start
	 * 转换成十六进制
	 * Document End
	 * lining6@letv.com
	 * 乐视控股（北京）有限公司
	 * 2015年12月22日 下午3:51:00
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };
}
