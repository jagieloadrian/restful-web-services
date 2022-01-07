package com.anjo.rest.webservices.restfulwebservices.user;

import com.anjo.rest.webservices.restfulwebservices.posts.Post;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    private Date birthDate;

    private List<Post> posts;

    User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.posts = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
