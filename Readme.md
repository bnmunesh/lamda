# <u>Library Management System</u>

# <u>Overview</u>

This Library Management System (LMS) manages books, patrons, and branches within a library. It allows for operations like book lending, returning, and searching. The system also includes features for recommending books based on patron preferences. 

The project tries to follow OOP's concepts, SOLID principles and some design patterns.

### Separate Manager Classes:

- **Single Responsibility Principle**: Each manager class has a clear responsibility, making the code easier to understand and maintain.
- **Separation of Concerns**: Each manager handles a specific part of the system, making it easy to modify one part without affecting others.
- **Flexibility**: Different managers can be tested and developed independently.

# <u>Design Patterns</u>

### Singleton Pattern

- **LibraryManagementSystem**:  The use of the Singleton pattern ensures that there is only one instance of the entire library system, which centralizes the management of branches, patrons, inventory, and lending.

### Strategy Pattern

- **RecommendationStrategy**: Defines a family of algorithms for recommending books. Implemented by:
    - **RecommendByAuthor**: Recommends books based on favorite authors.
    - **RecommendByGenre**: Recommends books based on favorite genres.

# <u>Classes</u>

### `Book`

Represents a book with attributes like ID, title, author, ISBN, genre(BookGenre enum), and publication year. It also tracks whether the book is borrowed(isBorrowed attributes).

### `Patron`

Represents a library patron. Tracks borrowed books, borrowing history, favorite genres, and favorite authors.

### `Branch`

Represents a library branch containing book inventory and search capabilities. Manages book transfers between branches. It is composed of BrnachDetails, BookInventory and SearchService classes

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

# <u>Main Operations</u>

### Book Operations
* **Add Book**: Add new books to the inventory.
* **Remove Book**: Remove books from the inventory.
* **Update Book**: Update book details in the inventory.
* **Search Book**: Search for books by title, author, or ISBN.

### Patron Operations
* **Add Patron**: Add new patrons to the system.
* **Remove Patron**: Remove patrons from the system.
* **Update Patron**: Update patron details.

### LibrarySystem Operations:
### 1. Branch Operations
* **Add Branch**: Add new branches to the system.
* **Remove Branch**: Remove branches from the system.
* **Transfer Book**: Transfer books between branches.

### 2. Lending Operations
* **Checkout Book**: Check out books to patrons.
* **Return Book**: Return books to branches.

### 3. Recommendation Operations
* **Recommend Books**: Recommend books to patrons based on their preferences(byGenre or byAuthor).

### 5. Reservation Operations
* **Recommend Books**: Allows patrons to reserve a already borrowed book. And a notification would be sent to patron when the book is returned saying "its now available for borrow".

### 4. Inventory Operations

# <u>Improvements/Functionalities Not Addressed Yet</u>

* The lending process lacks functionalities such as due dates and borrowing dates.
* The return process does not check the borrowing date and due date to calculate fines.
* The reservation and notification system is not foolproof and requires further improvements in the algorithm/business logic.
 

# <u>Class Diagram</u>
![Library Management System Class Diagram](/resources/class%20diagram.jpeg)



# <u>Contribution</u>
Feel free to fork the repository and submit pull requests with improvements or bug fixes.

 
#### Munesh Kumar B N

