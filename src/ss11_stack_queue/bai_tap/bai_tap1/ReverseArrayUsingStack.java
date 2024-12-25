package ss11_stack_queue.bai_tap.bai_tap1;

import java.util.Stack;

public class ReverseArrayUsingStack {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Mảng ban đầu:");
        printArray(array);

        Stack<Integer> stack = new Stack<>();

        for (int num : array) {
            stack.push(num);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }

        System.out.println("Mảng sau khi đảo ngược:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
