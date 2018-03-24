package com.josedab.interviewbit.backtracking;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Reverse a linked list using recursion.

 Example :
 Given 1->2->3->4->5->NULL,

 return 5->4->3->2->1->NULL.
 */
public class ReverseLinkListRecursion {

    ListNode head = null;

    public ListNode reverseList(ListNode A) {
        if (A == null) {
            return null;
        } else if (A.next == null) {
            head = A;
        } else {
            ListNode tail = A.next;
            reverseList(tail);
            tail.next = A;
            A.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkListRecursion solution = new ReverseLinkListRecursion();
        ListNodeUtils.printListNodes(
                solution.reverseList(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5)));
    }
}
