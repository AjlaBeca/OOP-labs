package Week7;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
record Book(String title, String author, int publicationYear, boolean availabilityStatus){

    @Override
    public String toString(){
        return "\nTitle: "+title()+"\nAuthor: "+author()+"\nPublication year: "+publicationYear();
    }
}
class LibraryCatalog{
    private List<Book> books;
    public LibraryCatalog(List<Book> books){
        this.books=new ArrayList<>(books);
    }

    public Optional<Boolean> isBookAvailable(String title) {
        return books.stream()
                .filter(book -> book.title().equals(title))
                .map(Book::availabilityStatus)
                .findFirst();
    }

    public Optional<Book> FirstAvailableBook(String author){
        return books.stream()
                .filter(book -> book.author().equals(author) && book.availabilityStatus())
                .findFirst();
    }

    public Optional<Book> updateBookAvailability(String title, boolean availabilityStatus){
        return books.stream()
                .filter(book -> book.title().equals(title))
                .findFirst()
                .map(book -> new Book(book.title(), book.author(), book.publicationYear(),availabilityStatus));
    }

}

public class LibraryCatalogSystem {

    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog(List.of(
                new Book("These Hollows Vows", "Lexy Ryan", 2021, true),
                new Book("The Bridge Kingdom", "Danielle L. Jensen", 2019, false),
                new Book("The Darkening", "Sunya Mara", 2022, true),
                new Book("The Prison Helaer", "Lynette Noni", 2021, false),
                new Book("The Gilded Cage", "Lynette Noni", 2021, true)));

        //a) checking if book is available
        Optional<Boolean> availability = libraryCatalog.isBookAvailable("The Darkening");
        availability.ifPresent(availabilityStatus -> System.out.println("\nIs The Darkening available? "+availabilityStatus));

        //b) retrieving the details of the first available book by a specific author
        Optional<Book> details = libraryCatalog.FirstAvailableBook("Danielle L. Jensen");
        details.ifPresent(book -> System.out.println("\nFirst available book by Danielle L. Jensen: "+ book));

        Optional<Book> details2 = libraryCatalog.FirstAvailableBook("Lynette Noni");
        details2.ifPresent(book -> System.out.println("\nFirst available book by Lynette Noni is "+ book));

        //c) update the availability status of a book
        Optional<Book> updatedBook = libraryCatalog.updateBookAvailability("These Hollows Vows", false);
        updatedBook.ifPresent(book -> System.out.println("\nUpdated availability of THV is now "+book.availabilityStatus()));


    }

}
