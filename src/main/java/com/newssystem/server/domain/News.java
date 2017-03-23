package com.newssystem.server.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by wzielezi on 2017-03-21.
 */

@Document
public class News {

    @Id
    private String id;
    private String text;
    private String data;
    private String title;

    public News(){};

    public News( String text, String data, String title) {
        this.text = text;
        this.data = data;
        this.title = title;
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
}

