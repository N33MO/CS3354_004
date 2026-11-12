package Module5.solid.lsp;

import java.util.Arrays;

public class Demo6 {
    
}

/**
 * NumberSorter promises to return a new, ascending array without
 * modifying the input. ParallelSorter produces the correct sorted
 * values, but sorts the original array in place — breaking the parent's
 * guarantee. LSP also concerns side effects, not just return values.
 */

// BEFORE
class NumberSorter {
    // Contract: for a non-null input, return a sorted copy; leave input unchanged.
    public int[] sort(int[] input) {
        int[] result = input.clone();
        Arrays.sort(result);
        return result;
    }
}

class ParallelSorter extends NumberSorter {
    @Override
    public int[] sort(int[] input) {
        Arrays.parallelSort(input);
        return input; // sorted values are correct, but input was modified
    }
}

class SortProcessor {
    public void process(NumberSorter sorter) {
        int[] original = {3, 1, 2};
        int[] sorted = sorter.sort(original);

        System.out.println("Sorted: " + Arrays.toString(sorted));
        // Expects [3, 1, 2], but silently gets [1, 2, 3] with ParallelSorter.
        System.out.println("Original: " + Arrays.toString(original));
    }
}

// AFTER
class NumberSorter {
    // Contract: for a non-null input, return a sorted copy; leave input unchanged.
    public int[] sort(int[] input) {
        int[] result = input.clone();
        Arrays.sort(result);
        return result;
    }
}

class ParallelSorter extends NumberSorter {
    @Override
    public int[] sort(int[] input) {
        int[] result = input.clone();
        Arrays.parallelSort(result); // different algorithm, same guarantees
        return result;
    }
}

class SortProcessor {
    public void process(NumberSorter sorter) {
        int[] original = {3, 1, 2};
        int[] sorted = sorter.sort(original);

        // Same caller works correctly with either sorter.
        System.out.println("Sorted: " + Arrays.toString(sorted));     // [1, 2, 3]
        System.out.println("Original: " + Arrays.toString(original)); // [3, 1, 2]
    }
}
