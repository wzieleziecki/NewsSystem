package com.newssystem.server.service;

import com.newssystem.server.domain.Comment;
import com.newssystem.server.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.toList;

import java.util.List;

/**
 * Created by wzielezi on 2017-03-24.
 */

@Service
public class CommentService implements ServiceInterface<Comment>, CustomInterfaceComment{

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private List<Comment> convertToDTOs(List<Comment> models){
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private Comment convertToDTO (Comment model){
        Comment dto = new Comment();
        dto.setId(model.getId());
        dto.setNewsId(model.getNewsId());
        dto.setData(model.getData());
        dto.setAuthor(model.getAuthor());
        dto.setComment(model.getComment());

        return dto;
    }

    @Override
    public List<Comment> getObj() {
        List<Comment> commentList = commentRepository.findAll();
        return convertToDTOs(commentList);
    }

    @Override
    public Comment create(Comment obj) {
        return null;
    }

    @Override
    public Comment findById(String id) {
        return null;
    }

    @Override
    public Comment update(Comment obj) {
        return null;
    }

    @Override
    public List<Comment> findByNewsID(String id) {
        List<Comment> commentList = commentRepository.findByNewsId(id);

        return convertToDTOs(commentList);
    }
}
