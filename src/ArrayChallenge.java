import java.util.Arrays;
import java.util.Scanner;

public class ArrayChallenge {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int [] myInteger = getInteger(5);
        int [] newArray = sortedArray(myInteger);
        printArray(newArray);

    }

    public static int[] getInteger(int number){
        System.out.println("Enter " + number + " values");
        int [] values = new int[number];
        for (int i = 0; i < values.length; i++) {
            values[i] = scan.nextInt();
        }
        return values;
    }

    public static void printArray(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element in "+ i + " value is : "+ array[i]);
        }
    }

    public static int [] sortedArray(int [] array){
//        int[] newArray = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
        int [] newArray = Arrays.copyOf(array, array.length);
        int temp = 0;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length ; j++) {
                if (newArray[i] < newArray[j]){
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }

}
