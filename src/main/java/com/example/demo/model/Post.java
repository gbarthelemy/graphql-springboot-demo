package com.example.demo.model;

import lombok.Value;

@Value
public class Post {

    String id;
    String title;
    String text;
    String category;
    String authorId;
}
