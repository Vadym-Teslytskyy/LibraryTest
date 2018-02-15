package ua.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rent")
public class Rent extends AbstractEntityId{

	private LocalDateTime borrowingTime;
	
	private LocalDateTime returnTime;
	
	@ManyToMany
	private List<Book> borrowedBooks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public LocalDateTime getBorrowingTime() {
		return borrowingTime;
	}

	public void setBorrowingTime(LocalDateTime borrowingTime) {
		this.borrowingTime = borrowingTime;
	}

	public LocalDateTime getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
