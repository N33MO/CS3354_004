package Module1.JavaProgramExample;

import java.util.Scanner;

public class ConsoleIOExample {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Please enter a fruit: ");

        // Read a line of text from the user
        String fruit = scanner.nextLine();

        // Display text in console
        System.out.println("You have entered: " + fruit + ".");

        // Close the scanner to release the resource
        scanner.close();

    }
}

