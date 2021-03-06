package com.project.model;

// Generated 26 Mar, 2016 2:28:40 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AngBook generated by hbm2java
 */
@Entity
@Table(name = "ang_book", catalog = "awsmaven_db")
public class AngBook implements java.io.Serializable {

	private Integer id;
	private Price price;
	private String bookName;
	private String bookAuthor;
	private Date pubdate;
	private String country;
	private int pages;
	private String language;
	private String series;
	private String bookDesc;
	private Set<AngBookGenre> angBookGenres = new HashSet<AngBookGenre>(0);
	private Set<UserAngBook> userAngBooks = new HashSet<UserAngBook>(0);

	public AngBook() {
	}

	public AngBook(Price price, String bookName, String bookAuthor,
			Date pubdate, String country, int pages, String language,
			String bookDesc) {
		this.price = price;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.pubdate = pubdate;
		this.country = country;
		this.pages = pages;
		this.language = language;
		this.bookDesc = bookDesc;
	}

	public AngBook(Price price, String bookName, String bookAuthor,
			Date pubdate, String country, int pages, String language,
			String series, String bookDesc, Set<AngBookGenre> angBookGenres,
			Set<UserAngBook> userAngBooks) {
		this.price = price;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.pubdate = pubdate;
		this.country = country;
		this.pages = pages;
		this.language = language;
		this.series = series;
		this.bookDesc = bookDesc;
		this.angBookGenres = angBookGenres;
		this.userAngBooks = userAngBooks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "price_id", nullable = false)
	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Column(name = "book_name", nullable = false, length = 2000)
	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "book_author", nullable = false, length = 2000)
	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pubdate", nullable = false, length = 10)
	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Column(name = "country", nullable = false, length = 2000)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "pages", nullable = false)
	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Column(name = "language", nullable = false, length = 2000)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "series", length = 2000)
	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	@Column(name = "book_desc", nullable = false, length = 2000)
	public String getBookDesc() {
		return this.bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "angBook",cascade=CascadeType.ALL)
	public Set<AngBookGenre> getAngBookGenres() {
		return this.angBookGenres;
	}

	public void setAngBookGenres(Set<AngBookGenre> angBookGenres) {
		this.angBookGenres = angBookGenres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "angBook")
	public Set<UserAngBook> getUserAngBooks() {
		return this.userAngBooks;
	}

	public void setUserAngBooks(Set<UserAngBook> userAngBooks) {
		this.userAngBooks = userAngBooks;
	}

}
