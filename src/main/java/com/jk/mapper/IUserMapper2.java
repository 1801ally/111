package com.jk.mapper;

import com.jk.pojo.User;
import com.jk.pojo.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


public interface IUserMapper2 extends JpaRepository<project, Serializable> {


}
