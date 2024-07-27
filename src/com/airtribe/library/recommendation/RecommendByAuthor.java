package com.airtribe.library.recommendation;

import com.airtribe.book.Book;
import com.airtribe.branches.Branch;
import com.airtribe.patron.Patron;

import java.util.HashSet;
import java.util.Set;

public class RecommendByAuthor implements com.airtribe.library.recommendation.RecommendationStrategy {
    @Override
    public Set<Book> recommendBooks(Patron patron, Branch branch) {
        Set<Book> recommendations = new HashSet<>();
        for (String author : patron.getFavouriteAuthors()) {
            for (Book book : branch.getInventory().getBooksList()) {
                if (!book.isBorrowed() && book.getAuthor().equals(author) && !patron.hasBookInBorrowingHistory(book)) {
                    recommendations.add(book);
                }
            }
        }
        return recommendations;
    }
}