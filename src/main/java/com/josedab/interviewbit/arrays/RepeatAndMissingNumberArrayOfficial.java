package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a read only array of n integers from 1 to n.

 Each integer appears exactly once except A which appears twice and B which is missing.

 Return A and B.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Note that in your output A should precede B.

 Example:

 Input:[3 1 2 5 3] 

 Output:[3, 4]

 A = 3, B = 4


 NOTE: this is the official solution.

 */
public class RepeatAndMissingNumberArrayOfficial {

    public List<Integer> repeatedNumber(final List<Integer> list) {
        int arraySize = list.size();
        long sumOfNumbers = getSumOfNumbers(arraySize);
        long sumOfSquares = getSumOfSquares(arraySize);
        long differenceNumber = getDifferenceOfNumbers(list, sumOfNumbers);
        long differenceSquare = getDifferenceOfSquares(list, sumOfSquares);
        long sumNumber = differenceSquare / differenceNumber;
        int repeatedNumber = (int) ((sumNumber + differenceNumber) / 2);
        int missingNumber = (int) (sumNumber - repeatedNumber);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeatedNumber);
        result.add(missingNumber);
        return result;
    }

    private long getDifferenceOfNumbers(List<Integer> a, long sumOfNumbers) {
        long sum = sumOfNumbers * -1;
        for (Integer number : a) {
            long num = (long) number;
            sum += num;
            ;
        }
        return sum;
    }

    private long getDifferenceOfSquares(List<Integer> a, long sumOfSquares) {
        long sumSquares = sumOfSquares * -1;
        for (Integer number : a) {
            long num = (long) number;
            sumSquares += (num * num);
        }
        return sumSquares;
    }

    private long getSumOfNumbers(double n) {
        return (long) (n * (n - 1) / 2 + n);
    }

    private long getSumOfSquares(double n) {
        return (long) (n * (n + 1) * (2 * n + 1) / 6);
    }

    public static void main(String[] args) {
        RepeatAndMissingNumberArrayOfficial solution = new RepeatAndMissingNumberArrayOfficial();
        System.out.println(solution.repeatedNumber(Arrays.asList(3, 1, 2, 5, 3)));
    }
}
