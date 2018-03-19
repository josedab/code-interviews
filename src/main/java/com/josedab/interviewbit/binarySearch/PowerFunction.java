package com.josedab.interviewbit.binarySearch;

/**
 * Implement pow(x, n) % d.

 In other words, given x, n and d,

 find (xn % d)

 Note that remainders on division cannot be negative.
 In other words, make sure the answer you return is non negative.

 Input : x = 2, n = 3, d = 3
 Output : 2

 2^3 % 3 = 8 % 3 = 2.
 */
public class PowerFunction {

    public int pow(int x, int n, int d) {
        if (x < 0) {
            x = (x % d) + d;
        }

        if (n == 0) {
            return 1 % d;
        } else if (n == 1) {
            return x % d;
        } else {
            // For big co-prime numbers between x and d, overflow might happen for integer multiplication
            long partialResult = pow(x % d, n / 2, d);
            long partialResult2n = ((partialResult % d) * (partialResult % d)) % d;
            if (n % 2 == 0) {
                return (int) partialResult2n;
            } else {
                long partialResult2nPlus1 = (partialResult2n * (x % d)) % d;
                return (int) partialResult2nPlus1;
            }
        }
    }

    public static void main(String[] args) {
        PowerFunction solution = new PowerFunction();
        System.out.println(solution.pow(2,3,3));
        System.out.println(solution.pow(-1,1,20));
        System.out.println(solution.pow(71045970, 41535484, 64735492));

    }
}
