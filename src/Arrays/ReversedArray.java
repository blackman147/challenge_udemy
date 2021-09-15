package Arrays;

import java.util.Arrays;

public class ReversedArray {
    public static void reverse(int [] array){
        int maxLength = array.length-1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];
            array[i] = array[maxLength -i];
            array[maxLength -i] = temp;
        }
    }

    public static void main(String[] args) {
        int [] array = {1, 5, 6, 8, 9, 0, 7};
        System.out.println("Array = " + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array = " + Arrays.toString(array));

    }
}
