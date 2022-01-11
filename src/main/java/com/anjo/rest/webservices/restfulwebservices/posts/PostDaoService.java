package com.anjo.rest.webservices.restfulwebservices.posts;

import com.anjo.rest.webservices.restfulwebservices.user.User;
import com.anjo.rest.webservices.restfulwebservices.user.UserDaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PostDaoService {

    private UserDaoService service;

    PostDaoService(UserDaoService service) {
        this.service = service;
    }

    public List<Post> findAll(int userId) {
        return service.findOne(userId).getPosts();
    }

    public Post save(int userId, Post post) {
        User user = service.findOne(userId);
        post.setId(user.getPosts().size());
        //post.setUser(userId);
        user.addPost(post);
        return post;
    }

    public Post findOnePost(int userId, int postId) {
        User user = service.findOne(userId);
        for (Post post : user.getPosts()) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }
}

