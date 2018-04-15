package com.josedab.interviewbit.graphs;

import com.josedab.interviewbit.model.ListNode;
import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.ListNodeUtils;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : 1 -> 2 -> 3
 A height balanced BST  :

     2
   /   \
  1     3
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode a) {
        List<Integer> listToBeConverted = new ArrayList<>();
        ListNode pointer = a;
        while (pointer != null) {
            listToBeConverted.add(pointer.val);
            pointer = pointer.next;
        }
        return sortedListToBstHelper(listToBeConverted, 0, listToBeConverted.size() - 1);
    }

    private TreeNode sortedListToBstHelper(List<Integer> list, int start, int end) {
        TreeNode result = null;

        if (start == end) {
            result = new TreeNode(list.get(start));
        } else if (start < end) {
            int middle = (start + end) / 2;
            result = new TreeNode(list.get(middle));
            result.left = sortedListToBstHelper(list, start, middle - 1);
            result.right = sortedListToBstHelper(list, middle + 1, end);
        }
        return result;

    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree solution = new ConvertSortedListToBinarySearchTree();
        ListNode problem = ListNodeUtils.createListNodeListFromIntegers(1, 2);
        System.out.println(TreeNodeUtils.getNodesInOrderTraversal(solution.sortedListToBST(problem)));
    }
}
