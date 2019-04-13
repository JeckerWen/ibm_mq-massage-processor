package com.aistrong.hnyc_codecenter.task.service;

import com.aistrong.hnyc_codecenter.task.entity.Book;

import java.util.List;

public interface BookService {

    public Book getById(long bookId);

    public List<Book> getList();

    public void reduceNumber(long bookId);


}
