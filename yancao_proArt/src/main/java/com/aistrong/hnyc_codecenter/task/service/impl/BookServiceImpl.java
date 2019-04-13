package com.aistrong.hnyc_codecenter.task.service.impl;


import com.aistrong.hnyc_codecenter.task.dao.BookDao;
import com.aistrong.hnyc_codecenter.task.entity.Book;
import com.aistrong.hnyc_codecenter.task.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    @Override
    public void reduceNumber(long bookId) {
        bookDao.reduceNumber(bookId);
    }
}
