package Week6;
import java.util.ArrayList;
import java.util.List;
public class Generics {
    public static <T extends Number> void calculateSums(List<T> numbers) {

        int sumEven = 0;
        int sumOdd = 0;

        for (T number : numbers) {
            int value = number.intValue();
            if (value % 2 == 0) {
                sumEven += value;
            } else {
                sumOdd += value;
            }
        }

        System.out.println("Sum of even numbers: " + sumEven);
        System.out.println("Sum of odd numbers: " + sumOdd);
    }

    public static <T> List<T> reverseList(List<T> inputList) {
        List<T> reversedList = new ArrayList<T>();
        for (int i = inputList.size() - 1; i >= 0; i--) {
            reversedList.add(inputList.get(i));
        }
        return reversedList;
    }


    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubleList = List.of(1.5, 2.0, 3.5, 4.0, 5.5);
        List<String> stringList=List.of("apple", "cherry", "banana", "kiwi");

        //Task 1
        calculateSums(integerList);
        calculateSums(doubleList);
        System.out.println("---");

        //Task 2
        List<Integer> reversedIntegerList = reverseList(integerList);
        List<String> reversedStringList = reverseList(stringList);

        System.out.println("Original Integer List: " + integerList);
        System.out.println("Reversed Integer List: " + reversedIntegerList);

        System.out.println("Original String List: " + stringList);
        System.out.println("Reversed String List: " + reversedStringList);

    }
}
