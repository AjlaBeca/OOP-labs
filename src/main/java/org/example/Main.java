package org.example;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
         Scanner input = new Scanner (System.in);
         String password="idk";
         System.out.println("Type in the password:");
         String p = input.nextLine();
         while(!p.equals(password)){
             System.out.println("Wrong, sorry.");
             p = input.nextLine();
         }
        System.out.println("Finally!");
        System.out.println("The secret is: I've got shoes on.");

        int sum=0;
        int read;
        System.out.print("Type in the first number:");
        sum+=parseInt(input.nextLine());
        System.out.print("Type in the second number:");
        sum+=parseInt(input.nextLine());
        System.out.print("Type in the third number:");
        sum+=parseInt(input.nextLine());
        System.out.println("Sum: "+ sum);

        int sum2=0;
        while(true){
            read = Integer.parseInt(input.nextLine());
            if(read==0){
                break;
            }
            sum2+=read;
            System.out.println("Sum now:"+sum2);
        }

        System.out.println("Sum at the end:"+sum2);

        System.out.print("First:");
        int a=Integer.parseInt(input.nextLine());
        System.out.print("Second:");
        int b=Integer.parseInt(input.nextLine());
        while(a!=b){
            if (a==b-1 || a>b){
                break;
            }
            else{
                System.out.println(++a);
            }
        }
        System.out.print("Type in a number:");
        int n=Integer.parseInt(input.nextLine());
        int i=0;
        sum=0;
        while(i!=n+1){
            sum+=(int)Math.pow(2,i);
            i++;
        }
        System.out.println("The result is:"+sum);

        System.out.print("How many times should the text be printed:");
        int n1=Integer.parseInt(input.nextLine());
        printText(n1);

        printStars(5);
        printStars(3);
        printStars(9);

        drawStarsPyramid(5);

        drawStarsNumbers(5);

        int number = 1 + (int)(100 * Math.random());
        int c=-1;
        int count=0;
        while(number!=c){
            System.out.println("Guess a number:");
            c=input.nextInt();
            if(c<number){
                System.out.println("The number is greater, guesses made: "+(++count));
            }
            else if(c>number){
                System.out.println("The number is lesser, guesses made: " +(++count));
            }
        }
        System.out.println("Congratulations, your guess is correct!");
    }
    private static void printStars(int amount){
        int i=0;
        while(i<amount){
            System.out.print("*");
            i++;
        }
        System.out.println();
    }
    public static void printText(int n){
        int i=0;
        while(i!=n) {
            System.out.println("In the beginning there were a swamp, the hoe and Java.");
            i++;
        }
    }

    public static void drawStarsPyramid(int rows){
        int i=0;
        while(i!=rows){
            int j=0;
            while(j<=i){
            System.out.print("*");
            j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void drawStarsNumbers(int rows){
        int i=1;
        while(i!=rows+1){
            int j=1;
            while(j<=i){
                System.out.print(j);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}