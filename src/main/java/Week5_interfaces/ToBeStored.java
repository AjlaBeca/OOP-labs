package Week5_interfaces;
public interface ToBeStored
{
    double weight();
}
class Book implements ToBeStored{
    private String writer;
    private String name;
    private double weight;

    public Book(String writer, String name, double weight){
        this.writer=writer;
        this.name=name;
        this.weight=weight;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.writer+": "+ this.name;
    }
}
class CD implements ToBeStored{
    private String artist;
    private String title;
    private int year;
    private static final double weight = 0.1;

    public CD(String artist, String title, int year){
        this.artist=artist;
        this.title=title;
        this.year=year;
    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return artist+": "+title+" ("+year+")";
    }
}
class Box{
    private double maximumWeight;
    private double currentWeight;
    private int itemCount;

    public Box(double maximumWeight){
        this.maximumWeight=maximumWeight;
        this.currentWeight=0;
        this.itemCount=0;
    }

    public void add(ToBeStored item){
        if(currentWeight+item.weight()<=maximumWeight){
            currentWeight+=item.weight();
            itemCount++;
        }
    }

    @Override
    public String toString() {
        return "\nBox: "+itemCount+" things, total weight "+currentWeight+" kg";
    }
}
class MainFunction {
    public static void main(String[] args) {
        Box box = new Box(10.0);

        Book book1=new Book("Fedor Dostojevski", "Crime and Punishment", 2);
        Book book2=new Book("Robert Martin", "Clean Code", 1);
        Book book3=new Book("Kent Beck", "Test Driven Development", 0.7);

        CD cd1=new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2=new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3=new CD("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);

        box.add(book1);
        box.add(book2);
        box.add(book3);

        box.add(cd1);
        box.add(cd2);
        box.add(cd3);

        System.out.println(box);
    }
}
