package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Stack;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.

 Example :

 Input :
    2
   / \
  1   3

 and k = 2

 Return : 2

 As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST

 Solution proposed using a stack. I think it is better than official one as it goes through the elements only
 once and stops when it finds the element.
 Solution using stack rather than recursion.
 In solution @{@link KthSmallestElementInTree} there are edge cases where they go through more elements than necessary
 and they dont't take advantage of the inherent properties of a BST.

 TODO:
 Work on a benchmark
 */
public class KthSmallestElementInTreeStack {


    public int kthsmallest(TreeNode treeNode, int nthIndex) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = treeNode;
        if (pointer != null) {
            stack.push(pointer);
            while (pointer.left != null) {
                pointer = pointer.left;
                stack.push(pointer);
            }

        }

        int counter = 0;
        while (!stack.isEmpty()) {
            pointer = stack.pop();
            counter++;
            if (counter == nthIndex) {
                return pointer.val;
            }

            if (pointer.right != null) {
                pointer = pointer.right;
                while (pointer.left != null) {
                    pointer = pointer.left;
                    stack.push(pointer);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestElementInTreeStack solution = new KthSmallestElementInTreeStack();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(2, 1, 3);
        System.out.println(solution.kthsmallest(problem, 2));
    }
}
