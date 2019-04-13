package algorithmJava;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfIntInputValidator {

    public static Integer[] getInputArrayOfIntegers() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Integer[] inputArray = new Integer[size];
        int index = 0;
        while(index < size) {
            int num = scanner.nextInt();
            inputArray[index ++] = num;
        }
        System.out.println("Array: " + Arrays.toString(inputArray) );
        return inputArray;
    }

}
