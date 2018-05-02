package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, invert the binary tree and return it.
 Look at the example for more details.

 Example :
 Given binary tree

      1
    /   \
   2     3
  / \   / \
 4   5 6   7
 invert and return

      1
    /   \
   3     2
  / \   / \
 7   6 5   4
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        TreeNode temp = A.left;
        A.left = invertTree(A.right);
        A.right = invertTree(temp);
        return A;
    }

    public static void main(String[] args) {
        InvertTree solution = new InvertTree();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 3, 4, 5);
        System.out.println(TreeNodeUtils.getNodesInOrderTraversal(problem));
        TreeNode inversedTree = solution.invertTree(problem);
        System.out.println(TreeNodeUtils.getNodesInOrderTraversal(inversedTree));
    }

}
