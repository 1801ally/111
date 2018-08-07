package com.jk.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.jk.mapper.IUserMapper2;
import com.jk.mapper.IUserMapper3;
import com.jk.mapper.impl.UserMapper2Impl;
import com.jk.pojo.User;
import com.jk.pojo.project;
import com.jk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private IUserService userService;
    //注入jdbcTemplateDao层实现类
    @Autowired
    private UserMapper2Impl UserMapper2Impl;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IUserMapper3 IuserMapper3;


    @RequestMapping("queryuser")
    public String queryuser(){
        System.out.println("返回jsp页面成功");
        return  "show";
    }
    //springboot+jpa查询
    @RequestMapping("queryusers")
    @ResponseBody
    public List<User> queryusers(){
        List<User> list=userService.queryusers();
        IuserMapper3.saveAll(list);
            return list;
    }
    //springboot+jpa新增
    @RequestMapping("addusers")
    @ResponseBody
      public void addusers(){
       User u= new User();
       u.setId(5);
       u.setName("狗熊");
       u.setUrl("lalla");
        userService.addusers(u);
    }
    //springboot+jpa修改
    @RequestMapping("updateusers")
    @ResponseBody
    public void updateusers(){
        User u= new User();
        u.setId(17);
        u.setName("翔哥");
        u.setUrl("好久不见");
        userService.updateusers(u);

    }
    //springboot+jpa删除
    @RequestMapping("deleteusers")
    @ResponseBody
    public void deleteusers(){
        Integer  id=1;
        userService.deleteusers(id);

    }
    //jdbcTemplate查询
    @RequestMapping("queryjdbcTemplateuser")
    @ResponseBody
    public List<User>queryjdbcTemplateuser(){
       return UserMapper2Impl.getUserList();
    }
    //jdbcTemplate新增
    @RequestMapping("addjdbcTemplateuser")
    @ResponseBody
    public String addjdbcTemplateuser(){
         User user=new User();
         user.setId(20);
         user.setName("聚北");
         user.setUrl("lalalla");
       int t=UserMapper2Impl.addusers(user);
        if(t==1){
            return user.toString();
        }else {
            return "fail";
        }


    }
    //jdbcTemplate修改
    @RequestMapping("updatejdbcTemplate")
    @ResponseBody
    public String updatejdbcTemplate(){
        User user=new User();
        user.setName("刘小龙");
        user.setUrl("lalalla");
        user.setId(15);
        int f=UserMapper2Impl.update(user);
        if(f==1){
            return user.toString();
        }else {
            return "fail";
        }

    }
    //jdbcTemplate删除
    @RequestMapping("deletejdbcTemplate")
    @ResponseBody
    public  int deleteupdatejdbcTemplate(){
           Integer id=15;
        return UserMapper2Impl.deleteuser(id);
    }
   // FastJson查询


    @RequestMapping("queryproject")
    @ResponseBody
    @Cacheable(value="queryproject",key="'queryuser'")
    public List<project>queryproject(){
        List<project> list=userService.queryproject();

        return list;
    }



}
