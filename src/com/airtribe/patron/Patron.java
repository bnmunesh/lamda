package com.airtribe.patron;

import java.util.*;
import com.airtribe.book.Book;
import com.airtribe.book.BookGenre;


public class Patron {
    private String PID;
    private String name;
    //private int age;
    private String patronAddress;
    private List<Book> borrowedBooks;
    private List<Book> borrowingHistory;
    private Set<BookGenre> favouriteGenres;
    private Set<String> favouriteAuthors;

    public Patron(String PID, String name, String patronAddress) {
        this.PID = PID;
        this.name = name;
        this.patronAddress =patronAddress;
        this.borrowedBooks= new ArrayList<>();
        this.borrowingHistory= new ArrayList<>();
        this.favouriteGenres= new HashSet<>();
        this.favouriteAuthors= new HashSet<>();
    }

    //To get and Update Patron details
    public String getPID() {
        return PID;
    }
    public void setPID(String PID) {
        this.PID = PID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPatronAddress() {
        return patronAddress;
    }
    public void setPatronAddress(String patronAddress) {
        this.patronAddress = patronAddress;
    }


    public void borrowBook(Book book){
        borrowedBooks.add(book);
        borrowingHistory.add(book);
        favouriteGenres.add(book.getGenre());
        favouriteAuthors.add(book.getAuthor());
    }
    public boolean returnBook(Book book){
        return borrowedBooks.remove(book);
    }
    public boolean hasBorrowed(Book book){
        return borrowedBooks.contains(book);
    }
    public boolean hasBookInBorrowingHistory(Book book){
        return borrowingHistory.contains(book);
    }


    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public Set<BookGenre> getFavouriteGenres() {
        return favouriteGenres;
    }

    public Set<String> getFavouriteAuthors() {
        return favouriteAuthors;
    }

    @Override
    public String toString() {
        return "Patron [\n" +
                "  ID: " + PID + "\n" +
                "  Name: " + name + "\n" +
                "  Address: " + patronAddress + "\n" +
                "  Favorite Genres: " + favouriteGenres + "\n" +
                "  Favorite Authors: " + favouriteAuthors + "\n" +
                "  Borrowed Books: " + borrowedBooks + "\n" +
                "]";
    }
}
