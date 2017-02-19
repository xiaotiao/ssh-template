package com.wondersoft.ndlp.base.service.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersoft.ndlp.base.dao.IBaseDao;
import com.wondersoft.ndlp.base.service.IBaseService;

@Service("baseService")
public class BaseServiceImpl implements IBaseService {

    @Autowired
    private IBaseDao baseDao;
    Logger logger = Logger.getLogger(BaseServiceImpl.class);

    @Override
    public Serializable save(Object o) {
        if (o != null) {
            return baseDao.save(o);
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
     * 
     * @author:HZG
     * @Date :2014-7-5 下午3:20:08
     */
    @Override
    public <T> T get(Class<T> c, Serializable id) {
        return (T) baseDao.get(c, id);
    }

    @Override
    public <T> T get(String hql) {
        return baseDao.get(hql);
    }

    @Override
    public <T> T get(String hql, Map<String, Object> params) {
        return baseDao.get(hql, params);
    }

    @Override
    public void delete(Object o) {
        if (o != null) {
            baseDao.delete(o);
        }
    }

    @Override
    public void update(Object o) {
        if (o != null) {
            baseDao.update(o);
        }
    }

    @Override
    public void saveOrUpdate(Object o) {
        if (o != null) {
            baseDao.saveOrUpdate(o);
        }
    }

    @Override
    public <T> List<T> find(String hql) {
        return baseDao.find(hql);
    }

    @Override
    public <T> List<T> find(String hql, Map<String, Object> params) {
        return baseDao.find(hql, params);
    }

    @Override
    public <T> List<T> find(String hql, Map<String, Object> params, int page,
            int rows) {
        return baseDao.find(hql, params, page, rows);
    }

    @Override
    public <T> List<T> find(String hql, int page, int rows) {
        return baseDao.find(hql, page, rows);
    }

    @Override
    public Long count(String hql) {
        return baseDao.count(hql);
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        return baseDao.count(hql, params);
    }

    @Override
    public int executeHql(String hql) {
        return baseDao.executeHql(hql);
    }

    @Override
    public int executeHql(String hql, Map<String, Object> params) {
        return baseDao.executeHql(hql, params);
    }

    @Override
    public List<Object[]> findBySql(String sql) {
        return baseDao.findBySql(sql);
    }

    @Override
    public List<Object[]> findBySql(String sql, int page, int rows) {
        return baseDao.findBySql(sql, page, rows);
    }

    @Override
    public List<Object[]> findBySql(String sql, Map<String, Object> params) {
        return baseDao.findBySql(sql, params);
    }

    @Override
    public List<Object[]> findBySql(String sql, Map<String, Object> params,
            int page, int rows) {
        return baseDao.findBySql(sql, params, page, rows);
    }

    @Override
    public int executeSql(String sql) {
        return baseDao.executeSql(sql);
    }

    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        return baseDao.executeSql(sql, params);
    }

    @Override
    public BigInteger countBySql(String sql) {
        return baseDao.countBySql(sql);
    }

    @Override
    public BigInteger countBySql(String sql, Map<String, Object> params) {
        return baseDao.countBySql(sql, params);
    }

    /**
     * * @Description： * @param criteria /** * @Description： * @param
     * skipResults /** * @Description： * @param maxResults /** * @Description： * @return
     * * @author:songzhanliang * @Date :2014-5-13 上午10:52:34
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List selectByCriteria(Criteria criteria, int skipResults,
            int maxResults) {
        return baseDao.selectByCriteria(criteria, skipResults, maxResults);
    }

    /**
     * * @Description： * @param criteria /** * @Description： * @return *
     * @author:songzhanliang * @Date :2014-5-13 上午10:52:34
     */
    @Override
    public int getCountByCriteria(Criteria criteria) {
        return baseDao.getCountByCriteria(criteria);
    }

    /**
     * * @Description： * @param className /** * @Description： * @param idName
     * /** * @Description： * @param idString /** * @Description： * @return *
     * @author:songzhanliang * @Date :2014-5-13 上午11:31:34
     */
    @Override
    public int deleteByIds(String className, String idName, String idString) {
        return baseDao.deleteByIds(className, idName, idString);
    }

    @SuppressWarnings("all")
    public <T> List<T> findBySqlForEntity(String sql, Class<T> type,
            Map<String, Object> params) {

        return this.baseDao.findBySqlForEntity(sql, type, params);
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
        return this.baseDao.findByCriteria(detachedCriteria);
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
    @SuppressWarnings("all")
    public <T> List<T> findByCriteria(final DetachedCriteria detachedCriteria,
            int maxResult) {
        return this.baseDao.findByCriteria(detachedCriteria, maxResult);
    }

    public void checkSaveAndUpdate(List<Object> objects, Object object,
            IBaseService ibaseservice) {

    }

    /**
     * 下发之前对库中是否有文件进行判断无文件提示先上传文件在下发
     * 
     */
    public int checkContentForSend(String type) {

        String hql = "from " + type + " Where 1=1";
        List<Object> list = baseDao.find(hql);
        if (list != null && !list.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

}
