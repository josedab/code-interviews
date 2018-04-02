package com.josedab.interviewbit.heapsAndMaps;


import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.utils.ListNodeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.

 Example :

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
 will result in

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

 Solution proposed: Priority queue that holds the data and subsequently a dump into a ListNode structure

 Another solution: Heap min for elements, poll on an element and insertion into a list node.
 Removal of element inserted from the heap.
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(List<ListNode> a) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < a.size(); i++) {
            ListNode ln = a.get(i);
            while (ln != null) {
                pq.add(ln.val);
                ln = ln.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode pointer = result;
        while (!pq.isEmpty()) {
            Integer value = pq.poll();
            pointer.next = new ListNode(value);
            pointer = pointer.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        List<ListNode> problem = Arrays.asList(
                ListNodeUtils.createListNodeListFromIntegers(1, 10, 20),
                ListNodeUtils.createListNodeListFromIntegers(4, 11, 13),
                ListNodeUtils.createListNodeListFromIntegers(3, 8, 9)
        );
        ListNodeUtils.printListNodes(solution.mergeKLists(problem));
    }
}
