package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.BookInfoDto;
import com.project.service.BookInfoService;


@RestController
public class BookInfoController {
	
	@Autowired
	BookInfoService bookInfoService;
	
	@RequestMapping(value="/getbook-info/{id}",method=RequestMethod.GET)
	public BookInfoDto getBookById(@PathVariable("id") int bookId ){
		
		
		return bookInfoService.getBookById(bookId);
		
	}
	
	

}
