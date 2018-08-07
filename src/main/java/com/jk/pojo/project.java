package com.jk.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@SpringBootApplication
@Entity
@Table(name="project")
public class project implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String  name;
    private String  url;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date  projecttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getProjecttime() {
        return projecttime;
    }

    public void setProjecttime(Date projecttime) {
        this.projecttime = projecttime;
    }

    @Override
    public String toString() {
        return "project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", projecttime=" + projecttime +
                '}';
    }
}
