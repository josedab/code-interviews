package com.josedab.interviewbit.backtracking;

/**
 * Implement pow(A, B) % C.

 In other words, given A, B and C,
 find (AB)%C.

 Input : A = 2, B = 3, C = 3
 Return : 2
 2^3 % 3 = 8 % 3 = 2

 */
public class ModularExpression {

    public int mod(int A, int B, int C) {
        if (A >= C) {
            A = A % C;
        }
        if (A < 0) {
            A = (A + ((-(A / C) + 1) * C)) % C;
        }
        if (B == 0) {
            return 1 % C;
        }

        if (B % 2 == 0) {
            long partialResult = mod(A, B / 2, C);
            long result = ((partialResult) * (partialResult)) % C;
            return (int) result;
        } else {
            long partialResult = mod(A, B - 1, C);
            long result = (A * partialResult) % C;
            return (int) result;
        }

    }

    public static void main(String[] args) {
        ModularExpression solution = new ModularExpression();
        System.out.println(solution.mod(71045970, 41535484, 64735492));
        System.out.println(solution.mod(2, 3, 3));
    }
}
