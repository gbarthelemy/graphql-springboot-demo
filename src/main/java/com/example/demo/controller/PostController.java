package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Post;
import com.example.demo.repository.AuthorDao;
import com.example.demo.repository.PostDao;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostDao postDao;
    private final AuthorDao authorDao;

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postDao.getRecentPosts(count, offset);
    }

    @SchemaMapping
    public Author author(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @SchemaMapping(typeName = "Post", field = "first_author")
    public Author getFirstAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String text,
                           @Argument String category, @Argument String authorId) {
        var post = new Post(
                UUID.randomUUID().toString(),
                title,
                text,
                category,
                authorId
        );

        postDao.savePost(post);

        return post;
    }
}
