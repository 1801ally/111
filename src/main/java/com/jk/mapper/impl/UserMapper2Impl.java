package com.jk.mapper.impl;

import com.jk.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserMapper2Impl {
    @Autowired
    private JdbcTemplate JdbcTemplate;
    //jdbcTempate查询
    @Transactional(readOnly = true)
    public List<User> getUserList(){
        String sql="select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

        return JdbcTemplate.query(sql,rowMapper);
    }

    public int addusers(User user){
        return JdbcTemplate.update("insert into user(id,name, url) values(?,?,?)",
             user.getId(),user.getName(),user.getUrl());
    }
    public int update(User user) {
        return JdbcTemplate.update("UPDATE  user SET NAME=? ,url=? WHERE id=?",
                user.getName(),user.getUrl(),user.getId());
    }
    public int deleteuser(Integer id) {
         return JdbcTemplate.update("DELETE FROM user WHERE id=?",id);
    }
}
