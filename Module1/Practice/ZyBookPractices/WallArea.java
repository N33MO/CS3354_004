package Module1.Practice.ZyBookPractices;

import java.util.Scanner;

/**
 * ZyBook 2.8.1 Challenge Activity: Compute wall area when there are windows.
 *
 * <p>Reads the wall width, wall height, and number of windows using the given 
 * prompts. Each window is {@code 2 ft × 3 ft}. The program prints the remaining
 * paintable wall area (wall area minus window areas).</p>
 *
 * <p><b>Try this</b>: When the program asks for input, type all three values on 
 * one line, separated by spaces (for example: {@code 10 8 2}), then press Enter. 
 * Notice how {@link Scanner} still reads the three numbers correctly.</p>
 *
 * <p><b>How to run (from the project root)</b>:</p>
 *
 * <pre>
 * javac Module1/Practice/ZyBookPractices/WallArea.java
 * java Module1.Practice.ZyBookPractices.WallArea
 * </pre>
 */
public class WallArea {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      System.out.print("Wall width: ");
      double wallWidth = in.nextDouble();
      
      System.out.print("Wall height: ");
      double wallHeight = in.nextDouble();
      
      System.out.print("Number of windows: ");
      int windows = in.nextInt();

      // Compute the area of the wall without the windows
      final double WINDOW_WIDTH = 2;
      final double WINDOW_HEIGHT = 3;
      double area = wallWidth * wallHeight - windows * WINDOW_WIDTH * WINDOW_HEIGHT;

      System.out.println("Area: " + area);

      // Close the scanner to release the resource.
      in.close();
   }
}

