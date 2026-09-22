package Module1.JavaProgramExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program reads a file with number, and writes the numbers to another
 * file, lined up in a column and followed by their total.
 */
public class FileIOExample {
    public static void main(String[] args) throws FileNotFoundException {
        // Setup for the input and output
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String iFileName = console.next();
        System.out.print("Output file: ");
        String oFileName = console.next();

        File iFile = new File(iFileName);
        Scanner in = new Scanner(iFile);
        PrintWriter out = new PrintWriter(oFileName);

        // Read the input and write the output
        double total = 0;
        while (in.hasNextDouble()) {
            double value = in.nextDouble();
            out.printf("%15.2f%n", value);
            total += value;
        }

        out.printf("Total: %8.2f%n", total);
        System.out.println("Process Complete!");

        // console.nextLine();
        // System.out.print("Press enter to continue...");
        // console.nextLine();

        console.close();
        in.close();
        out.close();
    }

}
