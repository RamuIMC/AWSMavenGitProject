package com.project.controller;


import java.security.Principal;
import java.util.List;











import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/getbook-info",method=RequestMethod.GET)
	public BookInfoDto getBookByName(@RequestParam("bookName") String bookName ){
		
		
		return bookInfoService.getBookByName(bookName);
		
	}
	
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/webServices/getallbooks",method=RequestMethod.GET)
	public List<BookInfoDto> getAllBooks(){
		
		
		return bookInfoService.getAllBooks();
		
	}
	
	@RequestMapping(value="/postbook",method=RequestMethod.POST)
	public ResponseEntity<BookInfoDto> saveBook(@RequestBody BookInfoDto bookInfoDto){
		
		
		BookInfoDto bookInfo = bookInfoService.saveBook(bookInfoDto);
		
		return new ResponseEntity<BookInfoDto>(bookInfo,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
    public ModelAndView loginForm() {
        return new ModelAndView("login");
    }
	
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
    public ModelAndView welcome(SecurityContextHolderAwareRequestWrapper request ,Principal principal, Model model,Authentication authentication) {
		
		//System.out.println("Roles : " +authentication.getAuthorities());
			model.addAttribute("username", "ABC");
			
			return new ModelAndView("welcome");
		
		
        
    }
	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping(value="/welcome-abc", method=RequestMethod.GET)
    public String welcomeABC(SecurityContextHolderAwareRequestWrapper request ,Principal principal, Model model,Authentication authentication) {
		
		System.out.println("Roles : " +authentication.getAuthorities());
			model.addAttribute("username", principal.getName());
			
			return "welcome";
		
		
        
    }
	
	

}
