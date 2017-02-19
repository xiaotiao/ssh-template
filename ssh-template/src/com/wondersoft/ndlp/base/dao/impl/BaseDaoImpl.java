package com.wondersoft.ndlp.base.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.wondersoft.ndlp.base.dao.IBaseDao;


/**
 * 
 * @Package:sy.dao.impl
 * @Description:
 * @author:HZG @Version：v1.0
 * @ChangeHistoryList：version author date description v1.0 HZG 2014-5-5
 *                            下午3:15:19
 */
// @Scope("prototype")
@Repository("baseDao")
public class BaseDaoImpl implements IBaseDao {
	Logger logger = Logger.getLogger(BaseDaoImpl.class);

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(Object o) {
		if (o != null) {
			return this.getCurrentSession().save(o);
		}
		return null;
	}

	/**
	 * 
	 * @Description： 查询单个对象 支持延迟加载，不存在返回null
	 * 
	 * @param c
	 * @param id
	 * @return
	 * @author:HZG
	 * @Date :2014-7-5 下午3:20:08
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public void delete(Object o) {
		if (o != null) {
			this.getCurrentSession().delete(o);
		}
	}

	@Override
	public void update(Object o) {
		if (o != null) {
			this.getCurrentSession().update(o);
		}
	}

	@Override
	public void saveOrUpdate(Object o) {
		if (o != null) {
			this.getCurrentSession().saveOrUpdate(o);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySql(String sql, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public int executeSql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	/**
	 * 
	 * @Description：批量更新
	 * @param sql
	 * @param params
	 * @return 执行成功的条数
	 * @author:HZG
	 * @Date :2014-7-5 下午3:35:10
	 */
	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return q.executeUpdate();
	}

	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}

	


	/**
	 * 
	 * @param paraMap
	 * @param anyWhere
	 *            是否模糊查询 true 模糊查询
	 * @param className
	 * @return @
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Criteria getCriteria(Map<String, Object> paraMap, boolean anyWhere, Class className) {
		Criteria cra = this.getCurrentSession().createCriteria(className);
		if (paraMap == null) {

			return cra;
		}
		Iterator<?> it = paraMap.entrySet().iterator();
		if (anyWhere == false) {
			while (it.hasNext()) {

				Map.Entry<String, Object> m = (Map.Entry<String, Object>) it.next();
				cra.add(Restrictions.eq(m.getKey(), m.getValue()));

			}
		} else {
			while (it.hasNext()) {

				Map.Entry<String, Object> m = (Map.Entry<String, Object>) it.next();
				// hzg add
				if (m.getValue() instanceof String) {

					cra.add(Restrictions.like(m.getKey(), "%" + m.getValue() + "%"));
				} else {
					cra.add(Restrictions.eq(m.getKey(), m.getValue()));
				}

			}

		}
		return cra;

	}

	/**
	 * 
	 * @param paraMap
	 * @param anyWhere
	 *            是否模糊查询 true 模糊查询
	 * @param className
	 * @return @
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Criteria getCriteria(Map<String, Object> paraMap, Map<Object, String> orParaMap, boolean anyWhere,
			Class className) {
		Criteria cra = this.getCurrentSession().createCriteria(className);
		if (paraMap == null) {

			return cra;
		}
		Iterator<?> it = paraMap.entrySet().iterator();
		if (anyWhere == false) {
			while (it.hasNext()) {

				Map.Entry<String, Object> m = (Map.Entry<String, Object>) it.next();
				cra.add(Restrictions.eq(m.getKey(), m.getValue()));

			}
		} else {
			while (it.hasNext()) {

				Map.Entry<String, Object> m = (Map.Entry<String, Object>) it.next();
				if (m.getValue() instanceof String) {

					cra.add(Restrictions.like(m.getKey(), "%" + m.getValue() + "%"));
				} else {
					cra.add(Restrictions.eq(m.getKey(), m.getValue()));
				}

			}

		}
		if (orParaMap != null) {

			Iterator<?> orIt = orParaMap.entrySet().iterator();

			Map.Entry<Object, String> m1 = (Map.Entry<Object, String>) orIt.next();
			Map.Entry<Object, String> m2 = (Map.Entry<Object, String>) orIt.next();
			cra.add(Restrictions.or(Restrictions.eq(m1.getValue(), m1.getKey()),
					Restrictions.eq(m2.getValue(), m2.getKey())));

		}

		return cra;

	}

	/**
	 * 
	 * @param paraMap
	 * @param anyWhere
	 *            是否模糊查询 true 模糊查询
	 * @param className
	 * @return @
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Criteria getCriteria(Map<String, Object> paraMap, Map<Object, String> orParaMap[], boolean anyWhere,
			Class className) {
		Criteria cra = this.getCurrentSession().createCriteria(className);
		if (paraMap == null) {

			return cra;
		}
		Iterator<?> it = paraMap.entrySet().iterator();
		if (anyWhere == false) {
			while (it.hasNext()) {

				Map.Entry<String, Object> m = (Map.Entry<String, Object>) it.next();
				cra.add(Restrictions.eq(m.getKey(), m.getValue()));

			}
		} else {
			while (it.hasNext()) {

				Map.Entry<String, Object> m = (Map.Entry<String, Object>) it.next();

				if (m.getValue() instanceof String) {

					cra.add(Restrictions.like(m.getKey(), "%" + m.getValue() + "%"));
				} else {
					cra.add(Restrictions.eq(m.getKey(), m.getValue()));
				}

			}

		}
		if (orParaMap != null && orParaMap.length > 0) {
			for (int i = 0; i < orParaMap.length; i++) {
				Iterator<?> orIt = orParaMap[i].entrySet().iterator();
				if (anyWhere == false) {

					Map.Entry<Object, String> m1 = (Map.Entry<Object, String>) orIt.next();
					Map.Entry<Object, String> m2 = (Map.Entry<Object, String>) orIt.next();
					cra.add(Restrictions.or(Restrictions.eq(m1.getValue(), m1.getKey()),
							Restrictions.eq(m2.getValue(), m2.getKey())));
				}
			}
		}
		return cra;
	}


	@Override
	public int deleteByIds(String className, String idName, String idString) {
		Query query = this.getCurrentSession()
				.createQuery("delete " + className + " model where model." + idName + " in (" + idString + ")");
		int deletedEntities = query.executeUpdate();
		return deletedEntities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> selectByCriteria(Criteria criteria, int skipResults, int maxResults) {
		criteria.setProjection(null);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		criteria.setFirstResult(skipResults);
		criteria.setMaxResults(maxResults);
		List<Object> list = criteria.list();
		return list;
	}

	@Override
	public int getCountByCriteria(Criteria criteria) {
		int totalSize = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();// 投影
		return totalSize;
	}

	/**
	 * 
	 * @Description：执行查询远程sql
	 * @param sql
	 * @param type
	 * @param params
	 * @return 未查到，返回list空结果集，注意不是null
	 * 
	 * @author:HZG
	 * @Date :2014-7-6 上午12:16:48
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findBySqlForEntity(String sql, Class<T> type, Map<String, Object> params) {

		Query q = this.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(type));
		// Query q =
		// this.getCurrentSession().createSQLQuery(sql).addEntity(type);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof Collection<?>) {
					q.setParameterList(key, (Collection<?>) obj);
				} else if (obj instanceof Object[]) {
					q.setParameterList(key, (Object[]) obj);
				} else {
					q.setParameter(key, obj);
				}
			}
		}
		return (List<T>) q.list();
	}

	/**
	 * 
	 * @Description：离线查询,完全对象操作
	 * @param detachedCriteria
	 * @return
	 * @author:HZG
	 * @Date :2014-7-6 上午9:08:49
	 */
	public <T> List<T> findByCriteria(final DetachedCriteria detachedCriteria) {
		return findByCriteria(detachedCriteria, Integer.MAX_VALUE);
	}

	/**
	 * 
	 * @Description：离线查询
	 * @param detachedCriteria
	 * @param maxResult
	 * @return
	 * @author:HZG
	 * @Date :2014-7-6 上午9:03:58
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findByCriteria(final DetachedCriteria detachedCriteria, int maxResult) {
		Criteria criteria = detachedCriteria.getExecutableCriteria(this.getCurrentSession());
		criteria.setMaxResults(maxResult);
		return criteria.list();
	}

}
