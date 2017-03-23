package com.newssystem.server.service;

import java.util.List;

/**
 * Created by wzielezi on 2017-03-23.
 */
public interface ServiceInterface<T> {
    List<T> getObj();
    T create(T obj);
    T findById (String id);
    T update(T obj);


}
