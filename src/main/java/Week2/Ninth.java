package Week2;
import java.util.Scanner;
public class Ninth {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        drawStarsNumbers(5);
        System.out.println();
        drawStarsNumbersDiff(5);

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
    public static void drawStarsNumbersDiff(int rows){
        int i=1;
        while(i!=rows+1){
            int j=1;
            while(j<=i){
                System.out.print(i);
                j++;
            }
            System.out.println();
            i++;
        }
    }}


