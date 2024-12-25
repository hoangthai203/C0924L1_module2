package ss11_stack_queue.bai_tap.bai_tap3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicPalindromeChecker {
    public static void main(String[] args) {
        String input = "Able was I ere I saw Elba";
        System.out.println("Chuỗi đầu vào: " + input);

        boolean isPalindrome = checkPalindrome(input);
        if (isPalindrome) {
            System.out.println("Chuỗi là Palindrome.");
        } else {
            System.out.println("Chuỗi không phải là Palindrome.");
        }
    }

    public static boolean checkPalindrome(String str) {
        String processedStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                processedStr += Character.toLowerCase(c);
            }
        }

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : processedStr.toCharArray()) {
            queue.offer(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
}

