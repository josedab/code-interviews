package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node’s key.
 The right subtree of a node contains only nodes with keys greater than the node’s key.
 Both the left and right subtrees must also be binary search trees.
 Example :

 Input :
    1
  /  \
 2    3

 Output : 0 or False


 Input :
   2
  / \
 1   3

 Output : 1 or True
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidBinarySearchTree {

    public int isValidBST(TreeNode tn) {
        return isValidBstHelper(tn, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBstHelper(TreeNode tn, int minValue, int maxValue) {
        if (tn == null) {
            return true;
        } else {

            boolean result = true;
            if (tn.left != null) {
                int leftValue = tn.left.val;
                result = result &&
                        leftValue >= minValue && leftValue < tn.val &&
                        isValidBstHelper(tn.left, minValue, tn.val - 1);
            }

            if (tn.right != null) {
                int rightValue = tn.right.val;
                result = result &&
                        rightValue > tn.val && rightValue <= maxValue &&
                        isValidBstHelper(tn.right, tn.val + 1, maxValue);
            }
            return result;

        }
    }

    // InterviewBit official variant
    // IMO, this looks cleaner: the idea is to compare the current root node rather than null checks on its children
    // Same behaviour as proposed solution but having the mindset of only one type of verification
    // makes the code cleaner
    public boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val >= min && root.val < max &&
                helper(root.left, min, root.val) &&
                helper(root.right, root.val, max)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        ValidBinarySearchTree solution = new ValidBinarySearchTree();

        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 3);
        System.out.println(solution.isValidBST(problem));

        problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(2, 1, 3);
        System.out.println(solution.isValidBST(problem));
    }
}
