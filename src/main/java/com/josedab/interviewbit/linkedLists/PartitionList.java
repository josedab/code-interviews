package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {

    public ListNode partition(ListNode A, int B) {
        ListNode biggerAux = new ListNode(-1);
        ListNode lowerAux = new ListNode(-1);
        ListNode pointer = A;

        ListNode pointerBiggerAux = biggerAux;
        ListNode pointerLowerAux = lowerAux;

        while (pointer != null) {
            ListNode nodeToAppend = new ListNode(pointer.val);
            if (pointer.val >= B) {
                pointerBiggerAux.next = nodeToAppend;
                pointerBiggerAux = pointerBiggerAux.next;
            } else if (pointer.val < B) {
                pointerLowerAux.next = nodeToAppend;
                pointerLowerAux = pointerLowerAux.next;
            }
            pointer = pointer.next;
        }

        ListNode result = new ListNode(-1);
        pointer = result;
        if (lowerAux.next != null) {
            pointer.next = lowerAux.next;
            pointer = pointerLowerAux;
        }
        if (biggerAux.next != null) {
            pointer.next = biggerAux.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        ListNodeUtils.printListNodes(
                solution.partition(
                        ListNodeUtils.createListNodeListFromIntegers(1, 4, 3, 2, 5, 2), 3));
    }
}
