package com.wondersoft.ndlp.base.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;

public interface IBaseService {
	public Serializable save(Object o);
	public <T> T get(Class<T> c, Serializable id);
	public <T> T get(String hql);
	public <T> T get(String hql, Map<String, Object> params);
	public void delete(Object o);
	public void update(Object o);
	public void saveOrUpdate(Object o);
	public <T> List<T> find(String hql);
	public <T> List<T> find(String hql, Map<String, Object> params);
	public <T> List<T> find(String hql, Map<String, Object> params, int page, int rows);
	public <T> List<T> find(String hql, int page, int rows);
	public Long count(String hql);
	public Long count(String hql, Map<String, Object> params);
	public int executeHql(String hql);
	public int executeHql(String hql, Map<String, Object> params);
	public List<Object[]> findBySql(String sql);
	public List<Object[]> findBySql(String sql, int page, int rows);
	public List<Object[]> findBySql(String sql, Map<String, Object> params);
	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page,
			int rows);
	public int executeSql(String sql);
	public int executeSql(String sql, Map<String, Object> params);
	public BigInteger countBySql(String sql);
	public BigInteger countBySql(String sql, Map<String, Object> params);
	/**
	 * 
	 * @param object 目前只支持一级二级结构 列 mainBean.property or mainBean.subBean.property
	 * @param pagesize
	 * @param currentPage
	 * @param orderMap
	 *            key 排序列 value desc 倒序 asc 正序
	 * @return
	 * @ 
	 * 
	 */

	public int deleteByIds(String className,String idName,String idString);
	@SuppressWarnings("rawtypes")
	public  List selectByCriteria(Criteria  criteria, int skipResults, int maxResults) ;
	public int getCountByCriteria(Criteria  criteria) ;
	@SuppressWarnings("all")
	public <T> List<T> findBySqlForEntity(String sql,Class<T> type,Map<String,Object> params)  ;
	/**
	 * 
	 * @Description：离线查询,完全对象操作
	 * @param detachedCriteria
	 * @return
	 * @author:HZG
	 * @Date :2014-7-6 上午9:08:49
	 */
	public <T> List<T> findByCriteria(final DetachedCriteria detachedCriteria) ;
	/**
	 * 
	 * @Description：离线查询
	 * @param detachedCriteria 
	 * @param maxResult
	 * @return
	 * @author:HZG
	 * @Date :2014-7-6 上午9:03:58
	 */
	@SuppressWarnings("all")
	public <T> List<T> findByCriteria(final DetachedCriteria detachedCriteria, int maxResult) ;
	
	
	/**
	 * @Description 查询数据库中是否有数据
	 * @param type 参数为实体对象的字符串；
	 * @return 查询到结果就返回1,反之返回结果为0;
	 */
    public int checkContentForSend(String type);
	
	
	
}
