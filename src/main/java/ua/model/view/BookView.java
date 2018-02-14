package ua.model.view;

import java.time.LocalDate;

public class BookView {
	
	private Integer id;
	
	private String photoUrl;
	
	private String name;
	
	private String author;
	
	private String genre;
	
	private int avalibleCounter;
	
	private LocalDate releaseDate;
	
	private String fullDesc;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
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
