package com.josedab.interviewbit.utils;

import com.josedab.interviewbit.model.ListNode;

public class ListNodeUtils {

    public static ListNode createListNodeListFromIntegers(int... arrayOfIntegers) {
        ListNode previous = null;
        ListNode result = null;
        for (int i = arrayOfIntegers.length - 1; i >= 0; i--) {
            result = new ListNode(arrayOfIntegers[i]);
            result.next = previous;
            previous = result;
        }
        return result;
    }

    public static void printListNodes(ListNode node) {
        ListNode pointer = node;
        StringBuilder strResult = new StringBuilder("[");
        while (pointer != null) {
            strResult.append(' ').append(pointer.val);
            pointer = pointer.next;
        }
        strResult.append("]");
        System.out.println(strResult);
    }
}
