package com.airtribe.branches;

import com.airtribe.book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInventory {
    private List<Book> booksList;

    public BookInventory() {
        this.booksList = new ArrayList<>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void addBook(Book book) {
        booksList.add(book);
    }

    public boolean removeBook(Book book) {
        return booksList.remove(book);
    }

    public Book getBookById(String bookId) {
        for (Book book : booksList) {
            if (book.getBookID().equals(bookId))
                return book;
        }
        return null;
    }

    public boolean updateBook(String bookID, Book updatedInfo) {
        Book book= getBookById(bookID);
        if (book != null) {
            book.setTitle(updatedInfo.getTitle());
            book.setAuthor(updatedInfo.getAuthor());
            book.setPublicationYear(updatedInfo.getPublicationYear());
            book.setGenre(updatedInfo.getGenre());
            book.setISBN(updatedInfo.getISBN());
            return true;
        }
        return false;
    }

    public boolean transferBookToOtherInventory(Book book, BookInventory toInventory) {
        if (this.removeBook(book)) {
            toInventory.addBook(book);
            return true;
        }
        return false;
    }
}
