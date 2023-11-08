package Week6;
import java.util.ArrayList;

class Library{
    private ArrayList<Book> books;
    public Library(){
        this.books=new ArrayList<Book>();
    }

    public void addBook(Book newBook){
        books.add(newBook);
    }
    public void printBooks(){
        for(Book book: books){
            System.out.println(book);
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book book: books){
            if(StringUtils.included(book.title(),title)){
                found.add(book);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book book: books){
            if(StringUtils.included(book.publisher(),publisher)){
                found.add(book);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<Book>();
        for(Book book: books){
            if(year==book.year()){
                found.add(book);
            }
        }
        return found;
    }
}

class StringUtils{
    public static boolean included(String word, String searched){
        if(word==null || searched==null){
            return false;
        }

        word=word.trim().toUpperCase();
        searched=searched.trim().toUpperCase();
        return word.contains(searched);
    }
}

public class Book {

    private String title;
    private String publisher;
    private int year;

    public Book(String title, String publisher, int year){
        this.title=title;
        this.publisher=publisher;
        this.year=year;
    }

    public String title(){
        return title;
    }
    public String publisher(){
        return publisher;
    }
    public int year(){
        return year;
    }

    @Override
    public String toString() {
        return title+", "+publisher+", "+year;
    }

    public static void main(String[] args) {
        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
        System.out.println(cheese.title());
        System.out.println(cheese.publisher());
        System.out.println(cheese.year());
        System.out.println(cheese);

        Library Library = new Library();
        Library.addBook(cheese);
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));
        Library.addBook(new Book("The Stinky Cheese Man and the Other Fairly Stupid Tales", "Penguin Group", 1992));
        System.out.println("---");
        Library.printBooks();

        System.out.println("---");
        for(Book book: Library.searchByPublisher("Penguin Group  ")){
            System.out.println(book);
        }

        System.out.println("---");
        for(Book book: Library.searchByYear(1851)){
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book: Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }

        System.out.println("---");
        for (Book book: Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }

    }


}

