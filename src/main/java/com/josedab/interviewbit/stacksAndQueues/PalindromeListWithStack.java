package com.josedab.interviewbit.stacksAndQueues;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

import java.util.Stack;

/**
 * Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

 Notes:

 Expected solution is linear in time and constant in space.
 For example,

 List 1-->2-->1 is a palindrome.
 List 1-->2-->3 is not a palindrome.

 Note: this is a invented problem from {@link com.josedab.interviewbit.linkedLists.PalindromeList} where we
 use a stack to solve the problem
 */
public class PalindromeListWithStack {
    Stack<Integer> stack = new Stack<Integer>();
    public int lPalin(ListNode ln) {
        ListNode pointer= ln;
        while(pointer!=null){
            stack.push(pointer.val);
            pointer = pointer.next;
        }

        pointer= ln;
        while(pointer!=null){
            int poppedElement = stack.pop();
            if(poppedElement!=pointer.val){
                return 0;
            }
            pointer = pointer.next;
        }
        return 1;
    }

    public static void main(String []args){
        PalindromeListWithStack solution = new PalindromeListWithStack();
        System.out.println(solution.lPalin(ListNodeUtils.createListNodeListFromIntegers(1,2,1)));
        System.out.println(solution.lPalin(ListNodeUtils.createListNodeListFromIntegers(1,2,3)));
    }
}
