# Library Management System

## Overview

This Library Management System (LMS) manages books, patrons, and branches within a library. It allows for operations like book lending, returning, and searching. The system also includes features for recommending books based on patron preferences.

## Design Patterns

### Singleton Pattern

- **LibraryManagementSystem**: Ensures a single instance of the library management system is used throughout the application.

### Strategy Pattern

- **RecommendationStrategy**: Defines a family of algorithms for recommending books. Implemented by:
    - **RecommendByAuthor**: Recommends books based on favorite authors.
    - **RecommendByGenre**: Recommends books based on favorite genres.

## Classes

### `Book`

Represents a book with attributes like ID, title, author, ISBN, genre, and publication year. It also tracks whether the book is borrowed.

### `Patron`

Represents a library patron. Tracks borrowed books, borrowing history, favorite genres, and favorite authors.

### `Branch`

Represents a library branch containing book inventory and search capabilities. Manages book transfers between branches.

### `BranchDetails`

Stores details about a branch, including its name and address.

### `BookInventory`

Manages the inventory of books in a branch. Supports adding, removing, updating, and transferring books.

### `SearchService`

Provides search functionality for books based on title, author, and ISBN.

### `LibraryManagementSystem`

Manages branches, patrons, and reservations. Provides operations for adding, removing, and transferring branches and books.

### `PatronManager`

Handles operations related to patrons, such as adding, removing, and updating patron details.

### `LendingManager`

Manages book lending and returning. Handles notifications for reservations when books are returned.

### `InventoryManager`

Provides methods to display available and borrowed books in a branch.

### `RecommendationStrategy` (Interface)

Defines the strategy for recommending books based on patron preferences.

### `RecommendByAuthor`

Recommends books based on the patron's favorite authors.

### `RecommendByGenre`

Recommends books based on the patron's favorite genres.

### `RecommendationManager`

Manages book recommendations using different strategies.

## Class Diagram

