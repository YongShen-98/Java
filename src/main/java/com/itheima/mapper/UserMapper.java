package com.itheima.mapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

    User select(@Param("username") String username,@Param("password") String password);

    void add(User user);

}
