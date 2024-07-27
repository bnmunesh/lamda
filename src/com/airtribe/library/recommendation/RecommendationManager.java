package com.airtribe.library.recommendation;

import com.airtribe.book.Book;
import com.airtribe.branches.Branch;
import com.airtribe.library.LibraryManagementSystem;
import com.airtribe.patron.Patron;

import java.util.HashSet;
import java.util.Set;

public class RecommendationManager {
    private LibraryManagementSystem LMS;

    public RecommendationManager(LibraryManagementSystem LMS) {
        this.LMS = LMS;
    }

    public void recommendBooksByAuthor(String PID, String branchName) {
        recommendBooks(PID, branchName, new RecommendByAuthor());
    }

    public void recommendBooksByGenre(String PID, String branchName) {
        recommendBooks(PID, branchName, new RecommendByGenre());
    }

    private void recommendBooks(String PID, String branchName, com.airtribe.library.recommendation.RecommendationStrategy strategy) {
        Patron patron = LMS.getPatronById(PID);
        Branch branch = LMS.getBranchByBranchName(branchName);

        if (patron != null && branch != null) {
            Set<Book> recommendations = strategy.recommendBooks(patron,branch);

            System.out.println("Recommendations for ["+PID+", "+patron.getName()+"]:");
            for (Book book: recommendations)
                System.out.println(book);
        }
        else
            System.out.println("Patron or Branch does not exist.");
    }
}
