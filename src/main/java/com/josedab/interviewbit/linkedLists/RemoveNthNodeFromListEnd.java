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

 Note for optimization: from editorial
 There are 2 approaches :
 1) Find out the length of the list in one go. Then you know the number of node to be removed.
 Traverse to the node and remove it.
 2) Make the first pointer go n nodes. Then move the second and first pointer simultaneously.
 This way, the first pointer is always ahead of the second pointer by n nodes.
 So when first pointer reaches the end, you are on the node to be removed.
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

    // Two pointers solution
    // Advance b steps first one, use the second one to advance the necessary steps only
    public ListNode removeNthFromEndOptimization(ListNode a, int b) {
        if (a == null)
            return a;
        int len = 0;
        ListNode temp = a;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        if (b >= len) {
            return a.next;
        } else {
            int it = len + 1 - b;
            temp = a;
            for (int i = 1; i < it - 1; i++) {
                temp = temp.next;
            }
            ListNode rm = temp.next;
            if (rm.next == null)
                temp.next = null;
            else {
                temp.next = rm.next;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromListEnd solution = new RemoveNthNodeFromListEnd();
        ListNodeUtils.printListNodes(
                solution.removeNthFromEnd(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5), 2));
    }
}
