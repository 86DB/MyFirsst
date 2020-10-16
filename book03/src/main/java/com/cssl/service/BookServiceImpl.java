package com.cssl.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cssl.dao.BookDao;
import com.cssl.pojo.Book;
import com.cssl.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

@Service("bookServiceImpl")
@Transactional
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Resource
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAll(Integer index) {
	    PageHelper.startPage(index, 3);
		List<Book> listBook = bookDao.getAll(index);
		return listBook;
	}

	@Override
	public int delete(Integer id) {
		int num = bookDao.delete(id);
		return num;
	}

	@Override
	public Book getById(Integer id) {
		Book book = bookDao.getById(id);
		return book;
	}

	@Override
	public int modify(Book book) {
		int modify = bookDao.modify(book);
		return modify;
	}

	@Override
	public int addStudent(Book book) {
		int addBook = bookDao.addBook(book);
		return addBook;
	}

}
