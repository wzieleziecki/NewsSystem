package com.newssystem.server.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by wzielezi on 2017-03-21.
 */

@Document
public class Comment {
    @Id
    private String Id;
    @NotNull(message = "Brak newsId")
    private String newsId;
    @NotNull
    @Size(min = 2, max = 20, message = "Minimalna długość autora to 2 znaki, maksymalna to 20 znaków")
    private String author;
    @NotNull
    private String data;
    @NotNull
    @Size(min = 5, max = 2000, message = "Minimalna długość komentarza to 5 znaków, maksymalna 2000 znaków")
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


