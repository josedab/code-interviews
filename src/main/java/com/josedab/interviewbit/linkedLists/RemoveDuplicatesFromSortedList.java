package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode ln) {
        ListNode pointer = ln;
        ListNode previousNode = null;
        while(pointer!=null){
            if(previousNode!= null && pointer.val==previousNode.val){
                previousNode.next = pointer.next;
            }else{
                previousNode = pointer;
            }
            pointer = pointer.next;
        }
        return ln;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        ListNodeUtils.printListNodes(
                solution.deleteDuplicates(ListNodeUtils.createListNodeListFromIntegers(1, 2, 2, 4)));
        ListNodeUtils.printListNodes(
                solution.deleteDuplicates(ListNodeUtils.createListNodeListFromIntegers(1, 2, 3, 3, 5)));
    }
}
