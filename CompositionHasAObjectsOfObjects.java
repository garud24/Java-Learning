/*  Composition: Objects of Objects
A class field does not have to be a primitive or a String; it can be another object you defined:

 */
import java.util.ArrayList;
import java.util.List;
class Author
{
    String name;

    Author(String name) {
        this.name = name;
    }

}

class Book
{
    String title; // Book HAS-A Author: composition
    Author author;

    Book(String title, Author author)
    {
        this.title = title;
        this.author = author;
    }
}
class Library
{
    List<Book> books; // Library HAS-A Book: Composition

    Library() {
        books = new ArrayList<>();
    }

    void addBooks(Book book)
    {
        books.add(book);
    }

    void displayBooks()
    {
        for(int i =0; i< books.size(); i++)
        {
            Book book = books.get(i);
            System.out.println(book.title + " by " + book.author.name);
        }
    }
}
public class CompositionHasAObjectsOfObjects {

    public static void main(String[] args) {
        
        Author author = new Author("Kafka");
        Book book = new Book("Metamorposis", author);

        Author author2 = new Author("Hilary Monahan");
        Book book2 = new Book("Mary: The Summoning by", author2);
        Library library = new Library();

        library.addBooks(book);
        library.addBooks(book2);

        System.out.println("How many books are there in library: ");
        library.displayBooks();
    }
    
}
