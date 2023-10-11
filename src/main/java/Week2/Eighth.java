package Week2;
import java.util.Scanner;
public class Eighth {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        drawStarsPyramid(5);
        System.out.println();
        drawStarsPyramidInversed(5);

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
    public static void drawStarsPyramidInversed(int rows){
        int i=rows;
        while(i!=0){
            int j=i;
            while(j>0){
                System.out.print("*");
                j--;
            }
            System.out.println();
            i--;
        }
    }
}

