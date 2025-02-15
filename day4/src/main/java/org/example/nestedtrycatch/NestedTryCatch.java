package nestedtrycatchtest;

public class NestedTryCatch {
    public static String divideElement(int[] arr, int index, int divisor) {
        try {
            try {
                int element = arr[index];
                return "Result: " + (element / divisor);
            } catch (ArrayIndexOutOfBoundsException e) {
                return "Invalid array index!";
            }
        } catch (ArithmeticException e) {
            return "Cannot divide by zero!";
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println(divideElement(numbers, 2, 5)); // Valid case
        System.out.println(divideElement(numbers, 10, 5)); // Invalid index
        System.out.println(divideElement(numbers, 2, 0)); // Division by zero
    }
}

