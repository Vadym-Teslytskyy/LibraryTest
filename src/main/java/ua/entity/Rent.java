package ua.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "rent")
public class Rent extends AbstractEntityId{

    @Column(name = "borrowing_time")
	private LocalDateTime borrowingTime;

    @Column(name = "return_time", length = 20)
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
