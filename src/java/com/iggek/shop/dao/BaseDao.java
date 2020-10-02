package com.iggek.shop.dao;

import com.iggek.shop.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 基本的CRUD
 */
public class BaseDao<T> {

    private QueryRunner runner = new QueryRunner();

    //增删改
    public int update(String sql,Object...params) throws SQLException {
        int i = runner.update(DataSourceUtils.getConnection(), sql, params);
        return i;
    }

    //查询单个值
    public Object getSingleValue(String sql,Object...params) throws SQLException {
        Object query = runner.query(DataSourceUtils.getConnection(), sql, new ScalarHandler(), params);
        return query;
    }

    //查询同类型的列表
    public List<T> getBeanList(Class<T> type , String sql,Object...params) throws SQLException {
        List<T> list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<>(type), params);
        return list;
    }

    //查询单个对象
    public T getBean(Class<T> type , String sql , Object...params) throws SQLException {
        T t = runner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<>(type), params);
        return t;
    }

    //查询不同类型的列表
    public List<Map<String, Object>> getMap(String sql , Object...params) throws SQLException {
        List<Map<String, Object>> mapList = runner.query(DataSourceUtils.getConnection(), sql, new MapListHandler(), params);
        return mapList;
    }
}
