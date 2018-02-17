package ua.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "copy_of_book")
public class CopyOfBook extends AbstractEntityId {

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @OneToOne(mappedBy = "copyOfBook")
    private Rent rent;

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

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

}
