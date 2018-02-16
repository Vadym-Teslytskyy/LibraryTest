package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genre extends AbstractEntityId{

	@OneToMany(mappedBy = "genre")
	private List<Book> books = new ArrayList<>();
	
    @Column(name = "genre_name", length = 20)
	private String genreName;
	
	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
