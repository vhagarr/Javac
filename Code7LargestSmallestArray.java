//LargestAndSmallest in array
public class Main {
    public static void main(String[] args) {
        int[] array = {34, 67, 23, 89, 1, 45, 78};
        findLargestAndSmallest(array);
    }

    public static void findLargestAndSmallest(int[] arr) {
        if (arr.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        int largest = arr[0];
        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        System.out.println("Largest element: " + largest);
        System.out.println("Smallest element: " + smallest);
    }
}
