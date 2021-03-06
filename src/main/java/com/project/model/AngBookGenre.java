package com.project.model;

// Generated 26 Mar, 2016 2:28:40 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AngBookGenre generated by hbm2java
 */
@Entity
@Table(name = "ang_book_genre", catalog = "awsmaven_db")
public class AngBookGenre implements java.io.Serializable {

	private Integer id;
	private BookGenre bookGenre;
	private AngBook angBook;

	public AngBookGenre() {
	}

	public AngBookGenre(BookGenre bookGenre, AngBook angBook) {
		this.bookGenre = bookGenre;
		this.angBook = angBook;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_genre_id", nullable = false)
	public BookGenre getBookGenre() {
		return this.bookGenre;
	}

	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ang_book_id", nullable = false)
	public AngBook getAngBook() {
		return this.angBook;
	}

	public void setAngBook(AngBook angBook) {
		this.angBook = angBook;
	}

}
