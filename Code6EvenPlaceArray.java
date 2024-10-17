//EvenPlace in Array
public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70};
        printEvenPositionElements(array);
    }

    public static void printEvenPositionElement(int[] arr) {
        System.out.println("Elements at even positions:");
        for (int i = 0; i < arr.length; i++) {
            // Check if the index is even
            if (i % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
