package com.airtribe.library.recommendation;

import com.airtribe.book.Book;
import com.airtribe.book.BookGenre;
import com.airtribe.branches.Branch;
import com.airtribe.patron.Patron;

import java.util.HashSet;
import java.util.Set;

public class RecommendByGenre implements com.airtribe.library.recommendation.RecommendationStrategy {
    @Override
    public Set<Book> recommendBooks(Patron patron, Branch branch) {
        Set<Book> recommendations = new HashSet<>();
        for (BookGenre genre : patron.getFavouriteGenres()) {
            for (Book book : branch.getInventory().getBooksList()) {
                if (!book.isBorrowed() && book.getGenre().equals(genre) && !patron.hasBookInBorrowingHistory(book)) {
                    recommendations.add(book);
                }
            }
        }
        return recommendations;
    }
}
