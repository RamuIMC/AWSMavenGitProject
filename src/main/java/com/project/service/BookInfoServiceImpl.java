package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.Dao.BookInfoDao;
import com.project.dto.BookInfoDto;
import com.project.model.User;

@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService{
	
	@Autowired
	BookInfoDao bookInfoDao;

	
	@Override
	@Transactional
	public BookInfoDto getBookById(int bookId) {
	
		return bookInfoDao.getBookById(bookId);
	}
	
	@Override
	@Transactional
	public BookInfoDto getBookByName(String bookName) {
	
		return bookInfoDao.getBookByName(bookName);
	}


	@Override
	public List<BookInfoDto> getAllBooks() {
		
		return bookInfoDao.getAllBooks();
	}


	@Override
	@Transactional
	public BookInfoDto saveBook(BookInfoDto bookInfoDto) {
		// TODO Auto-generated method stub
		return bookInfoDao.saveBook(bookInfoDto);
	}


	@Override
	@Transactional
	public User getUser(String username) {
		
		return bookInfoDao.getUser(username);
	}
	
	

}
