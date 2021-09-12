package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {
    private static Scanner scan = new Scanner(System.in);

    public static int[] readIntegers(int counter){
        int[] values = new int[counter];
        for (int i = 0; i < values.length; i++) {
            System.out.println("Enter a number");
            values[i] = scan.nextInt();
            scan.nextLine();
        }
        return values;
    }

    public static int findMin(int[] array){
        int[] newArray = Arrays.copyOf(array, array.length);
        Arrays.sort(newArray);
        return newArray[0];
    }

    public static void main(String[] args) {
        int[] myArray = readIntegers(5);
        System.out.println( myArray);
        int newArray = findMin(myArray);
        System.out.println("the minimum value in the array is: " + newArray);

    }
}
