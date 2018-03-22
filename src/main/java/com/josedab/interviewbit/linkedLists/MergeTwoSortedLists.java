package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

 For example, given following linked lists :

 5 -> 8 -> 20
 4 -> 11 -> 15
 The merged list should be :

 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode result = new ListNode(-1);
        ListNode pointerResult = result;
        ListNode pointerA = A;
        ListNode pointerB = B;
        while (pointerA != null && pointerB != null) {
            if (pointerA.val < pointerB.val) {
                pointerResult.next = new ListNode(pointerA.val);
                pointerA = pointerA.next;
            } else {
                pointerResult.next = new ListNode(pointerB.val);
                pointerB = pointerB.next;
            }
            pointerResult = pointerResult.next;

        }

        if (pointerA == null) {
            copyRestOfElements(pointerResult, pointerB);
        } else if (pointerB == null) {
            copyRestOfElements(pointerResult, pointerA);
        }
        return result.next;
    }

    private void copyRestOfElements(ListNode listNode, ListNode listToCopy) {
        ListNode pointer = listToCopy;
        while (pointer != null) {
            listNode.next = new ListNode(pointer.val);
            listNode = listNode.next;
            pointer = pointer.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNodeUtils.printListNodes(
                solution.mergeTwoLists(
                        ListNodeUtils.createListNodeListFromIntegers(5, 8, 20),
                        ListNodeUtils.createListNodeListFromIntegers(4, 11, 15)));
    }

}
