package com.cssl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.cssl.pojo.Book;
import com.cssl.pojo.User;
import com.cssl.service.BookService;
import com.github.pagehelper.PageInfo;

@Controller
@SessionAttributes(types = User.class)
public class BookController {

	@Autowired
	private BookService bookService;

	// 所有图书
	@RequestMapping("/show.action")
	@ResponseBody
	public PageInfo<Book> getall(@RequestParam(defaultValue = "1") Integer index) {
		List<Book> all = bookService.getAll(index);
		PageInfo<Book> pageInfo = new PageInfo<Book>(all);
		System.out.println(pageInfo);
		return pageInfo;
	}

	// 删除图书
	@RequestMapping("/delete.action")
	@ResponseBody
	public int deleteBook(int id) {
		int delete = bookService.delete(id);
		return delete;
	}

	// 新增图书
	@RequestMapping("/insert.action")
	public String add(Book book) {
		int addStudent = bookService.addStudent(book);
		if (addStudent > 0) {
			return "redirect:/index.html";
		} else {
			return "redirect:/insert.html";
		}
	}

	@ResponseBody
	@RequestMapping("showID.action")
	public Book showid(int id) {
		Book book = bookService.getById(id);
		return book;
	}

	// 修改图书
	@PostMapping("/modify.action")
	public String modifBook(Book book) {
		int modify = bookService.modify(book);
		if (modify > 0) {
			return "redirect:/index.html";
		} else {
			return "redirect:/update.html";
		}
	}
	
	@RequestMapping("/log.action")
	public String login(User user,HttpServletRequest request) {
		request.getSession().setAttribute("user", user);
		System.out.println("------------"+user);
		return "redirect:/index.html";
		
	}
	
}
