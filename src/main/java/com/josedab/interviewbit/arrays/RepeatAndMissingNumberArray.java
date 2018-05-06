package com.josedab.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


 NOTE: this solution might not be the optimal, however I thought to give it a go. From there it is good to iterate
 until getting the optimal solution. The official solution can is {@link RepeatAndMissingNumberArrayOfficial}

 */
public class RepeatAndMissingNumberArray {
    public List<Integer> repeatedNumber(final List<Integer> list) {
        Collections.sort(list);
        List<Integer> result = new ArrayList<>();
        int previous = -1;
        int missingElement = -1;
        int duplicated = -1;
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (element == previous) {
                duplicated = element;
            }
            if (element != (i + 1) && missingElement == -1) {
                missingElement = i + 1;
            }
            previous = element;
        }
        result.add(duplicated);
        result.add(missingElement);
        return result;
    }

    public static void main(String[] args) {
        RepeatAndMissingNumberArray solution = new RepeatAndMissingNumberArray();
        System.out.println(solution.repeatedNumber(Arrays.asList(3, 1, 2, 5, 3)));
    }
}
