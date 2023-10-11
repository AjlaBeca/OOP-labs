package Week2;
import java.util.Scanner;
public class Fourth{
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("First:");
        int a=Integer.parseInt(input.nextLine());
        System.out.print("Second:");
        int b=Integer.parseInt(input.nextLine());
        while(a<b-1){
            if (a>b){
                break;
            }
            else
            {
                System.out.println(++a);
            }
        }

    }}

