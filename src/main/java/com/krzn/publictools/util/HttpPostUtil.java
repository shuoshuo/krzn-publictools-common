package com.krzn.publictools.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.krzn.publictools.data.Code;
import com.krzn.publictools.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * HttpPost工具类
 * yangzhishuo
 * 2015年03月28日 下午2:14:10
 */
public class HttpPostUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpPostUtil.class);
	/**
	 * Document Start
	 * POST调用
	 * Document End
	 * dujianjun
	 * 乐视控股（北京）有限公司
	 * 2016年3月23日 下午2:15:41
	 * @param httpUrl
	 * @param params
	 * @return
	 */
	public static String callHttpPOST(String httpUrl, Map<String, String> params) {
		return callHttpPOST(httpUrl, params, null);
	}

	/**
	 * Document Start
	 * POST调用
	 * Document End
	 * dujianjun
	 * 乐视控股（北京）有限公司
	 * 2016年3月23日 下午2:15:41
	 * @param httpUrl
	 * @param params
	 * @param encod
	 * @return
	 */
	public static String callHttpPOST(String httpUrl, Map<String, String> params, String encod) {
		String strReturn = "";
		try {
			if (StringUtil.isEmpty(encod)) {
				encod = "UTF-8";
			}
			URL url = new URL(httpUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setRequestMethod("POST");
			String paramsStr = createLinkString(params);
			logger.info("send message url:" + httpUrl + "?" + paramsStr);
			if (!StringUtil.isEmpty(paramsStr)) {
				conn.setDoOutput(true);
				OutputStream out = conn.getOutputStream();

				out.write(paramsStr.getBytes(encod));
				out.flush();
				out.close();
			}

			InputStream ins2 = conn.getInputStream();
			strReturn = convertStreamToString(ins2, encod);
			ins2.close();
		} catch (Exception e) {
			logger.error("call HTTPAPI faile URL=" + httpUrl + "  params=" + createLinkString(params)
					+ "  faile case=" + e.getMessage(), e);
		}

		return strReturn;
	}
	
	
	/**
	 * 包装将接口返回值包装为map
	 * 作者：dujianjun
	 * date:2016年3月28日 下午5:43:25
	 * @param httpUrl
	 * @param params
	 * @return
	 * @throws BizException 
	 */
	public static HashMap<String,Object> callHttpPOSTForMap(String httpUrl, Map<String, String> params) throws BizException {
		String strReturn = HttpPostUtil.callHttpPOST(httpUrl, params);
		if(StringUtil.isBlank(strReturn)){
			throw new BizException(Code.RESULTSETISNULL.getValue(), "返回结果集为空");
		}
		HashMap<String, Object> map = (HashMap<String, Object>) JsonUtils.readValue(strReturn);
        return map;
    }
	
	

	/**
	 * Document Start
	 * Stream转换成String
	 * dujianjun
	 * 乐视控股（北京）有限公司
	 * 2016年3月23日 下午2:15:41
	 * @param ins
	 * @param encod
	 * @return
	 */
	private static String convertStreamToString(InputStream ins, String encod) {
		String strRet = "";
		try {
			StringBuffer sbuf = new StringBuffer();
			InputStreamReader reader = new InputStreamReader(ins, encod);
			Reader buf = new BufferedReader(reader);
			int ch;
			while ((ch = buf.read()) > -1) {
				sbuf.append((char) ch);
			}
			buf.close();
			strRet = sbuf.toString();
			sbuf.delete(0, sbuf.length());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "";
		}
		return strRet;
	}

	/**
	 * Document Start
	 * 将Map类型参数使用&字符进行链接
	 * 并且参数按照a~z进行排序
	 * dujianjun
	 * 乐视控股（北京）有限公司
	 * 2016年3月23日 下午2:15:41
	 * @param params
	 * @return
	 */
	public static String createLinkString(Map<String, String> params) {
		String prestr = null;
		if (params == null || params.size() <= 0) {
			return prestr;
		}
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}
	
	
	
	

}
