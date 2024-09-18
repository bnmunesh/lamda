package com.airtribe.library;

import com.airtribe.book.Book;
import com.airtribe.branches.Branch;

public class InventoryManager {
    private LibraryManagementSystem LMS;

    public InventoryManager(LibraryManagementSystem librarySystem) {
        this.LMS = librarySystem;
    }

    public void showAvailableBooks(String branchName){
        Branch branch= LMS.getBranchByBranchName(branchName);
        if (branch!=null){
            for (Book book: branch.getInventory().getBooksList()){
                if (!book.isBorrowed())
                    System.out.println(book);
            }
        }
    }

    public void showBorrowedBooks(String branchName){
        Branch branch= LMS.getBranchByBranchName(branchName);
        if (branch!=null){
            for (Book book: branch.getInventory().getBooksList()){
                if (book.isBorrowed())
                    System.out.println(book);
            }
        }
    }
}
