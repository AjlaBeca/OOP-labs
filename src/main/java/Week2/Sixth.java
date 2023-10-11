package Week2;
import java.util.Scanner;
public class Sixth{
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("How many times should the text be printed:");
        int n=Integer.parseInt(input.nextLine());
        printText(n);
    }

    public static void printText(int n){
        int i=0;
        while(i!=n) {
            System.out.println("In the beginning there were a swamp, the hoe and Java.");
            i++;
        }
    }}

