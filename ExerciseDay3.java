
import java.util.ArrayList;
import java.util.List;

/*
1. Add a List<Book> books to Author too, representing the books an 
author has written. Do not create a two-way link back from Book to 
the list on Author unless you also add the Book to it explicitly. 
Adding a Book to a Library does not automatically add it to the 
Author's list; these are separate object graphs unless you write 
code to keep them in sync. 

2. Add a static field Library.totalBooksAdded that increments every 
time addBook is called across the whole Library class, not per 
instance. Create two separate Library objects, add books to each, 
and prove whether the counter is shared or separate. Predict the 
answer before running it.
*/

class Author
{
    String name;
    List<Book> books;

    Author(String name)
    {
        this.name = name;
        books = new ArrayList<>();
    }

    void addBooks(Book book)
    {
        books.add(book);
    }

    void displayBooks()
    {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<books.size(); i++)
        {
            result.append(books.get(i).title);

            if(i < books.size() - 1)
            {
                result.append(",");
            }
        }

        System.out.println("The books written by " + name + " are: ");
        System.out.println(result);
    }

}
class Book
{   
    String title;
    Author author;

    Book(String title, Author author)
    {
        this.title = title;
        this.author = author;
    }
    
    // Constructor chaining
    Book(String title) {
        this(title, new Author("Unknown"));   // delegates to the constructor above
    }
}

class Library
{
    List<Book> books;
    static int totalBooksAdded = 0;

    Library()
    {
        books = new ArrayList<>();
    }

    void addBooks(Book book)
    {
        books.add(book);
        totalBooksAdded += 1;
    }

    void displayBooks()
    {
        for(int i =0; i< books.size(); i++)
        {
            Book book = books.get(i);
            System.out.println("Title of Book: " + book.title + " by: " + book.author.name);
        }
    }
}
public class ExerciseDay3 {

    static void PrintLibraryBooks(Library library)
    {
        // List<Book> books = new ArrayList<>();

        // books = library.books;

        for(int i = 0; i < library.books.size(); i++)
        {
            Book book = library.books.get(i);
            // the three-hop traversal:

            System.out.println("The title of book: " + book.title + " by: " + book.author.name + " (this author has written) " + book.author.books.size());

        }
    }

    public static void main(String[] args)
    {
        // Creating author object and adding title
        Author author1 = new Author("Kafka");
        Author author2 = new Author("Yuval Noah Harari");

        Author author3 = new Author("Harper Lee");
        Author author4 = new Author("George Orwell");
        Author author5 = new Author("F. Scott Fitzgerald");


        // Books object 
        Book book1 = new Book("The Metamorphosis", author1);
        Book book2 = new Book("The Trial ", author1);
        Book book3 = new Book("The Castle", author1);

        Book book4 = new Book("Sapiens: A Brief History of Humankind", author2); 
        Book book5 = new Book("Homo Deus: A Brief History of Tomorrow", author2); 
        Book book6 = new Book("21 Lessons for the 21st Century", author2);

        Book book7 = new Book("To Kill a Mockingbird", author3);
        Book book8 = new Book("1984", author4);
        Book book9 = new Book("The Great Gatsby", author5);

        // Added Books in Author
        author1.addBooks(book1);
        author1.addBooks(book2);
        author1.addBooks(book3);

        author2.addBooks(book4);
        author2.addBooks(book5);
        author2.addBooks(book6);


        // Creating library object
        Library library = new Library();
        Library library2 = new Library();

        // adding books in library
        library.addBooks(book1);
        library.addBooks(book2);
        library.addBooks(book3);

        library.addBooks(book4);
        library.addBooks(book5);
        library.addBooks(book6);

        library.addBooks(book7);
        library.addBooks(book8);
        library.addBooks(book9);

        library2.addBooks(book7);
        library2.addBooks(book8);
        library2.addBooks(book9);

        // First let us see that which are the books the author has written

        author1.displayBooks();
        author2.displayBooks();

        // We have already added books in Library, let us see what are the books available in the Library

        library.displayBooks();

        library.books.remove(book1);
        System.out.println("Library book count after removal: " + library.books.size());
        System.out.println("Author1 book count (should be unaffected): " + author1.books.size());

        // The static counter in the library will be shared totalBooksAdded
        System.out.println("The total books added is: " + Library.totalBooksAdded);
        // System.out.println("Via library: " + library.totalBooksAdded);   // legal, but misleading style
        // System.out.println("Via library2: " + library2.totalBooksAdded); 

        // Constructor chaining, creating a book constructor that will contain an unknow author

        Book bookUn = new Book("Unknon");
        System.out.println("After constructor chaining " + bookUn.author.name);


        // calling PrintLibraryBooks function fourth exercise
        PrintLibraryBooks(library);

    }
    
}
