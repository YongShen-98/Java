package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();

        String jsonString = JSON.toJSONString(brands);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);

        response.getWriter().write("success");
    }


    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        brandService.deleteByIds(ids);

        response.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        System.out.println("id:"+ids);

        int id = ids[0];
        brandService.deleteById(id);

        response.getWriter().write("success");

    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        System.out.println("BrandServlet的current"+currentPage);
        System.out.println("BrandServlet的pageSize"+pageSize);
        System.out.println("BrandServlet的brand"+brand);

        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        System.out.println("pageBean:"+pageBean);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

}