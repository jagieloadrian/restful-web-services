package com.anjo.rest.webservices.restfulwebservices.posts;

import com.anjo.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class PostController {

    @Autowired
    private PostDaoService service;

    @GetMapping("users/{userId}/posts")
    public List<Post> retrieveAllPostsByUser(@PathVariable int userId) {
        return service.findAll(userId);
    }

    @PostMapping("users/{userId}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int userId, @RequestBody Post post){
        Post savedPost = service.save(userId, post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("users/{userId}/posts/{postId}")
    public EntityModel<Post> retrievePost(@PathVariable int userId, @PathVariable int postId){
        Post post = service.findOnePost(userId, postId);
        if(post == null){
            throw new UserNotFoundException(String.format("id %d not found", postId));
        }
        EntityModel<Post> model = EntityModel.of(post);
        WebMvcLinkBuilder linkToPosts =
                linkTo(methodOn(this.getClass()).retrieveAllPostsByUser(userId));
        model.add(linkToPosts.withRel("All-posts"));
       return model;
    }
}
