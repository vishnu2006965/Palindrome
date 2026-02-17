import java.util.Scanner;
public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Input: ");
        String word = scanner.nextLine();

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        System.out.println("is it a Palindrome? : ");

        if (word.equals(reversed)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        scanner.close();
    }
}
