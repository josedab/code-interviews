package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:

 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        int length = length(A);
        B = B % length;
        if (B == 0) {
            return A;
        }
        int rotationIndex = length - B;

        ListNode result = A;
        ListNode head = A;
        if (rotationIndex > 0) {
            ListNode previous = A;
            ListNode pointer = A.next;
            rotationIndex--;
            while (pointer != null) {
                if (rotationIndex == 0) {
                    previous.next = null;
                    result = pointer;
                }
                rotationIndex--;
                previous = pointer;
                pointer = pointer.next;
            }
            previous.next = head;
        }
        return result;

    }

    private int length(ListNode ln) {
        int result = 0;
        ListNode pointer = ln;
        while (pointer != null) {
            pointer = pointer.next;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        RotateList solution = new RotateList();

        ListNodeUtils.printListNodes(solution.rotateRight(
                ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 4, 5), 2
        ));

        ListNodeUtils.printListNodes(solution.rotateRight(
                ListNodeUtils.createListNodeListFromIntegers(
                        44, 36, 80, 18, 39, 95, 79, 57, 71, 51, 23, 5, 86, 4, 67, 56, 88, 6, 33, 42, 9), 20
        ));
    }

}
