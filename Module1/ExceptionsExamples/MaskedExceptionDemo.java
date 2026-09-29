package Module1.ExceptionsExamples;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MaskedExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("inputDemo.txt"));
            int num = sc.nextInt(); // 5
            int den = sc.nextInt(); // 0
            int val = num / den;
            System.out.println("Val: " + val);
            pw = new PrintWriter("output.txt");
            pw.println("result = " + val);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e); 
        } catch (ArithmeticException e) {
            throw new RuntimeException(e);
        }
        finally {
            sc.close();
            pw.close();
        }
    }
}
