package com.josedab.interviewbit.math;

/**
 * Given a positive integer which fits in a 32 bit signed integer, find if it can
 * be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

 Example

 Input : 4
 Output : True
 as 2^2 = 4.

 */
public class PowerOfTwoIntegers {
    public int isPower(int n) {
        if (n < 2) return 1;
        for (int x = 2; x <= Math.sqrt(n); x++) {
            int y = 2;

            double p = Math.pow(x, y);

            while (p <= n && p > 0) {
                if (p == n)
                    return 1;
                y++;
                p = Math.pow(x, y);
            }
        }
        return 0;
    }

    public boolean isPowerOfficial(int a) {
        if (a == 1) return true;
        for (int i = 2; i * i <= a; i++) {
            int p = a;
            while (p % i == 0) {
                p /= i;
            }
            if (p == 1) return true;
        }
        return false;
    }

    public static void main(String []args){
        PowerOfTwoIntegers solution = new PowerOfTwoIntegers();
        System.out.println(solution.isPower(1));
        System.out.println(solution.isPower(8));
    }
}
