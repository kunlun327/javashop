package com.iggek.shop.dao;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.iggek.shop.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao extends BaseDao<Category>{
    //查询所有商品类别
    public List<Category> selectAllCategory() throws SQLException {
        String sql="select * from category";
        List<Category> categoryList = this.getBeanList(Category.class, sql, null);
        return       categoryList;

    }
    //通过类别编号获取类别名称

}
