package com.example.demo.repository;

import com.example.demo.model.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostDao {

    private final List<Post> posts;

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream()
                .skip(offset)
                .limit(count)
                .toList();
    }

    public List<Post> getAuthorPosts(String author) {
        return posts.stream()
                .filter(post -> author.equals(post.getAuthorId()))
                .toList();
    }

    public void savePost(Post post) {
        posts.add(post);
    }
}
