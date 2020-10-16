package com.cssl.service;


import java.util.List;

import com.cssl.pojo.Book;

public interface BookService {
	
	public List<Book> getAll(Integer index);
	
	public int delete(Integer id);
	
	public Book getById(Integer id);
	
	public int modify(Book book);
	
	public int addStudent(Book book);

}
