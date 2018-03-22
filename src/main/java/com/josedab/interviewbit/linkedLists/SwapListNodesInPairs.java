package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode ln) {
        ListNode result = ln;
        ListNode pointer = ln;
        ListNode previous = null;
        while (pointer != null && pointer.next != null) {

            ListNode tail = pointer.next.next;
            ListNode swapAux = pointer.next;
            pointer.next = tail;
            swapAux.next = pointer;

            // First element of the array
            if (previous == null) {
                result = swapAux;
            } else {
                // Processing elements within the array (except first couple)
                previous.next = swapAux;
            }

            previous = swapAux.next;
            pointer = tail;

        }
        return result;
    }

    public static void main(String[] args) {
        SwapListNodesInPairs solution = new SwapListNodesInPairs();
        ListNodeUtils.printListNodes(
                solution.swapPairs(
                        ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4)));
    }
}
