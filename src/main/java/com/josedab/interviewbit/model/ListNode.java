package com.josedab.interviewbit.model;

/**
 * Represents a node from a single linked list
 * Holds a reference to the next element in the list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}
