package com.josedab.interviewbit.stacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */
public class CheckBalancedParentheses {

    private Map<Character, Character> mappings;

    public CheckBalancedParentheses() {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');
    }

    public int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (mappings.containsKey(c)) {

                if (stack.isEmpty()) {
                    return 0;
                }

                Character poppedElement = stack.pop();

                if (poppedElement != mappings.get(c)) {
                    return 0;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        CheckBalancedParentheses solution = new CheckBalancedParentheses();
        System.out.println(solution.isValid("{["));
        System.out.println(solution.isValid("{}"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("{[]}}"));
    }
}
