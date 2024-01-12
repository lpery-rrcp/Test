package com.lance.library

class Library {
    var books: MutableList<Book> = mutableListOf<Book>();

    // methods
    fun addBook(book: Book){
        books.add(book);
    }

    fun removeBook(title: String){
        var removedBook = books.find { it.title == title };
        if(removedBook != null){
            books.remove(removedBook);
        }
        else{
            println("There is no ${removedBook} from this library.");
        }
    }

    fun displayAvailableBooks(){
        for(book in books){
            if(book.isAvailable){
                println("${book.title} is available.")
            }
        }
    }

}
// Functional

fun borrowBook(library: Library, title: String){
    var borrowedBook = library.books.find{it.title == title};

    if(borrowedBook != null){
        if(borrowedBook.isAvailable) {
            borrowedBook.isAvailable = false;
            println("${borrowedBook.title} is now borrowed.");
        }
        else{
            println("${borrowedBook.title} is unavailable. Sorry.")
        }
    } else {
        println("{$borrowedBook.title} is not found in the library.")
    }
}

fun getAvailableBooksCountByAuthor(library: Library, author: String): Int{
    return library.books.count { it.author == author && it.isAvailable};
}

fun main(){
    var book1 = Book("hello", "Bakerman", 4.5);
    var book2 = Book("Catching Fire", "J.K.R", 1.25);
    var book3 = Book("Harry Potter", "Harry", 2.45);
    var book4 = Book("Baking World", "Bakerman", 3.7);

    var library = Library();

    println();
    // Use addBook(book: Book)
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);

    // books originally available
    library.displayAvailableBooks();

    println();
    // borrow second book
    borrowBook(library, "Catching Fire");

    println();
    // books available after borrow
    library.displayAvailableBooks();

    println();
    // getting the count of books available
    var availableBooksByBakerman = getAvailableBooksCountByAuthor(library, "Bakerman");
    println("Books written by Bakerman: {$availableBooksByBakerman}. My fav author.");
}