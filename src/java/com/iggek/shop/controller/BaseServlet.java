package com.iggek.shop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methodName = request.getParameter("method");

        Class<? extends BaseServlet> clazz = this.getClass();

        try {
            //获得匹配的方法对象   第一个参数：方法名  第二个参数和第三个参数：调用的方法所需要的参数列表
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //执行  第一个参数：目标对象   第二个参数和第三个参数：请求和响应对象
            method.invoke(this,request,response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
