package com.airtribe;

import com.airtribe.book.*;
import com.airtribe.branches.Branch;
import com.airtribe.library.*;
import com.airtribe.library.recommendation.RecommendationManager;


public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = LibraryManagementSystem.getInstance();

        BranchManager branchManager = new BranchManager(librarySystem);
        PatronManager patronManager = new PatronManager(librarySystem);
        LendingManager lendingManager = new LendingManager(librarySystem);
        ReservationManager reservationManager = new ReservationManager(librarySystem);
        InventoryManager inventoryManager = new InventoryManager(librarySystem);
        RecommendationManager recommendationManager= new RecommendationManager(librarySystem);

        // Add branches
        branchManager.addBranch("Central", "Lalbagh");
        branchManager.addBranch("South", "HSR Layout");

        // Add books to branches
        Branch centralBranch = librarySystem.getBranchByBranchName("Central");
        Branch southBranch = librarySystem.getBranchByBranchName("South");

        // Adding books to Central Branch
        centralBranch.getInventory().addBook(new Book("1", "The Hobbit", "J.R.R. Tolkien", BookGenre.FANTASY, "1234567890", 1937));
        centralBranch.getInventory().addBook(new Book("2", "1984", "George Orwell", BookGenre.FICTION, "0987654321", 1949));
        centralBranch.getInventory().addBook(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald", BookGenre.CLASSICS, "2345678901", 1925));

        // Adding books to South Branch
        southBranch.getInventory().addBook(new Book("4", "To Kill a Mockingbird", "Harper Lee", BookGenre.CLASSICS, "1122334455", 1960));
        southBranch.getInventory().addBook(new Book("5", "The Catcher in the Rye", "J.D. Salinger", BookGenre.CLASSICS, "2233445566", 1951));
        southBranch.getInventory().addBook(new Book("6", "Pride and Prejudice", "Jane Austen", BookGenre.ROMANCE, "3344556677", 1813));

        // Add patrons
        patronManager.addPatron("P101", "Pawan", "BTM Layout");
        patronManager.addPatron("P102", "Debarun", "JP Nagar");
        patronManager.addPatron("P222", "Dhaval", "Indiranagar");
        patronManager.addPatron("P102", "Munesh", "Jayanagar");

        // List branches

        librarySystem.listPatrons();

        // Checkout a book
        System.out.print("\nCheckout Book: ");
        lendingManager.checkout("1", "P101", "Central");


        System.out.println();
        reservationManager.reserveBook("1","P222");
        reservationManager.reserveBook("1","P102");


        // Show borrowed books
        System.out.println("\nBorrowed Books in Central:");
        inventoryManager.showBorrowedBooks("Central");

        // Return a book
        System.out.print("\nReturn Book: ");
        lendingManager.returnBook("1", "P101", "Central");

        System.out.print("\nCheckout Book: ");
        lendingManager.checkout("1", "P222", "Central");
        System.out.print("\nReturn Book: ");
        lendingManager.returnBook("1", "P222", "Central");

        // Show available books
        System.out.println("\nAvailable Books in Central:");
        inventoryManager.showAvailableBooks("Central");

        // Transfer a book
        System.out.println("Transfer Book:");
        branchManager.transferBook("5", "South", "Central");

        // Show inventory of branches after transfer
        System.out.println("Inventory in Central:");
        inventoryManager.showAvailableBooks("Central");

        System.out.println("Inventory in North:");
        inventoryManager.showAvailableBooks("South");

        //Recommendations
        System.out.println();
        recommendationManager.recommendBooksByAuthor("P101","Central");
        recommendationManager.recommendBooksByGenre("P101","Central");

    }
}