package com.yilnz.javaexamples.shiro.service.impl;

import com.yilnz.javaexamples.shiro.domain.User;
import com.yilnz.javaexamples.shiro.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public User findByName(String name) {
        if(name.equals("admin")){
            User user = new User();
            user.setId(1);
            user.setName("admin");
            user.setPassword("admin");
            return user;
        }
        return null;
    }

    public User findById(Integer id) {
        if(new Integer(1).equals(id)){
            User user = new User();
            user.setId(1);
            user.setPermissions("user:add");
            user.setName("admin");
            return user;
        }
        return null;
    }
}
