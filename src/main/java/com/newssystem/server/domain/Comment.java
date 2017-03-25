package com.newssystem.server.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wzielezi on 2017-03-21.
 */

@Document
public class Comment {
    @Id
    private String Id;
    private String newsId;
    private String author;
    private String data;
    private String comment;

    public Comment(){}

    public Comment(String newsId, String author, String data, String comment) {
        this.newsId = newsId;
        this.author = author;
        this.data = data;
        this.comment = comment;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}


