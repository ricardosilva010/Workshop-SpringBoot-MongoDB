package com.example.course.services;

import com.example.course.domain.Post;
import com.example.course.repository.PostRepository;
import com.example.course.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService
{
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id)
    {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text)
    {
        return postRepository.searchTitle(text);
    }
}
