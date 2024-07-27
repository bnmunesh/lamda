package com.airtribe.library.recommendation;

import com.airtribe.book.Book;
import com.airtribe.branches.Branch;
import com.airtribe.patron.Patron;

import java.util.Set;

public interface RecommendationStrategy {
    Set<Book> recommendBooks(Patron patron, Branch branch);
}
