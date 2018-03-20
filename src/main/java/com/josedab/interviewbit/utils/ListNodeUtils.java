package com.josedab.interviewbit.utils;

import com.josedab.interviewbit.model.ListNode;

/**
 * Created by jbaena on 3/19/18.
 */
public class ListNodeUtils {

    public static ListNode createListNodeListFromIntegers(int... arrayOfIntegers) {
        int index = 0;
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
        }
        strResult.append("]");
        System.out.println(strResult);
    }
}
