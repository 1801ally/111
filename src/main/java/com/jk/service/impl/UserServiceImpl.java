package com.jk.service.impl;

import com.jk.mapper.IUserMapper;
import com.jk.mapper.IUserMapper2;
import com.jk.pojo.User;
import com.jk.pojo.project;
import com.jk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.metamodel.ListAttribute;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
 private IUserMapper userMapper;
    @Autowired
    private IUserMapper2 userMapper2;

    @Override
    public List<User> queryusers() {
        List<User> list=userMapper.findAll();
        return list;
    }

    @Override
    public void addusers(User u) {
        userMapper.save(u);
    }

    @Override
    public void updateusers(User u) {
        userMapper.save(u);
    }

    @Override
    public void deleteusers(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<project> queryproject() {
        List<project>projectlist=userMapper2.findAll();
        return projectlist;
    }
}
