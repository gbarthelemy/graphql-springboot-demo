package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Post;
import com.example.demo.repository.PostDao;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final PostDao postDao;
/*
    @SchemaMapping
    public List<Post> posts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }*/
}
