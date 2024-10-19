// File: src/Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordGenerator generator = new PasswordGenerator();

        // User inputs
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (true/false): ");
        boolean useUpper = scanner.nextBoolean();

        System.out.print("Include lowercase letters? (true/false): ");
        boolean useLower = scanner.nextBoolean();

        System.out.print("Include digits? (true/false): ");
        boolean useDigits = scanner.nextBoolean();

        System.out.print("Include special characters? (true/false): ");
        boolean useSpecial = scanner.nextBoolean();

        // Generate and display password
        try {
            String password = generator.generatePassword(length, useUpper, useLower, useDigits, useSpecial);
            System.out.println("Generated password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
