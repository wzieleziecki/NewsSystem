package com.newssystem.server.service;

import com.newssystem.server.domain.Comment;

import java.util.List;

/**
 * Created by wzielezi on 2017-03-25.
 */
public interface CustomInterfaceComment {

    List<Comment> findByNewsID(String id);
}
