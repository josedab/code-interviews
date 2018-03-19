package com.josedab.interviewbit.stacksAndQueues;

import java.util.LinkedList;

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


 Solution: Trade off: we want to save on recomputation of the min, however, memory increases.
 For saving in memory, see solution @{@link MinStack}
 */
public class MinStackMemoryVersion {
    private class Node {
        Integer val;
        Integer prevMin;
    }

    private LinkedList<Node> stack = new LinkedList<Node>();

    public void push(int x) {
        Node n = new Node();
        n.val = x;
        n.prevMin = stack.peek() != null ? Math.min(stack.peek().prevMin, n.val) : n.val;
        stack.push(n);
    }

    public void pop() {
        if (stack.peek() != null) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek() == null ? -1 : stack.peek().val;
    }

    public int getMin() {
        return stack.peek() == null ? -1 : stack.peek().prevMin;
    }

    public static void main(String[] args) {
        MinStackMemoryVersion minStack = new MinStackMemoryVersion();
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
