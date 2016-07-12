/**
 * 
 */
package com.project.Dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.BookInfoDto;
import com.project.model.AngBook;
import com.project.model.AngBookGenre;
import com.project.model.BookGenre;
import com.project.model.Price;
import com.project.model.User;

/**
 * @author Ramakrishna
 *
 */
@Repository("bookInfoDao")
public class BookInfoDaoImpl implements BookInfoDao{
	
	/*@Autowired 
	private SessionFactory sessionFactory;*/
	
	@PersistenceContext
    private EntityManager manager;

	@Override
	public BookInfoDto getBookById(int bookId) {
		
		Set<String> setAngBookGenre = new HashSet<String>();
		
		BookInfoDto bookInfoDto = new BookInfoDto();
		//AngBook angBook = (AngBook) sessionFactory.getCurrentSession().load(AngBook.class, bookId);
		AngBook angBook = null;
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
	@Transactional
	public List<BookInfoDto> getAllBooks() {
		
		Set<String> setAngBookGenre;
		List<BookInfoDto> listOfBooks = new ArrayList<BookInfoDto>();
		BookInfoDto bookInfoDto;
		
		List<AngBook> angBooks = null;
				//(ArrayList<AngBook>) sessionFactory.getCurrentSession().createQuery("from AngBook").list();
		
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
		
		//Session session= sessionFactory.getCurrentSession();
		
		AngBook angBook = new AngBook();
		int bookId= bookInfoDto.getBookId();
		int bookAmount = bookInfoDto.getPrice();
		
		Price price;
		
		if(bookId != 0){
			
			angBook = null;
			//(AngBook) sessionFactory.getCurrentSession().load(AngBook.class, bookId);
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
			
		List<BookGenre> bookGenre = null;
		//(ArrayList<BookGenre>) session.createQuery("from BookGenre where genre = '"+genre+"'").list();
		
		if(bookGenre != null && bookGenre.size() != 0){
			for(BookGenre book_genre : bookGenre){
				
				angBookGenre = new AngBookGenre(book_genre, angBook);
			}	
			
		}
		else{
			
			BookGenre bGenre = new BookGenre(genre);
			//session.save(bGenre);
			angBookGenre = new AngBookGenre(bGenre, angBook);
		}
		
		setOfBookGenres.add(angBookGenre);
		}
		for(AngBookGenre aBGenre : angBook.getAngBookGenres()){
			
			//session.delete(aBGenre);
			
		}
		
		angBook.setAngBookGenres(setOfBookGenres);
		//session.save(angBook);
		
		return bookInfoDto;
	}

	@Override
	public User getUser(String username) {
		
		System.out.println("QUERY IS:");
		
		//User user = (User) sessionFactory.getCurrentSession().createQuery("from User where userName = '"+username+"'").list().get(0);
		
		
		return null;
	}

	@Override
	public BookInfoDto getBookByName(String bookName) {
		
		Set<String> setAngBookGenre = new HashSet<String>();
		
		BookInfoDto bookInfoDto = new BookInfoDto();
		CriteriaBuilder cb =  manager.getCriteriaBuilder();
		 CriteriaQuery<AngBook> cq = cb.createQuery(AngBook.class);
		 Root<AngBook> root = cq.from(AngBook.class);
		 
		 Predicate predicate = cb.equal(root.get("bookName"), bookName);
		 
		cq.where(predicate);
		
		List<AngBook> angBooks = manager.createQuery(cq).getResultList();
		
		for(AngBook angBook : angBooks){
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
		
		}
		
		
		
		return bookInfoDto;
	}

}




















