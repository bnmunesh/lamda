package com.airtribe.branches;

import com.airtribe.book.Book;

import java.util.List;

public class Branch {
    private BranchDetails branchDetails;
    private BookInventory inventory;
    private SearchService searchService;

    public Branch(String branchName, String branchAddress) {
        this.branchDetails = new BranchDetails(branchName, branchAddress);
        this.inventory = new BookInventory();
        this.searchService = new SearchService();
    }

    public BranchDetails getBranchDetails() {
        return branchDetails;
    }

    public BookInventory getInventory() {
        return inventory;
    }

    public List<Book> searchBooksByTitle(String title) {
        return searchService.searchBooksByTitle(inventory.getBooksList(), title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return searchService.searchBooksByAuthor(inventory.getBooksList(), author);
    }

    public List<Book> searchBooksByISBN(String isbn) {
        return searchService.searchBooksByISBN(inventory.getBooksList(), isbn);
    }

    @Override
    public String toString() {
        return "Branch [" + branchDetails +
                ", Inventory=" + inventory.getBooksList().size() + " books" +
                ']';
    }
}

