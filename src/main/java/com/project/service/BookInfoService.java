package com.project.service;

import java.util.List;

import com.project.dto.BookInfoDto;
import com.project.model.User;

public interface BookInfoService {
	
	public BookInfoDto getBookById(int bookId);
	
	public List<BookInfoDto> getAllBooks();
	
	public User getUser(String username);
	
	public BookInfoDto saveBook(BookInfoDto bookInfoDto);
	
	public BookInfoDto getBookByName(String bookName);

}
