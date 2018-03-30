package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 Example :

     1
    / \
   2   2
  / \ / \
 3  4 4  3
 The above binary tree is symmetric.
 But the following is not:

    1
   / \
  2   2
   \   \
   3    3
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode tn) {
        return isSymmetric(tn.left, tn.right) ? 1 : 0;
    }

    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
        }
    }

    public static void main(String[] args) {
        SymmetricBinaryTree solution = new SymmetricBinaryTree();
        System.out.println(solution.isSymmetric(
                TreeNodeUtils.createTreeNodeListFromInOrderSequence(1, 2, 2, 3, 4, 4, 3)));
        System.out.println(solution.isSymmetric(
                TreeNodeUtils.createTreeNodeListFromInOrderSequence(1, 2, 2, -1, 3, -1, 3)));

    }
}
