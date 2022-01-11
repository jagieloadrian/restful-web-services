package com.anjo.rest.webservices.restfulwebservices.posts;

import com.anjo.rest.webservices.restfulwebservices.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    private Date createDate;
    private String value;

    public Post(){}

    public Post(String value) {
        this.id = id;
        this.createDate = new Date();
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getValue() {
        return value;
    }
}
