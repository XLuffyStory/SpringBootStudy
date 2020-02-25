package com.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.mapper.BookMapper;

@RestController
public class BookController {
    @Autowired
    BookMapper bookMapper;

    @GetMapping("/allBooks")
    public String allBooks() {
	List<Book> books = bookMapper.getAllBooks();
	return books.toString();
    }
    
    @GetMapping("/insert")
    public String insert() {
	Book book = new Book(5, "Hello", "World");
	int id = bookMapper.insertBook(book);
	return String.valueOf(id) ;
    }
    
    @Transactional
    @GetMapping("/update/{id}")
    public String update(@PathVariable String id) {
	int bookId = Integer.valueOf(id);
	Book book = bookMapper.getBookById(bookId);
	
	book.setName(book.getName() + "Update");
	book.setAuthor(book.getAuthor() + "Update");
	
	 int updateBookId = bookMapper.updateBook(book);
	return String.valueOf(updateBookId) ;
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
	int bookId = Integer.valueOf(id);
	 int deleteBookId = bookMapper.deleteBook(bookId);
	
	return String.valueOf(deleteBookId);
    }
    
    
}
