package ua.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "copy_of_book")
public class CopyOfBook extends AbstractEntityId{
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Book book;
	
	@ManyToMany(mappedBy="borrowedCopies")
    private List<Rent> rents;
	
	@Column(name = "release_date")
    private LocalDate releaseDate;
	
	@Column(name = "pages_amount")
	private int pagesAmount;

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getPagesAmount() {
		return pagesAmount;
	}

	public void setPagesAmount(int pagesAmount) {
		this.pagesAmount = pagesAmount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	
	
	
}
