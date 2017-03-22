package com.newssystem.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.newssystem.server.domain.News;

/**
 * Created by wzielezi on 2017-03-21.
 */

@Repository
public interface NewsRepository extends MongoRepository <News, String> {
}
