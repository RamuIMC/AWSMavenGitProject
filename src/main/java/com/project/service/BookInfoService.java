package com.project.service;

import java.util.List;

import com.project.dto.BookInfoDto;

public interface BookInfoService {
	
	public BookInfoDto getBookById(int bookId);
	
	public List<BookInfoDto> getAllBooks();

}
