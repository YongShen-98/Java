package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {
    User select(String username, String password);
    void add(User user);
}
