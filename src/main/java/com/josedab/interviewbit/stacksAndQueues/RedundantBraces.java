package com.josedab.interviewbit.stacksAndQueues;

import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
 Return 0/1

 0 -> NO
 1 -> YES
 Input will be always a valid expression

 and operators allowed are only + , * , - , /

 Example:

 ((a + b)) has redundant braces so answer will be 1
 (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */
public class RedundantBraces {

    public int braces(String str) {
        String operands = "+-*/";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == ')') {
                boolean hasOperands = false;
                char elem = stack.pop();
                while (elem != '(') {
                    if (operands.indexOf(elem) > -1) {
                        hasOperands = true;
                    }
                    elem = stack.pop();
                }

                if (!hasOperands) {
                    return 1;
                }
            } else {
                stack.push(c);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RedundantBraces solution = new RedundantBraces();
        System.out.println(solution.braces("((a + b))"));
        System.out.println(solution.braces("(a + (a + b))"));
        System.out.println(solution.braces("(a)"));
        System.out.println(solution.braces("(a )"));
        System.out.println(solution.braces("(a*(a))"));
    }
}
