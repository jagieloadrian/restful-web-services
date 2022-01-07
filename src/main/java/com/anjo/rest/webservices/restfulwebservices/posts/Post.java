package com.anjo.rest.webservices.restfulwebservices.posts;

import java.util.Date;

public class Post {
    private Integer id;
    private Integer userId;
    private Date createDate;
    private String value;

    public Post(int id, int userId, String value) {
        this.id = id;
        this.userId = userId;
        this.createDate = new Date();
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getValue() {
        return value;
    }
}
