package Week2;
import java.util.Scanner;
public class First{
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
        }}
