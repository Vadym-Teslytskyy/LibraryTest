package ua.model.view;

public class BookIndexView {

    private Integer id;

    private String photoUrl;

    private String bookName;

    private String author;

    private String genre;

    private int avalibleCounter;

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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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


}
