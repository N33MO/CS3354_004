package Module1.Practice.ZyBookPractices;

import java.util.Scanner;

/**
 * ZyBook 2.8.2 Challenge Activity: Print a table of prices.
 *
 * <p>Reads a unit price and prints a table where the first column has width 8
 * (quantity) and the second column has width 10 (total price), with exactly two
 * digits after the decimal point.</p>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/Practice/ZyBookPractices/Table.java
 * java Module1.Practice.ZyBookPractices.Table
 * </pre>
 */
public class Table
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Unit price: ");
      double price = in.nextDouble();
      System.out.println();

      System.out.println("Quantity     Price");
      int quantity = 1;
      System.out.printf("%8d%10.2f%n", quantity, quantity * price);
      quantity = 12;
      System.out.printf("%8d%10.2f%n", quantity, quantity * price);
      quantity = 100;
      System.out.printf("%8d%10.2f%n", quantity, quantity * price);

      // Close the scanner to release the resource.
      in.close();
   }
}