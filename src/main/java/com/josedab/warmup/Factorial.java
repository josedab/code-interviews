package com.josedab.warmup;

public class Factorial {

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Factorial solution = new Factorial();
        System.out.println(solution.factorial(n));
    }
}
