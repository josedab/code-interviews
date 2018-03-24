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

 This solution requires additional space, to see the solution without additional space,
 have a look at {@link ListCycle}

 Solution approach: Hashing
 What if you could maintain a list of nodes already visited.
 As soon as you visit a node already visited, you know that there is a cycle.

 */
public class ListCycleWithSet {
    public ListNode detectCycle(ListNode a) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode pointer = a;
        ListNode result = null;
        while (pointer != null) {
            if (nodeSet.contains(pointer)) {
                result = pointer;
                break;
            } else {
                nodeSet.add(pointer);
            }
            pointer = pointer.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListCycleWithSet solution = new ListCycleWithSet();

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
