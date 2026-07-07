package generator;

import java.security.SecureRandom;

public class passwordgen {
    private static final String lower = "abcdefghijklmnopqrstuvwxyz";
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String number = "0123456789";
    private static final String character = "!@#?._-:,[]()";

    public static final String allAllowed = lower + upper + number + character;
    public static final SecureRandom random = new SecureRandom();


}
