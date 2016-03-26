package com.project.Dao;

import java.util.List;

import com.project.dto.BookInfoDto;
import com.project.model.User;

public interface BookInfoDao {
	

	public BookInfoDto getBookById(int bookId);

	public List<BookInfoDto> getAllBooks();
	
	public BookInfoDto saveBook(BookInfoDto bookInfoDto);
	
	public User getUser(String username);
	
	
}
