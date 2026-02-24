import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
    String getName();
}

// 1️⃣ Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Stack Strategy";
    }
}

class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Deque Strategy";
    }
}

// 3️⃣ Two-Pointer Strategy (Most Efficient)
class TwoPointerStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public String getName() {
        return "Two Pointer Strategy";
    }
}

// Main Application
public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        System.out.println("\n--- Performance Comparison ---");

        for (PalindromeStrategy strategy : strategies) {

            long startTime = System.nanoTime();

            boolean result = strategy.check(input);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println("Algorithm: " + strategy.getName());
            System.out.println("Result: " + (result ? "Palindrome" : "Not Palindrome"));
            System.out.println("Execution Time: " + duration + " ns");
            System.out.println("-----------------------------------");
        }

        scanner.close();
    }
}