package ua.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "rent")
public class Rent extends AbstractEntityId{

	@ManyToMany
	private List<CopyOfBook> borrowedCopies;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
    @Column(name = "borrowing_time")
	private LocalDateTime borrowingTime;

    @Column(name = "return_time", length = 20)
	private LocalDateTime returnTime;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CopyOfBook> getBorrowedCopies() {
		return borrowedCopies;
	}

	public void setBorrowedCopies(List<CopyOfBook> borrowedCopies) {
		this.borrowedCopies = borrowedCopies;
	}

	
}
