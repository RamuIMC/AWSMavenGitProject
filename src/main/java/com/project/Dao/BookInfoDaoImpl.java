/**
 * 
 */
package com.project.Dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dto.BookInfoDto;
import com.project.model.AngBook;
import com.project.model.AngBookGenre;
import com.project.model.BookGenre;
import com.project.model.Price;

/**
 * @author Ramakrishna
 *
 */
@Repository("bookInfoDao")
public class BookInfoDaoImpl implements BookInfoDao{
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public BookInfoDto getBookById(int bookId) {
		
		Set<String> setAngBookGenre = new HashSet<String>();
		
		BookInfoDto bookInfoDto = new BookInfoDto();
		AngBook angBook = (AngBook) sessionFactory.getCurrentSession().load(AngBook.class, bookId);
		Price price = angBook.getPrice();
		int bookAmount = price.getAmount();
		
		bookInfoDto.setBookId(angBook.getId());
		bookInfoDto.setBookName(angBook.getBookName());
		bookInfoDto.setBookAuthor(angBook.getBookAuthor());
		bookInfoDto.setCountry(angBook.getCountry());
		bookInfoDto.setLanguage(angBook.getLanguage());
		bookInfoDto.setPages(angBook.getPages());
		bookInfoDto.setPrice(bookAmount);
		bookInfoDto.setPubDate(angBook.getPubdate());
		bookInfoDto.setSeries(angBook.getSeries());
		bookInfoDto.setBookDesc(angBook.getBookDesc());
		
		
		for(AngBookGenre abg :angBook.getAngBookGenres()){
			
			setAngBookGenre.add(abg.getBookGenre().getGenre());
		}
		
		bookInfoDto.setGenre(setAngBookGenre);
		
		
		
		return bookInfoDto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookInfoDto> getAllBooks() {
		
		Set<String> setAngBookGenre;
		List<BookInfoDto> listOfBooks = new ArrayList<BookInfoDto>();
		BookInfoDto bookInfoDto;
		
		List<AngBook> angBooks = (ArrayList<AngBook>) sessionFactory.getCurrentSession().createQuery("from AngBook").list();
		
		for(AngBook angBook: angBooks){
			
			bookInfoDto = new BookInfoDto();
			setAngBookGenre = new HashSet<String>();
			
			Price price = angBook.getPrice();
			int bookAmount = price.getAmount();
			
			bookInfoDto.setBookId(angBook.getId());
			bookInfoDto.setBookName(angBook.getBookName());
			bookInfoDto.setBookAuthor(angBook.getBookAuthor());
			bookInfoDto.setCountry(angBook.getCountry());
			bookInfoDto.setLanguage(angBook.getLanguage());
			bookInfoDto.setPages(angBook.getPages());
			bookInfoDto.setPrice(bookAmount);
			bookInfoDto.setPubDate(angBook.getPubdate());
			bookInfoDto.setSeries(angBook.getSeries());
			bookInfoDto.setBookDesc(angBook.getBookDesc());
		
			for(AngBookGenre bookGenre : angBook.getAngBookGenres()){
				
				setAngBookGenre.add(bookGenre.getBookGenre().getGenre());
				
			}
			bookInfoDto.setGenre(setAngBookGenre);
		
			listOfBooks.add(bookInfoDto);
		}
		return listOfBooks;
	}

	
	@Override
	public BookInfoDto saveBook(BookInfoDto bookInfoDto) {
		
		Session session= sessionFactory.getCurrentSession();
		
		AngBook angBook = new AngBook();
		int bookId= bookInfoDto.getBookId();
		int bookAmount = bookInfoDto.getPrice();
		
		Price price;
		
		if(bookId != 0){
			
			angBook = (AngBook) sessionFactory.getCurrentSession().load(AngBook.class, bookId);
			price = angBook.getPrice();
			price.setAmount(bookAmount);
		
		}
		else{
			
			price = new Price(bookAmount);
		}
		
		angBook.setBookName(bookInfoDto.getBookName());
		angBook.setBookAuthor(bookInfoDto.getBookAuthor());
		angBook.setBookDesc(bookInfoDto.getBookDesc());
		angBook.setCountry(bookInfoDto.getCountry());
		angBook.setLanguage(bookInfoDto.getLanguage());
		angBook.setPages(bookInfoDto.getPages());
		angBook.setPrice(price);
		angBook.setPubdate(bookInfoDto.getPubDate());
		angBook.setSeries(bookInfoDto.getSeries());
		
		Set<AngBookGenre> setOfBookGenres = new HashSet<AngBookGenre>();
		AngBookGenre angBookGenre = null;
		
		for(String genre : bookInfoDto.getGenre()){
			
		List<BookGenre> bookGenre = (ArrayList<BookGenre>) session.createQuery("from BookGenre where genre = '"+genre+"'").list();
		
		if(bookGenre != null && bookGenre.size() != 0){
			for(BookGenre book_genre : bookGenre){
				
				angBookGenre = new AngBookGenre(book_genre, angBook);
			}	
			
		}
		else{
			
			BookGenre bGenre = new BookGenre(genre);
			session.save(bGenre);
			angBookGenre = new AngBookGenre(bGenre, angBook);
		}
		
		setOfBookGenres.add(angBookGenre);
		}
		for(AngBookGenre aBGenre : angBook.getAngBookGenres()){
			
			session.delete(aBGenre);
			
		}
		
		angBook.setAngBookGenres(setOfBookGenres);
		session.save(angBook);
		
		return bookInfoDto;
	}

}




















