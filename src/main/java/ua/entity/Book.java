package ua.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book extends AbstractEntityId{

	private String photoUrl;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Genre genre;
	
	private int avalibleCounter;
	
	private LocalDate releaseDate;
	
	private String fullDesc;
	
	public String getPhotoUrl() {
		return photoUrl;
	}
	
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public int getAvalibleCounter() {
		return avalibleCounter;
	}
	
	public void setAvalibleCounter(int avalibleCounter) {
		this.avalibleCounter = avalibleCounter;
	}
	
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getFullDesc() {
		return fullDesc;
	}
	
	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}
}
