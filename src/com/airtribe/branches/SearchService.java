package com.airtribe.branches;

import com.airtribe.book.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
    public List<Book> searchBooksByTitle(List<Book> inventory, String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByAuthor(List<Book> inventory, String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchBooksByISBN(List<Book> inventory, String isbn) {
        List<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {
                result.add(book);
            }
        }
        return result;
    }
}
