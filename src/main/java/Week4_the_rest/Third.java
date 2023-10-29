package Week4_the_rest;
class Person{
    private int age;
    private String country;

    public Person(int age, String country){
        this.age=age;
        this.country=country;
    }
    public int getAge() {
        return age;
    }

    public String getCountry(){
        return country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
public class Third {

    public static void main(String[] args) {
        Person person = new Person(19, "Bosnia and Hezegovina");
        System.out.println("Age: "+person.getAge()+"\nCountry: "+person.getCountry());

        person.setAge(20);
        person.setCountry("Croatia");

        System.out.println("\nAge: "+person.getAge()+"\nCountry: "+person.getCountry());
    }
}
