package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * Given a singly linked list, determine if its a palindrome.
 * Return 1 or 0 denoting if its a palindrome or not, respectively.

 Notes:

 Expected solution is linear in time and constant in space.
 For example,

 List 1-->2-->1 is a palindrome.
 List 1-->2-->3 is not a palindrome.

 Note: There is an alternative solution with a stack:
 {@link com.josedab.interviewbit.stacksAndQueues.PalindromeListWithStack}
 */
public class PalindromeList {
    public ListNode reverseList(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode prev = null;
        ListNode node = a;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    private int getLength(ListNode a) {
        ListNode aNext = a.next;
        int n = 1;
        while (aNext != null) {
            aNext = aNext.next;
            n++;
        }
        return n;
    }

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;
        int len = getLength(A);
        int half = len % 2 == 0 ? len / 2 : ((len / 2) + 1);
        ListNode head1 = A;
        ListNode head2 = head1;
        for (int i = 0; i < half; i++) {
            head2 = head2.next;
        }
        head2 = reverseList(head2);
        while (head2 != null) {
            if (head2.val != head1.val) return 0;
            head2 = head2.next;
            head1 = head1.next;
        }
        return 1;
    }

    public static void main(String[] args) {
        PalindromeList solution = new PalindromeList();
        System.out.println(solution.lPalin(ListNodeUtils.createListNodeListFromIntegers(1, 2, 1)));
        System.out.println(solution.lPalin(ListNodeUtils.createListNodeListFromIntegers(1, 2, 3)));
    }
}
