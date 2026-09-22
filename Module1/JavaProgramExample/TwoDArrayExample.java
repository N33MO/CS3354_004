package Module1.JavaProgramExample;

public class TwoDArrayExample {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] mat) {
        for (int[] arr : mat) {
            for (int num : arr) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
