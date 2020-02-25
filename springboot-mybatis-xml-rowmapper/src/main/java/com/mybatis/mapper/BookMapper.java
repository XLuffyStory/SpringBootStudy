package com.mybatis.mapper;

import java.util.List;

import com.mybatis.Book;

public interface BookMapper {
    List<Book> getAllBooks();
    public int insertBook(Book book);
    public int deleteBook(int id);
    public int updateBook(Book book);
    public Book getBookById(int id);
}
