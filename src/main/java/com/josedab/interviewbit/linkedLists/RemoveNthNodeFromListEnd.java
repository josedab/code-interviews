package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,
 Given linked list: 1->2->3->4->5, and n = 2.
 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 If n is greater than the size of the list, remove the first node of the list.
 Try doing it using constant additional space.
 */
public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int lengthLn = length(A);
        int nthLeft = Math.max(lengthLn - B, 0);

        ListNode result = A;
        ListNode previous = null;
        ListNode pointer = A;
        int index = 0;
        while (index <= nthLeft) {

            if (index == nthLeft) {
                if (previous == null) {
                    result = pointer.next;
                    break;
                } else {
                    previous.next = pointer.next;
                    break;
                }
            }
            previous = pointer;
            pointer = pointer.next;


            index++;
        }
        return result;
    }

    private int length(ListNode A) {
        int result = 0;
        ListNode pointer = A;
        while (pointer != null) {
            result++;
            pointer = pointer.next;
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromListEnd solution = new RemoveNthNodeFromListEnd();
        ListNodeUtils.printListNodes(
                solution.removeNthFromEnd(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5), 2));
    }
}
