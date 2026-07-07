import java.util.Scanner;
import validator.validation;
import generator.passwordgen;

public class main {
    public static void main(String[] args) {
        // Init Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("validate for Validating your PW, generate to generate your PW");
        String input = sc.nextLine();

        if (input.equals("validate")) {
            System.out.print("Enter a password to validate: ");
            String password = sc.nextLine();

            // Logic
            if (validation.isValid(password)) {
                System.out.println("Strong password! Your password meets all security requirements.");
            } else {
                System.out.println("Weak password! Ensure it has at least 8 characters, a mix of upper/lower case, a digit, a special character, and isn't overly common.");
            }
            sc.close();
        } else if (input.equals("generate")) {
            System.out.println("Enter the password langth to generate: ");
            int length = sc.nextInt();
            if (length > 8 && length < 60) {
                StringBuilder password = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    int index = passwordgen.random.nextInt(passwordgen.allAllowed.length());
                    password.append(passwordgen.allAllowed.charAt(index));
                }
                System.out.println(password.toString());
            } else {
                System.out.println("Weak Password or too long Password");
            }

        } else {
            System.out.println("Invalid input");
        }
        sc.close();

    }
}
