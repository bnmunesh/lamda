package com.airtribe.library;

import com.airtribe.branches.Branch;
import com.airtribe.patron.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {
    private static LibraryManagementSystem instance = null;

    private Map<String, Branch> branches;
    private List<Patron> patrons;
    private Map<String,List<String>> reservations;

    private LibraryManagementSystem() {
        this.branches = new HashMap<>();
        this.patrons= new ArrayList<>();
        this.reservations= new HashMap<>();
    }
    public static LibraryManagementSystem getInstance(){
        if (instance == null)
            instance = new LibraryManagementSystem();
        return instance;
    }

    public Map<String, Branch> getBranches() {
        return branches;
    }
    public List<Patron> getPatrons() {
        return patrons;
    }
    public void listPatrons(){
        for (Patron patron: patrons)
            System.out.println(patron.getPID());
    }
    public Map<String, List<String>> getReservations() {
        return reservations;
    }

    public Branch getBranchByBranchName(String branchName){
        return branches.get(branchName);
    }
    public Patron getPatronById(String PID){
        for (Patron patron : patrons) {
            if(patron.getPID().equals(PID))
                return patron;
        }
        System.out.println("Invalid Patron ID");
        return null;
    }
}
