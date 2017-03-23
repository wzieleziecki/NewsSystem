package com.newssystem.server.service;

import com.newssystem.server.domain.News;
import com.newssystem.server.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.toList;
import java.util.List;

/**
 * Created by wzielezi on 2017-03-23.
 */
@Service
public class NewsService implements ServiceInterface<News>{

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    private List<News> convertToDTOs(List<News> models){
        return models.stream().map(this::convertToDTO).collect(toList());

    }

    private News convertToDTO(News model){
        News dto = new News();
        dto.setId(model.getId());
        dto.setData(model.getData());
        dto.setText(model.getText());
        dto.setTitle(model.getTitle());

        return dto;
    }

    @Override
    public List<News> getObj() {
        List<News> newsList = newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    @Override
    public News create(News obj) {
        return newsRepository.save(obj);
    }

    @Override
    public News findById(String id) {
        return null;
    }

    @Override
    public News update(News obj) {
        return null;
    }
}
