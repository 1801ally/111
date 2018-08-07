package com.jk.mapper;

import com.jk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface IUserMapper extends JpaRepository<User, Serializable> {
}
