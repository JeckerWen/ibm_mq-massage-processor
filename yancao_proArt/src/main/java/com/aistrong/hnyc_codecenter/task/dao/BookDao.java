package com.aistrong.hnyc_codecenter.task.dao;

import com.aistrong.hnyc_codecenter.task.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    public Book queryById(long id);

    public List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    public void reduceNumber(long bookId);
}
