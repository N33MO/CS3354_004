package Module1.JavaProgramExample;

import java.util.ArrayList;
import java.util.List;

public class EnhancedForLoop2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(List.of(1,2)));
        grid.add(new ArrayList<>(List.of(3,4)));

        System.out.println("Grid: " + grid);

        // Update Grid
        for (ArrayList<Integer> row : grid) {
            row.set(0, 5);
            row.set(1, 10);
        }
        System.out.println("Updated Grid: " + grid);

        // Replace Grid
        for (ArrayList<Integer> row : grid) {
            row = new ArrayList<>(List.of(0,0,0));
        }
        System.out.println("Replaced Grid: " + grid);
    }
}
