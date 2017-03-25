package com.newssystem.server.repository;

import com.newssystem.server.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wzielezi on 2017-03-21.
 */

@Repository
public interface CommentRepository extends MongoRepository <Comment, String> {
    List<Comment> findByNewsId (String id);
}
