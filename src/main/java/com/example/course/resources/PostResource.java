package com.example.course.resources;

import com.example.course.domain.Post;
import com.example.course.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource
{
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id)
    {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
