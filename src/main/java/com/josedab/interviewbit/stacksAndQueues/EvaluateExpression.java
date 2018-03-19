package com.josedab.interviewbit.stacksAndQueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateExpression {

    public int evalRPN(List<String> A) {
        Stack<Integer> stack = new Stack<>();
        String operands = "+-*/";

        for (String element : A) {
            if (operands.contains(element)) {
                int value2 = stack.pop();
                int value1 = stack.pop();

                switch (element) {
                    case "+":
                        stack.push(value1 + value2);
                        break;
                    case "-":
                        stack.push(value1 - value2);
                        break;
                    case "*":
                        stack.push(value1 * value2);
                        break;
                    case "/":
                        stack.push(value1 / value2);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(element));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateExpression solution = new EvaluateExpression();
        System.out.println(solution.evalRPN(Arrays.asList("4", "13", "5", "/", "+")));
    }
}
