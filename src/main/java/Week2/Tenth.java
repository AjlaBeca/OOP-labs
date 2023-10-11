package Week2;
import java.util.Scanner;
public class Tenth {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int number = (int)(100 * Math.random());
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

    }


