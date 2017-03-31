package com.newssystem.server.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by wzielezi on 2017-03-21.
 */

@Document
public class News {

    @Id
    private String id;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 5, message = "Musisz podać minimum 5 znaków")
    private String text;

    private String data;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 5, max = 70, message = "Musisz podać minimum 5, maksimum 70 znaków")
    private String title;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 1, message = "Podaj minimum 1 znak")
    private String author;

    public News(){}

    public News(String text, String data, String title, String author) {
        this.text = text;
        this.data = data;
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

