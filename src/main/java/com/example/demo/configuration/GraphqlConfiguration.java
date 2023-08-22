package com.example.demo.configuration;

import com.example.demo.model.Author;
import com.example.demo.model.Post;
import com.example.demo.repository.AuthorDao;
import com.example.demo.repository.PostDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                posts.add(
                        new Post(
                                "Post" + postId + authorId ,
                                "Post " + postId + ":" + authorId,
                                "Post category",
                                "Post " + postId + " + by author " + authorId,
                                "Author" + authorId
                        ));
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            authors.add(
                    new Author(
                            "Author" + authorId,
                            "Author " + authorId,
                            "http://example.com/authors/" + authorId
                    ));
        }
        return new AuthorDao(authors);
    }
}
