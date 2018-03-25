package com.josedab.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 Make sure the returned list of strings are sorted.

 */
public class GenerateAllParenthesis {

    private static final String OPEN_PARENTHESIS = "(";
    private static final String CLOSED_PARENTHESIS = ")";

    public List<String> generateParenthesis(int A) {
        List<String> result = new ArrayList<>();
        String initialPartialResult = "";
        generateParenthesisAux(A, A, initialPartialResult, result);
        return result;
    }

    private void generateParenthesisAux(int numParenthesisLeft, int numParenthesisRight,
                                        String partialResult, List<String> result) {
        if (numParenthesisLeft == 0 && numParenthesisRight == 0) {
            result.add(partialResult);
        } else {

            if (numParenthesisLeft > 0) {
                generateParenthesisAux(numParenthesisLeft - 1, numParenthesisRight,
                                       partialResult + OPEN_PARENTHESIS, result);
            }

            if (numParenthesisRight > 0 && (numParenthesisRight - numParenthesisLeft) > 0) {
                generateParenthesisAux(numParenthesisLeft, numParenthesisRight - 1,
                                       partialResult + CLOSED_PARENTHESIS, result);
            }
        }
    }

    public static void main(String[] args) {
        GenerateAllParenthesis solution = new GenerateAllParenthesis();
        System.out.println(solution.generateParenthesis(3));
    }

}
