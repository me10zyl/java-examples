package com.yilnz.javaexamples.shiro.service;

import com.yilnz.javaexamples.shiro.domain.User;

public interface UserService {

    public User findByName(String name);

    public User findById(Integer id);
}