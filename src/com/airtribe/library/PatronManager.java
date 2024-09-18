package com.airtribe.library;

import com.airtribe.patron.Patron;

public class PatronManager {
    private LibraryManagementSystem LMS;

    public PatronManager(LibraryManagementSystem librarySystem) {
        this.LMS = librarySystem;
    }

    public void addPatron(String PID, String name, String Address){
        LMS.getPatrons().add(new Patron(PID, name, Address));
    }
    public void removePatron(String PID){
        Patron patron = LMS.getPatronById(PID);
        LMS.getPatrons().remove(patron);
    }

    //public void updatePatron
    public boolean updatePatron(String PID, Patron updatedPatron){
        Patron patron = LMS.getPatronById(PID);
        if (patron != null){
            patron.setName(updatedPatron.getName());
            patron.setPatronAddress(updatedPatron.getPatronAddress());
            return true;
        }
        return false;
    }
    public void listPatrons() {
        for (Patron patron : LMS.getPatrons())
            System.out.println(patron.getPID());
    }
}
