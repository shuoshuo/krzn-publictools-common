package com.krzn.publictools.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.beans.BeanCopier;

/**
 * Bean值拷贝工具类，将BeanCopier做成静态类，方便拷贝.
 *
 * @ClassName BeanCopierUtils
 * @author yangzhishuo
 * @date 2014年8月18日 下午3:38:34
 * @version V1.0
 *
 */
public class BeanCopierUtils {

	public static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

	/**
	 * 利用BeanCopier拷贝类属性
	 * 
	 * @Title: copyProperties
	 * @param source
	 *            拷贝源
	 * @param target
	 *            拷贝目标
	 */
	public static void copyProperties(Object source, Object target) {
		if (source == null || target == null) {
			return;
		}
		String beanKey = generateKey(source.getClass(), target.getClass());
		BeanCopier copier = null;
		if (!beanCopierMap.containsKey(beanKey)) {
			copier = BeanCopier.create(source.getClass(), target.getClass(), false);
			// 将结果放入静态map中作为缓存保存，
			beanCopierMap.put(beanKey, copier);
		} else {
			copier = beanCopierMap.get(beanKey);
		}
		copier.copy(source, target, null);
	}

	/**
	 * 以两个类的toString作为map的key
	 */
	private static String generateKey(Class<?> class1, Class<?> class2) {
		return class1.toString() + class2.toString();
	}

}
