package Module1.JavaProgramExample;

import java.util.Arrays;

public class MyArrayExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        
        System.out.println("My Array: " + Arrays.toString(arr));

        updateArray(arr);
        System.out.println("Updated Array: " + Arrays.toString(arr));
    }

    public static void updateArray(int[] myArr) {
        int len = myArr.length;
        for (int i = 0; i < len; ++i) {
            myArr[i] += 10;
        }
    }
}
