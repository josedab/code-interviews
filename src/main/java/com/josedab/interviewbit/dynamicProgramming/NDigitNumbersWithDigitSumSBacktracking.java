package com.josedab.interviewbit.dynamicProgramming;

/**
 * Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

 Since the answer can be large, output answer modulo 1000000007

 **

 N = 2, S = 4
 Valid numbers are {22, 31, 13, 40}
 Hence output 4.

 Solution: Backtracking
 Pros: Can find all the solutions rathern than just count
 Cons: Really inefficient for just a count
 */
public class NDigitNumbersWithDigitSumSBacktracking {
    private class Result {
        int result = 0;

        public void increaseNumberOfResults() {
            this.result = this.result + 1;
        }
    }

    public int solve(int nDigits, int sum) {
        Result result = new Result();
        solveAux(1, nDigits, sum, result);
        return result.result;
    }

    public void solveAux(int digitNumber, int nDigits, int sum, Result result) {
        if (digitNumber > nDigits) {
            if (sum == 0) {
                result.increaseNumberOfResults();
            }
        } else {
            int beginningRange = (digitNumber == 1) ? 1 : 0;
            for (int i = beginningRange; i <= sum; i++) {
                solveAux(digitNumber + 1, nDigits, sum - i, result);
            }
        }
    }

    public static void main(String[] args) {
        NDigitNumbersWithDigitSumSBacktracking solution = new NDigitNumbersWithDigitSumSBacktracking();
        System.out.println(solution.solve(2, 4));
    }

}
