package ua.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book extends AbstractEntityId {

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "name", length = 40)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;
    
    @ManyToMany(mappedBy="borrowedBooks")
    private List<Rent> rents;

    @Column(name = "available_counter")
    private int avalibleCounter;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "full_description")
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
