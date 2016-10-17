/*
 * Copyright (c) 2016-2020 LEJR.COM All Right Reserved
 */

package com.krzn.publictools.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础数据访问接口。
 * 
 * @author yangzhishuo
 * @version 1.0 
 * @date 2016年3月15日
 */
public interface BaseDao<E> {

	/**
	 * 保存一个实体。
	 * 
	 * @param e
	 */
	public void save(E e);
	
	/**
	 * 更新一个实体。
	 * 
	 * @param e
	 */
	public void update(E e);
	
	/**
	 * 按照ID删除一个实体。
	 * 
	 * @param id
	 */
	public void deleteById(Serializable id);
	
	/**
	 * 按照ID获取一个实体。
	 * 
	 * @param id
	 * @return
	 * 		id对应的实体。
	 */
	public E getById(Serializable id);
	
	/**
	 * 查询数据列表。
	 * 
	 * @param params 参数列表。
	 * @return
	 * 		数据列表。
	 */
	public List<E> queryDataList(Map<String, Object> params);
	
	/**
	 * 查询数据数量。
	 * 
	 * @param params 参数列表。
	 * @return
	 * 		数据数量。
	 */
	public int queryDataCount(Map<String, Object> params);

}
