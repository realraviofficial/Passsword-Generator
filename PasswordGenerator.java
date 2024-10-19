// File: src/PasswordGenerator.java
import java.security.SecureRandom;

public class PasswordGenerator {
    // Character sets to use in the password
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    // Random generator with better randomness than Random
    private SecureRandom random = new SecureRandom();

    public String generatePassword(int length, boolean useUpper, boolean useLower, 
                                   boolean useDigits, boolean useSpecial) {
        StringBuilder password = new StringBuilder(length);
        StringBuilder allowedChars = new StringBuilder();

        if (useUpper) allowedChars.append(UPPER);
        if (useLower) allowedChars.append(LOWER);
        if (useDigits) allowedChars.append(DIGITS);
        if (useSpecial) allowedChars.append(SPECIAL);

        // Ensure the allowed characters string is not empty
        if (allowedChars.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
