package com.josedab.interviewbit.linkedLists;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 342 + 465 = 807
 Make sure there are no trailing zeros in the output list
 So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.


 */
public class AddTwoNumbersAsLists {

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode result = new ListNode(-1);

        ListNode pointer = result;
        ListNode pointerA = A;
        ListNode pointerB = B;

        int carryOver = 0;
        while (pointerA != null && pointerB != null) {
            int sum = pointerA.val + pointerB.val + carryOver;
            pointer.next = new ListNode(sum % 10);

            pointer = pointer.next;
            pointerA = pointerA.next;
            pointerB = pointerB.next;
            carryOver = sum / 10;
        }

        if (pointerA != null) {
            sumPartialWithCarryOver(pointer, carryOver, pointerA);
        } else {
            sumPartialWithCarryOver(pointer, carryOver, pointerB);
        }

        return result.next;
    }

    private void sumPartialWithCarryOver(ListNode pointer, int carryOver, ListNode ln) {
        ListNode pointerLn = ln;
        while (pointerLn != null) {
            int sum = pointerLn.val + carryOver;
            carryOver = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            pointerLn = pointerLn.next;
        }

        if (carryOver > 0) {
            pointer.next = new ListNode(carryOver);
        }

    }

    // InterviewBit official solution
    // It varies from solution proposed in terms it tries to be generic on the loop.
    // Not sure if i like this approach more but good to consider for different list size problems
    public ListNode addTwoNumbersAlternative(ListNode A, ListNode B) {
        ListNode lastNode = null;
        ListNode newList = null;
        int carry  =0;
        int addendum = 0;
        while(A!=null || B!=null){

            int total = carry;
            if(A!=null){
                total+=A.val;
            }
            if(B!=null){
                total+=B.val;
            }

            addendum = total%10;
            carry = total/10;
            if(lastNode==null){
                lastNode =  new ListNode(addendum);
                newList = lastNode;
            }else{
                lastNode.next = new ListNode(addendum);
                lastNode = lastNode.next;

            }
            if(A!=null)
                A = A.next;

            if(B!=null)
                B = B.next;
        }
        if(carry>0)
            lastNode.next = new ListNode(carry);

        return newList;
    }

    public static void main(String[] args) {
        AddTwoNumbersAsLists solution = new AddTwoNumbersAsLists();
        ListNodeUtils.printListNodes(
                solution.addTwoNumbers(
                        ListNodeUtils.createListNodeListFromIntegers(2, 4, 3),
                        ListNodeUtils.createListNodeListFromIntegers(5, 6, 4)));
    }

}
