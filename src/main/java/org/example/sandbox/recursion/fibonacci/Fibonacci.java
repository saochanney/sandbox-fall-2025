// java
package org.example.sandbox.recursion.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Map<Integer, BigInteger> memo = new HashMap<>();

    static {
        memo.put(0, BigInteger.ZERO);
        memo.put(1, BigInteger.ONE);
    }

    public static BigInteger fibonacci(int n) {

        // validation
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        // Base case
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }

        // Recursive case using memoized helper
        return memo(n - 1).add(memo(n - 2));
    }

    private static BigInteger memo(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        BigInteger value = memo(n - 1).add(memo(n - 2));
        memo.put(n, value);
        return value;
    }

    public static void main(String[] args) {

        int n = 1000;
        for (int x = 0; x <= n; x++) {
            System.out.println("Fibonacci of " + x + " is: " + fibonacci(x));
        }

    }
}
