package com.airtribe.library;

import java.util.ArrayList;

public class ReservationManager {
    private LibraryManagementSystem LMS;

    public ReservationManager(LibraryManagementSystem LMS) {
        this.LMS = LMS;
    }

    public void reserveBook(String bookID, String PID){
        LMS.getReservations().putIfAbsent(bookID,new ArrayList<>());
        LMS.getReservations().get(bookID).add(PID);
        System.out.println("Book ID:"+bookID+ " reserved for Patron ID:"+PID);
    }
}
