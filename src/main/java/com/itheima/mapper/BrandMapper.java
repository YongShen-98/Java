package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {


    List<Brand> selectAll();

    void add(Brand brand);

    void deleteById(@Param("id") Integer id);

    void deleteByIds(@Param("ids")int[] ids);


    List<Brand> selectByPage(@Param("begin")int begin,@Param("size") int size);

    int selectTotalCount();


    List<Brand> selectByPageAndCondition(@Param("begin")int begin,@Param("size") int size,@Param("brand") Brand brand);

    int selectTotalCountByCondition(Brand brand);


}
