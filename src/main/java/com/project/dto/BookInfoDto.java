package com.project.dto;

import java.util.Date;
import java.util.Set;

public class BookInfoDto {

	private Integer bookId;
	private int price;
	private String bookName;
	private String bookAuthor;
	private String country;
	private int pages;
	private String language;
	private String series;
	private Date pubDate;
	private Set<String> genre;
	
	
	public BookInfoDto(){
		
	}
	
	
	public BookInfoDto(Integer bookId, int price, String bookName,
			String bookAuthor, String country, int pages, String language,
			String series, Date pubDate, Set<String> genre) {
	
		this.bookId = bookId;
		this.price = price;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.country = country;
		this.pages = pages;
		this.language = language;
		this.series = series;
		this.pubDate = pubDate;
		this.genre = genre;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public Set<String> getGenre() {
		return genre;
	}
	public void setGenre(Set<String> genre) {
		this.genre = genre;
	}
	
	
	
	
}
