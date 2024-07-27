package com.airtribe.library;

import com.airtribe.book.Book;
import com.airtribe.branches.Branch;
//import com.airtribe.library.notifications.PatronObserver;
//import com.airtribe.library.notifications.ReservationNotifier;
import com.airtribe.patron.Patron;

public class LendingManager {
    private LibraryManagementSystem LMS;
//    private ReservationNotifier notifier;

    public LendingManager(LibraryManagementSystem librarySystem) {
        this.LMS = librarySystem;
//        this.notifier= new ReservationNotifier();
    }

    //**Lending/Return Management**
    public boolean checkout(String bookID, String PID, String branchName){
        Branch branch= LMS.getBranchByBranchName(branchName);
        Patron patron= LMS.getPatronById(PID);
        if (branch == null || patron == null){
            System.out.println("Branch or Patron does not exist");
            return false;
        }
        Book book = branch.getInventory().getBookById(bookID);
        if(book == null){
            System.out.println("Book does not exist in this branch");
            return false;
        }
        if(book.isBorrowed()){
            System.out.println("Book is already borrowed");
            return false;
        }
        book.setBorrowed(true);
        patron.borrowBook(book);
        System.out.println("Checkout Successful");

        return true;
    }

    public boolean returnBook(String bookId, String PID, String branchName){
        Branch branch= LMS.getBranchByBranchName(branchName);
        Patron patron= LMS.getPatronById(PID);
        if (branch == null || patron == null){
            System.out.println("Branch or Patron does not exist");
            return false;
        }

        for (Book book: patron.getBorrowedBooks()){
            if(book.getBookID().equals(bookId)){
                book.setBorrowed(false);
                patron.returnBook(book);
                System.out.println(" Book successfully returned");

                //check for reservation to notify
//                if (LMS.getReservations().containsKey(bookId) && !LMS.getReservations().get(bookId).isEmpty()){
//                    String nextPatronId= LMS.getReservations().get(bookId).removeFirst();
//
//                    Patron nextPatron= LMS.getPatronById(nextPatronId);
//                    if (nextPatron != null){
//                        notifier.registerObserver(new PatronObserver(nextPatron));
//                        notifier.notifyObserver(book);
//                        notifier.removeObserver(new PatronObserver(nextPatron));
//                    }
//                }
                if (LMS.getReservations().containsKey(bookId) && !LMS.getReservations().get(bookId).isEmpty()) {
                    String nextPatronId = LMS.getReservations().get(bookId).removeFirst();  // Get the first reservation
                    Patron nextPatron = LMS.getPatronById(nextPatronId);
                    if (nextPatron != null) {
                        System.out.println("Notification sent to ["+patron.getPID()+", "+patron.getName()+"]: Book {"+book.getBookID()+", "+book.getTitle()+"}  is now available for borrow.");

                    }
                }

                return true;
            }
        }

        System.out.println("BookId invalid");
        return false;
    }
}
