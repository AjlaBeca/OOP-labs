package Week4_the_rest;

enum FillType{
    FILLED,
    NOT_FILLED
}
class Shape{
    private String color;
    private FillType fillType;

    public Shape(String color, FillType fillType){
        this.color=color;
        this.fillType=fillType;
    }
    public void displayInfo(){
        System.out.println("Color: "+color);
        System.out.println("Fill type: "+ fillType);
    }
    public double getArea(){
        return 0;
    }
}
class Circle extends Shape {
    private double radius;

    public Circle(String color, FillType fillType, double radius) {
        super(color, fillType);
        this.radius = radius;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double calculateCircumference() {
        return 2 * radius * Math.PI;
    }
    public double calculateCircumference(double PI) {
        return 2 * radius * PI;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(String color, FillType fillType, double width, double height){
        super(color, fillType);
        this.width=width;
        this.height=height;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Width: "+ width);
        System.out.println("Height: "+height);
        System.out.println("Area: "+getArea());
    }
    @Override
    public double getArea(){
        return 2*width+2*height;
    }
}


public class Second {
    public static void main(String[] args) {

        Circle circle = new Circle("Red", FillType.FILLED, 5.0);
        circle.displayInfo();

        System.out.println();

        System.out.println("Circumference (with custom PI): " + circle.calculateCircumference(3.14));
        System.out.println("Circumference (with constant PI): " + circle.calculateCircumference());

        System.out.println();

        Rectangle rectangle = new Rectangle("Blue", FillType.NOT_FILLED, 4.0, 6.0);
        rectangle.displayInfo();
    }
}
