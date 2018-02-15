package ua.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends AbstractEntityId {

    private String photoUrl;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;
    
    @ManyToMany(mappedBy="borrowedBooks")
    private List<Rent> rents;

    private int avalibleCounter;

    private LocalDate releaseDate;

    private String fullDescription;

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
		return fullDescription;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDescription = fullDesc;
	}
    
    


}
