package com.airtribe.library;

import com.airtribe.book.Book;
import com.airtribe.branches.Branch;

public class BranchManager {
    private LibraryManagementSystem LMS;

    public BranchManager(LibraryManagementSystem librarySystem) {
        this.LMS = librarySystem;
    }

    public void listBranches() {
        for (Branch branch : LMS.getBranches().values())
            System.out.println(branch);
    }

    public void addBranch(String branchName, String branchAddress) {
        LMS.getBranches().put(branchName, new Branch(branchName, branchAddress));
    }

    public void removeBranch(String branchName) {
        LMS.getBranches().remove(branchName);
    }

    public boolean transferBook(String bookID, String fromBranchName, String toBranchName) {
        Branch fromBranch = LMS.getBranchByBranchName(fromBranchName);
        Branch toBranch = LMS.getBranchByBranchName(toBranchName);

        if (fromBranch == null || toBranch == null) {
            System.out.println("One or both branches do not exist.");
            return false;
        }
        Book book = fromBranch.getInventory().getBookById(bookID);
        if (book != null)
            return fromBranch.getInventory().transferBookToOtherInventory(book, toBranch.getInventory());

        System.out.println("Book not found");
        return false;
    }
}

