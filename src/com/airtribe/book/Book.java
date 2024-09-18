package com.airtribe.book;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;
    private BookGenre genre;
    private int publicationYear;

    public Book(String bookID, String title, String author, BookGenre genre, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
        this.genre = genre;
        this.bookID= bookID;
        this.publicationYear= publicationYear;
    }

    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    public BookGenre getGenre() {
        return genre;
    }
    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }


    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book [" +
                "  ID: " + bookID +
                "  Title: " + title +
                "  Author: " + author +
                "  Genre: " + genre +
                "  ISBN: " + ISBN +
                "  Publication Year: " + publicationYear +
                "]";
    }

}
