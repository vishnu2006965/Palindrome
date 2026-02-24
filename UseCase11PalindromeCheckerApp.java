import java.util.Scanner;

    public class UseCase11PalindromeChecker {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            PalindromeChecker checker = new PalindromeChecker();

            System.out.println("Enter a string to check palindrome:");
            String input = scanner.nextLine();

            boolean result = checker.checkPalindrome(input);

            if (result) {
                System.out.println("It is a Palindrome.");
            } else {
                System.out.println("It is NOT a Palindrome.");
            }

            scanner.close();
        }
    }

