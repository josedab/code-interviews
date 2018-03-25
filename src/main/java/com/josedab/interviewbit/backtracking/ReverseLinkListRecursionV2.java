package com.josedab.interviewbit.backtracking;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Reverse a linked list using recursion.
 * <p>
 * Example :
 * Given 1->2->3->4->5->NULL,
 * <p>
 * return 5->4->3->2->1->NULL.
 */
public class ReverseLinkListRecursionV2 {

    public ListNode reverseList(ListNode A) {
        if (A == null) {
            return null;
        } else if (A.next == null) {
            return A;
        } else {
            ListNode head = A;
            ListNode newHead = reverseLinkedListRecursive(A);
            head.next = null;
            return newHead;
        }
    }

    private ListNode reverseLinkedListRecursive(ListNode n) {
        if (n.next == null) {
            return n;
        } else {
            ListNode next = n.next;
            ListNode newHead = reverseLinkedListRecursive(next);
            next.next = n;
            return newHead;
        }

    }


    public static void main(String[] args) {
        ReverseLinkListRecursionV2 solution = new ReverseLinkListRecursionV2();
        ListNodeUtils.printListNodes(
                solution.reverseList(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5)));
    }
}
