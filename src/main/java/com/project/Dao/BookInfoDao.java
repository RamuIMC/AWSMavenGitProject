package com.project.Dao;

import java.util.List;

import com.project.dto.BookInfoDto;

public interface BookInfoDao {
	

	public BookInfoDto getBookById(int bookId);

	public List<BookInfoDto> getAllBooks();
	
	public BookInfoDto saveBook(BookInfoDto bookInfoDto);
}
