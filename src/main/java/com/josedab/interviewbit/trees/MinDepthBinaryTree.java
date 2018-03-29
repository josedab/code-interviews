package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 NOTE : The path has to end on a leaf node.
 Example :

   1
  /
 2
 min depth = 2.
 */
public class MinDepthBinaryTree {
    public int minDepth(TreeNode A) {
        if (A == null) {
            return -1;
        } else if (A.left == null && A.right == null) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        if (A.left != null) {
            result = Math.min(result, 1 + minDepth(A.left));
        }
        if (A.right != null) {
            result = Math.min(result, 1 + minDepth(A.right));
        }
        return result;
    }

    public static void main(String[] args) {
        MinDepthBinaryTree solution = new MinDepthBinaryTree();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromInOrderSequence(1, 2, -1);
        System.out.println(solution.minDepth(problem));
    }

}
