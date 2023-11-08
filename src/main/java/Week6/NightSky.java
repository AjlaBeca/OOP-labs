package Week6;

import java.util.Random;

public class NightSky{
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;

    public NightSky(double density){
        this(density,20,10);
    }

    public NightSky(int width, int height){
        this(0.1,width,height);
    }

    public NightSky(double density, int width, int height){
        this.width=width;
        this.height=height;
        this.density=density;
        this.starsInLastPrint=0;
    }

    public void printLine(){
        int starsOnThisLine=0;
        Random random = new Random();
        for(int i=0; i<width; i++) {
            double rand = random.nextDouble();

            if (rand < this.density) {
                System.out.print("*");
                starsOnThisLine++;
            }
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
        this.starsInLastPrint+=starsOnThisLine;
    }

    public void print(){
        for(int i=0; i<height; i++){
            printLine();
            System.out.println();
        }
    }

    public int starsInLastPrint(){
        return this.starsInLastPrint;
    }

    public static void main(String[] args) {

        NightSky NightSky = new NightSky(0.1,40,10);
        NightSky.print();
        System.out.println("Number of stars: "+NightSky.starsInLastPrint());
        System.out.println("");

        NightSky = new NightSky(0.2,15,6);
        NightSky.print();
        System.out.println("Number of stars: "+NightSky.starsInLastPrint());
    }

}
