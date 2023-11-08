package Week6;

import java.util.Scanner;

public class Arrays {

    public static int smallest(int[] array){
        int smallest=array[0];
        for(int i=0; i< array.length; i++){
            if(array[i]<smallest){
                smallest=array[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array){
        int smallest=array[0];
        int index = 0;
        for(int i=0; i< array.length; i++){
            if(array[i]<smallest){
                smallest=array[i];
                index=i;
            }
        }
        return index;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int start){
        int smallest=array[start], index=start;
        for(int i=start; i< array.length; i++){
            if(array[i]<smallest){
                smallest=array[i];
                index=i;
            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2){
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }

    public static void printElegantly(int[] array){
        for(int i=0; i< array.length; i++){
            if(i==array.length-1){
                System.out.print(array[i]);
            }
            else{
                System.out.print(array[i]+", ");
            }
        }
    }

    public static void main(String[] args) {

        //Task 1
        int[] values={6,5,8,7,11};
        System.out.println("Smallest:"+smallest(values));
        //Task 2
        System.out.println("Index of the smallest: "+indexOfTheSmallest(values));
        int[] values2={-1,6,9,8,12};
        //Task 3
        System.out.println(indexOfTheSmallestStartingFrom(values2,1));
        System.out.println(indexOfTheSmallestStartingFrom(values2,2));
        System.out.println(indexOfTheSmallestStartingFrom(values2,4));
        //Task 4
        int[] values3={3,2,5,4,8};
        System.out.println(java.util.Arrays.toString(values3));
        swap(values3,1,0);
        System.out.println(java.util.Arrays.toString(values3));
        swap(values3,0,3);
        System.out.println(java.util.Arrays.toString(values3));
        //Task 5
        int[] array = {-3,2,3,4,7,8,12};
        Scanner input = new Scanner(System.in);
        System.out.println("Values of the array: "+ java.util.Arrays.toString(array));
        System.out.print("Enter searched number: ");
        String searchedValue = input.nextLine();

        boolean result = BinarySearch.search(array, Integer.parseInt(searchedValue));

        if(result){
            System.out.println("Value "+searchedValue+" is in the array.");
        }
        else{
            System.out.println("Value "+searchedValue+" is not in the array.");
        }

        //Task 6
        printElegantly(values);


    }

    class BinarySearch{

        public static boolean search(int[] array, int searchedValue){

            int right=array.length-1, left=0;

            while(left<=right){
                int mid = left +(right-left) / 2;

                if(array[mid]==searchedValue){
                    return true;
                }
                else if(array[mid]<searchedValue){
                    left+=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            return false;
        }
    }
}
