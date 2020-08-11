package com.yilnz.javaexamples.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("")
    public String hello(){
        return "Hello, world";
    }

    @ResponseBody
    @RequestMapping("/del")
    @RequiresPermissions("user:del")
    public String del(){
        return "del";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //3.执行登录方法{
        try {
            subject.login(token);

            //登录成功
            //跳转到test.html
            return "成功";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在，UnknownAccountException是Shiro抛出的找不到用户异常
            return  "用户名不存在";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误，IncorrectCredentialsException是Shiro抛出的密码错误异常
            return "密码错误";
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(){
        return "/user/update";
    }

    @RequestMapping("/toLogin")
    @ResponseBody
    public String toLogin(){
        return "/toLogin";
    }

    @RequestMapping("/noAuth")
    @ResponseBody
    public String noAuth(){
        return "/noAuth";
    }
}
