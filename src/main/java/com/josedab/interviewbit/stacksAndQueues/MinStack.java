package com.josedab.interviewbit.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) – Push element x onto stack.
 pop() – Removes the element on top of the stack.
 top() – Get the top element.
 getMin() – Retrieve the minimum element in the stack.
 Note that all the operations have to be constant time operations.

 Questions to ask the interviewer :

 Q: What should getMin() do on empty stack?
 A: In this case, return -1.

 Q: What should pop do on empty stack?
 A: In this case, nothing.

 Q: What should top() do on empty stack?
 A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.


 Solution: Trade off: we want to save on memory recalculating min on demand. That gives as an amortized constant time on pop.
 For saving in re-computation but increasing the space in memory, see solution @{@link MinStack}
 Solution taken from InterviewBit editorial.
 */
public class MinStack {
    private List<Integer> list = new ArrayList<>();
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        list.add(x);
        if (x < min) {
            min = x;
        }
    }

    // Pop becomes amortized constant time
    public void pop() {
        if (!list.isEmpty()) {
            int element = list.remove(list.size() - 1);
            if (element == min) {
                recalculateMin();
            }
        }
    }

    public int top() {
        int result = -1;
        if (!list.isEmpty()) {
            result = list.get(list.size() - 1);
            if (result == min) {
                recalculateMin();
            }
        }
        return result;
    }

    private void recalculateMin() {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
    }

    public int getMin() {
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(9);

        System.out.println("BP1:" + minStack.getMin());
        minStack.push(8);

        System.out.println("BP2:" + minStack.getMin());
        minStack.push(7);

        System.out.println("BP3:" + minStack.getMin());
        minStack.push(6);

        System.out.println("BP4:" + minStack.getMin());
        minStack.pop();

        System.out.println("BP5:" + minStack.getMin());
        minStack.pop();

        System.out.println("BP6:" + minStack.getMin());
        minStack.pop();

        System.out.println("BP7:" + minStack.getMin());
        minStack.pop();

        System.out.println("BP8:" + minStack.getMin());
        minStack.pop();

        System.out.println("BP9:" + minStack.getMin());
        minStack.pop();

        System.out.println("BP10:" + minStack.getMin());
    }
}
