package com.wondersoft.ndlp.base.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;


/**
 * 
 * @Package:sy.dao
 * @Description:基础数据库操作类 其他DAO继承此类获取常用的数据库操作方法
 * @author:HZG
 * @Version：v1.0
 * @ChangeHistoryList：version     author         date              description 
 *                      v1.0        HZG    2014-5-5 下午3:16:23
 */
public interface IBaseDao {

	
	/**
	 * 保存一个对象
	 * 
	 * @param o
	 *            对象
	 * @return 对象的ID
	 */
	public Serializable save(Object o);
	
	
	
	
	

	/**
	 * 删除一个对象
	 * 
	 * @param o
	 *            对象
	 */
	public void delete(Object o);
	
	/**
	 * 更新一个对象
	 * 
	 * @param o
	 *            对象
	 */
	public void update(Object o);

	/**
	 * 保存或更新一个对象
	 * 
	 * @param o
	 *            对象
	 */
	public void saveOrUpdate(Object o);

	/**
	 * 通过主键获得对象
	 * 
	 * @param c
	 *            类名.class
	 * @param id
	 *            主键
	 * @return 对象
	 */
	public <T> T get(Class<T> c, Serializable id);

	/**
	 * 通过HQL语句获取一个对象
	 * 
	 * @param hql
	 *            HQL语句
	 * @return 对象
	 */
	public <T> T get(String hql);

	/**
	 * 通过HQL语句获取一个对象
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return 对象
	 */
	public <T> T get(String hql, Map<String, Object> params);

	/**
	 * 获得对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public <T> List<T> find(String hql);
	
 	/**
	 * 获得对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return List
	 */
	public <T> List<T> find(String hql, Map<String, Object> params);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return List
	 */
	public <T> List<T> find(String hql, int page, int rows);

	/**
	 * 获得分页后的对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return List
	 */
	public <T> List<T> find(String hql, Map<String, Object> params, int page, int rows);

	/**
	 * 统计数目
	 * 
	 * @param hql
	 *            HQL语句(select count(*) from T)
	 * @return long
	 */
	public Long count(String hql);

	/**
	 * 统计数目
	 * 
	 * @param hql
	 *            HQL语句(select count(*) from T where xx = :xx)
	 * @param params
	 *            参数
	 * @return long
	 */
	public Long count(String hql, Map<String, Object> params);

	/**
	 * 执行一条HQL语句
	 * 
	 * @param hql
	 *            HQL语句
	 * @return 响应结果数目
	 */
	public int executeHql(String hql);

	/**
	 * 执行一条HQL语句
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            参数
	 * @return 响应结果数目
	 */
	public int executeHql(String hql, Map<String, Object> params);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql, int page, int rows);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql, Map<String, Object> params);

	/**
	 * 获得结果集
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @param page
	 *            要显示第几页
	 * @param rows
	 *            每页显示多少条
	 * @return 结果集
	 */
	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows);

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 响应行数
	 */
	public int executeSql(String sql);

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 响应行数
	 */
	public int executeSql(String sql, Map<String, Object> params);

	/**
	 * 统计
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 数目
	 */
	public BigInteger countBySql(String sql);

	/**
	 * 统计
	 * 
	 * @param sql
	 *            SQL语句
	 * @param params
	 *            参数
	 * @return 数目
	 */
	public BigInteger countBySql(String sql, Map<String, Object> params);
	
	
	/**
	 * 删除多个对象
	 * 
	 * @param idString 1,2,3的形式
	 *            对象
	 */
	public int deleteByIds(String className,String idName,String idString);

	/**
	 * * @Description： * @param criteria
	/** * @Description： * @param skipResults
	/** * @Description： * @param maxResults
	/** * @Description： * @return * List<Object> * @author:songzhanliang * @Date :2014-5-13 上午9:57:43
	 */
	public List<Object> selectByCriteria(Criteria criteria, int skipResults,
			int maxResults);
	
	/**
	 * * @Description： * @param criteria
	/** * @Description： * @return * int * @author:songzhanliang * @Date :2014-5-13 上午9:58:29
	 */
	public int getCountByCriteria(Criteria criteria);
	
	
	@SuppressWarnings("all")
	public <T> List<T> findBySqlForEntity(String sql,Class<T> type,Map<String,Object> params) ;
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
	 * @param maxResult 最大记录数
	 * @return
	 * @author:HZG
	 * @Date :2014-7-6 上午9:03:58
	 */
	@SuppressWarnings("all")
	public <T> List<T> findByCriteria(final DetachedCriteria detachedCriteria, int maxResult) ;
}
