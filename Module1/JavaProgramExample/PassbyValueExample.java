package Module1.JavaProgramExample;

public class PassbyValueExample {
    public static void main(String[] args) {
        // initialize an array
        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; ++i) myArray[i] = i;
        // print the array
        for (int num : myArray) System.out.print(num + ", ");
        System.out.println();

        // update the array and print
        incrementArr(myArray);
        for (int num : myArray) System.out.print(num + ", ");
        System.out.println();

        // redirect the array and print
        redirectArr(myArray);
        for (int num : myArray) System.out.print(num + ", ");
        System.out.println();

    }

    public static void incrementArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) ++arr[i];
    }

    public static void redirectArr(int[] arr) {
        arr = new int[10];
        for (int i = 0; i < arr.length; ++i) arr[i] = 3;
    }
}
