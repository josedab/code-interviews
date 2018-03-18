package com.josedab.interviewbit.binarySearch;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 If x is not a perfect square, return floor(sqrt(x))

 Example :

 Input : 11
 Output : 3
 */
public class SquareRootOfInteger {
    public int sqrt(int a) {
        int i = 1;
        int j = a;
        int possibleSolution = 0;

        if (a == 0) {
            return possibleSolution;
        }

        while (i <= j) {
            int middle = (i + j) / 2;

            int resultOfDivision = a / middle;
            if (middle == resultOfDivision) {
                return middle;
            } else if (middle > resultOfDivision) {
                j = middle - 1;
            } else {
                possibleSolution = middle;
                i = middle + 1;
            }
        }
        return possibleSolution;

    }

    public static void main(String[] args) {
        SquareRootOfInteger solution = new SquareRootOfInteger();
        System.out.println(solution.sqrt(0));
        System.out.println(solution.sqrt(1));
        System.out.println(solution.sqrt(2));
        System.out.println(solution.sqrt(2147483647));
    }
}
