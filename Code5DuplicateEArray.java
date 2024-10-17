//duplicate in array
import java.util.HashSet;

public class DuplicateElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2, 3, 5, 6, 6};
        findDuplicates(array);
    }

    public static void findDuplicates(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int element : arr) {
            // If the element is already in 'seen', add it to 'duplicates'
            if (seen.contains(element)) {
                duplicates.add(element);
            } else {
                seen.add(element);
            }
        }

        // Print the duplicate elements
        System.out.println("Duplicate elements: " + duplicates);
    }
}
