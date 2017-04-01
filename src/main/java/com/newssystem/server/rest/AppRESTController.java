package com.newssystem.server.rest;

import com.newssystem.server.domain.Comment;
import com.newssystem.server.domain.News;
import com.newssystem.server.service.CommentService;
import com.newssystem.server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wzielezi on 2017-03-25.
 */
@RestController
@RequestMapping("/api/news")
public class AppRESTController {

    private final CommentService commentService;
    private final NewsService newsService;
    private final Map<String, Object> response = new LinkedHashMap<>();


    @Autowired
    public AppRESTController(CommentService commentService, NewsService newsService) {
        this.commentService = commentService;
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody
    List<News> findAllnews(){
        return newsService.getObj();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public @ResponseBody Map<String, Object> create(@Valid @RequestBody News newsEntity, BindingResult bindingResult){

        if(checkError(bindingResult)){
            newsService.create(newsEntity);
            response.put("message", "News created successfully");
            response.put("news", newsService.create(newsEntity));
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getComment" )
    public @ResponseBody
    List<Comment> findAllComments(){ return commentService.getObj();}

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    public @ResponseBody Map<String, Object> create(@Valid @RequestBody Comment commentEntity, BindingResult bindingResult){

        if(checkError(bindingResult)){
            commentService.create(commentEntity);
            response.put("message", "Comment created successfully");
        }

        return response;
    }

    public boolean checkError(BindingResult bindingResult){
        if (bindingResult.hasErrors()){

            System.out.println("Error");
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message", "error");

            for(FieldError error: errors){

                System.out.println(error.getField()+ " - "+ error.getDefaultMessage());
                response.put(error.getField(), error.getDefaultMessage());
            }

            return false;
        }else {

            return true;

        }
    }

}
