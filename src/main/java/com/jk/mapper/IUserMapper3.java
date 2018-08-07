package com.jk.mapper;

import com.jk.pojo.User;
import com.jk.pojo.project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IUserMapper3  extends MongoRepository<User,Serializable> {
}
