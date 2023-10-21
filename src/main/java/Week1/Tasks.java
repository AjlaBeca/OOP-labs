package Week1;
import java.util.Scanner;
public class Tasks {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //TASK 1
        System.out.println("Jane Doe");
        //TASK 2
        System.out.println("Hello world!");
        System.out.println("(And all the people in the world");

        //TASK 3
        System.out.println("There are "+365*24*60*60+" seconds in a year.");

        //TASK 4
        System.out.println("Type a number:");
        int a=input.nextInt();
        System.out.println("Type another number:");
        int b=input.nextInt();
        System.out.println("Sum of the numbers: "+(a+b));

        //TASK 5
        System.out.println("Type a number: ");
        int c=input.nextInt();
        if(c>0){
            System.out.println("Number is positive.");
        }
        else{
            System.out.println("Number is not positive.");
        }

        //TASK 6
        System.out.println("Type the first number: ");
        int d=input.nextInt();
        System.out.println("Type the second number: ");
        int e= input.nextInt();
        if(e==d){
            System.out.println("The numbers are equal.");
        }
        else{
            int bigger=(d>e)?d:e;
            System.out.println("Greater number: "+bigger);
        }
    }
}
