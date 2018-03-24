package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list. Note 2:
 Usually the version often seen in the interviews is reversing the whole linked
 list which is obviously an easier version of this question.
 */
public class ReverseLinkListTwo {
    public ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode result = new ListNode(-1);
        ListNode previous = null;
        ListNode pointer = A;

        int index = 1;
        // Advance with the pointer
        while (pointer != null && index < B) {
            previous = pointer;
            pointer = pointer.next;
            index++;
        }

        //Reverse list
        ListNode endOfReversedPart = pointer;
        ListNode reversedPart = null;
        while (pointer != null && index <= C) {
            ListNode node = pointer;
            pointer = pointer.next;
            node.next = reversedPart;
            reversedPart = node;
            index++;
        }

        // Construct the result
        if (previous == null) {
            result.next = reversedPart;
            endOfReversedPart.next = pointer;
        } else {
            result.next = A;
            previous.next = reversedPart;
            endOfReversedPart.next = pointer;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ReverseLinkListTwo solution = new ReverseLinkListTwo();
        ListNodeUtils.printListNodes(
                solution.reverseBetween(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5), 2, 4));
    }
}
