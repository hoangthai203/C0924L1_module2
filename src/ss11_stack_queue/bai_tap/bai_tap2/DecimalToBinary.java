package ss11_stack_queue.bai_tap.bai_tap2;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 30;
        System.out.println("Số thập phân: " + decimal);

        String binary = convertDecimalToBinary(decimal);
        System.out.println("Số nhị phân: " + binary);
    }

    public static String convertDecimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}

