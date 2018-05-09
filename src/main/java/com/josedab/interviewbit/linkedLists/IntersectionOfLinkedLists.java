package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:


 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3

 begin to intersect at node c1.

 Notes:
 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 */
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode listA, ListNode listB) {
        int m = length(listA);
        int n = length(listB);
        int diff = Math.abs(m - n);
        ListNode first = listA;
        ListNode second = listB;
        for (int i = 0; i < diff; i++) {
            if (m > n) {
                first = first.next;
            } else {
                second = second.next;
            }
        }
        boolean found = false;
        ListNode intersect = null;
        while (!found && first != null && second != null) {
            // first == second would be the ideal
            if (first.val == second.val) {
                found = true;
                intersect = first;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return intersect;
    }

    private int length(ListNode a) {
        int result = 0;
        ListNode pointer = a;
        while (pointer != null) {
            pointer = pointer.next;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfLinkedLists solution = new IntersectionOfLinkedLists();
        ListNodeUtils.printListNodes(
                solution.getIntersectionNode(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5),
                        ListNodeUtils.createListNodeListFromIntegers(5, 6, 7, 8, 3, 4, 5)
                ));
    }
}
