package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    void add(Brand brand);

    void deleteById(Integer id);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);

}
