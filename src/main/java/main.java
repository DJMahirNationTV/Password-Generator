import java.util.Scanner;
import validator.validation;

public class main {
    public static void main(String[] args) {
        // Init Scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a password to validate: ");
        String password = sc.nextLine();

        // Logic
        if (validation.isValid(password)) {
            System.out.println("Strong password! Your password meets all security requirements.");
        } else {
            System.out.println("Weak password! Ensure it has at least 8 characters, a mix of upper/lower case, a digit, a special character, and isn't overly common.");
        }

        sc.close();
    }
}
