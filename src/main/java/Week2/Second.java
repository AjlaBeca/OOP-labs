package Week2;
import java.util.Scanner;
public class Second{
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int sum=0;
        // don't really need read, now do i
        System.out.print("Type in the first number:");
        sum+=Integer.parseInt(input.nextLine());
        System.out.print("Type in the second number:");
        sum+=Integer.parseInt(input.nextLine());
        System.out.print("Type in the third number:");
        sum+=Integer.parseInt(input.nextLine());
        System.out.println("Sum: "+ sum);

    }}

