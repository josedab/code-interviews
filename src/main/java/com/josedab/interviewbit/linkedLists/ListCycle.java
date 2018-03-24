package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Try solving it using constant additional space.

 Example :

 Input :

            ______
           |     |
           \/    |
 1 -> 2 -> 3 -> 4

 Return the node corresponding to node 3.

 Note: with additional space, the solution is given on {@link ListCycleWithSet}

 Solution approach:
 2 pointer approach ( Floyd’s Cycle-Finding Algorithm ) :
 What if you have 2 pointers which are going at different speed. For arguments sake, lets just say one pointer is going at double the speed of the other.
 Would they meet if there is a cycle ? Are they guaranteed to meet if there is a cycle ?
 What happens if there is no cycle ?

 Once you detect a cycle, think about finding the starting point.
 */
public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slowRunner = a;
        ListNode fastRunner = a;

        if (a == null) {
            return null;
        }

        while (fastRunner.next != null && fastRunner.next.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if (slowRunner == fastRunner) {

                slowRunner = a;
                while (true) {
                    if (slowRunner == fastRunner) {
                        return slowRunner;
                    }

                    slowRunner = slowRunner.next;
                    fastRunner = fastRunner.next;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListCycle solution = new ListCycle();

        ListNode problem = new ListNode(1);
        ListNode pointer = problem;
        pointer.next = new ListNode(2);
        pointer = pointer.next;
        pointer.next = new ListNode(3);
        pointer = pointer.next;
        ListNode cyclePointer = pointer;
        pointer.next = new ListNode(4);
        pointer = pointer.next;
        pointer.next = cyclePointer;

        System.out.println(solution.detectCycle(problem).val);
    }


}
