package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, find its maximum depth.

 The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

 NOTE : The path has to end on a leaf node.
 Example :

   1
  /
 2
 max depth = 2.
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int result = 1;
        if (tn.left != null) {
            result = 1 + maxDepth(tn.left);
        }
        if (tn.right != null) {
            result = Math.max(result, 1 + maxDepth(tn.right));
        }
        return result;
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, -1);
        System.out.println(solution.maxDepth(problem));
    }
}
