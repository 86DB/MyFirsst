package com.cssl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cssl.pojo.Book;

public interface BookDao {
	
	public List<Book> getAll(Integer index);
	
	public int delete(Integer id);
	
	public Book getById(Integer id);
	
	public int modify(@Param("bb") Book book);
	
	public int addBook(@Param("bb") Book book);

}
