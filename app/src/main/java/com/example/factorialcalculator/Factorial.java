package com.example.factorialcalculator;

import java.math.BigInteger;

/**
 * Factorial behind the screen. Kept free of Android types so it can be unit-tested,
 * and it never throws: every bad input comes back as a message to show the user.
 */
final class Factorial {

    /** Largest n accepted; past this the answer is hundreds of digits long. */
    static final int MAX = 100;

    private Factorial() {
    }

    static String calculate(String input) {
        String text = input.trim();
        if (text.isEmpty()) {
            return "Number field can't be empty";
        }
        long n;
        try {
            n = Long.parseLong(text);
        } catch (NumberFormatException e) {
            return "Error! Please enter a smaller number";
        }
        if (n < 0) {
            return "Error! Please enter a positive number";
        }
        if (n > MAX) {
            // The old int loop overflowed past 12! and froze on very large inputs.
            return "Error! Factorial works for 0 to " + MAX;
        }
        return "Factorial=" + of((int) n);
    }

    static BigInteger of(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
