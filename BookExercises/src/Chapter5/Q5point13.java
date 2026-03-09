package Chapter5;

public class Q5point13 {

    public static void main(String[] args) {
        System.out.printf("%-8s%-8s%n", "Number", "Factorial");
        long product = 1;
        for (int i = 1; i <= 20; i++) {
            product *= i;
            System.out.printf("%-8d%-8d%n", i, product);

        }
    }
}
/*Difficulty with calculating 100!

The problem:
long can store up to 9,223,372,036,854,775,807 (≈ 9 × 10¹⁸)
But 100! ≈ 9.33 × 10¹⁵⁷, which is way too large for any primitive type in Java.

Even double will lose accuracy beyond 20! or so.

🧠 To handle 100!

You’d need java.math.BigInteger, which can handle arbitrarily large numbers.

Example:

import java.math.BigInteger;

BigInteger factorial = BigInteger.ONE;
for (int i = 1; i <= 100; i++) {
    factorial = factorial.multiply(BigInteger.valueOf(i));
}
System.out.println("100! = " + factorial);

✅ Final verdict:

Your current code is perfect for 1–20! 💯

The only limitation is that long overflows beyond 20!.

To go higher (like 100!), use BigInteger.      */
