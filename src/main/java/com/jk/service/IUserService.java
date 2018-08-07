package com.jk.service;

import com.jk.pojo.User;
import com.jk.pojo.project;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {

    List<User> queryusers();

    void addusers(User u);

    void updateusers(User u);

    void deleteusers(Integer id);

    List<project> queryproject();
}
