package com.newssystem.server.rest;

import com.newssystem.server.domain.News;
import com.newssystem.server.service.CommentService;
import com.newssystem.server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wzielezi on 2017-03-25.
 */
@RestController
@RequestMapping("/api/news")
public class AppRESTController {

    private final CommentService commentService;
    private final NewsService newsService;

    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAll(){
        return newsService.getObj();
    }
}
