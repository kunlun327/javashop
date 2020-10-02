package com.iggek.shop.service;

import com.iggek.shop.dao.CategoryDao;
import com.iggek.shop.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDao dao =new CategoryDao();
    //查询所有商品类别
    public List<Category> viewAllCategory()
    {
        List<Category> categoryList=null;
        try {
            categoryList = dao.selectAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  categoryList;
    }
}
