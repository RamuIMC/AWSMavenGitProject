package com.project.model;

// Generated 26 Mar, 2016 2:28:40 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BookGenre generated by hbm2java
 */
@Entity
@Table(name = "book_genre", catalog = "awsmaven_db")
public class BookGenre implements java.io.Serializable {

	private Integer id;
	private String genre;
	private Set<AngBookGenre> angBookGenres = new HashSet<AngBookGenre>(0);

	public BookGenre() {
	}

	public BookGenre(String genre) {
		this.genre = genre;
	}

	public BookGenre(String genre, Set<AngBookGenre> angBookGenres) {
		this.genre = genre;
		this.angBookGenres = angBookGenres;
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

	@Column(name = "genre", nullable = false)
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookGenre")
	public Set<AngBookGenre> getAngBookGenres() {
		return this.angBookGenres;
	}

	public void setAngBookGenres(Set<AngBookGenre> angBookGenres) {
		this.angBookGenres = angBookGenres;
	}

}
