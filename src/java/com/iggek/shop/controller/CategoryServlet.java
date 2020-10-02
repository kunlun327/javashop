package com.iggek.shop.controller;

import com.google.gson.Gson;
import com.iggek.shop.entity.Category;
import com.iggek.shop.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryService();

    //查询所有商品类别
    public void viewAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据
        List<Category> categoryList = service.viewAllCategory();
        //通过json数据传递商品类别的集合
        Gson gson = new Gson();
        String json = gson.toJson(categoryList);

        //传递至header.jsp页面显示
        response.getWriter().write(json);
    }

}