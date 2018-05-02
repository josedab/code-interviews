package com.josedab.interviewbit.dynamicProgramming;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 Example :

 Given the below binary tree,

   1
  / \
 2   3
 Return 6.
 */
public class MaxSumPathInBinaryTree {


    public int maxPathSum(TreeNode tn) {
        Result res = new Result();
        maxPathSumWithRes(tn, res);
        return res.value;
    }

    private int maxPathSumWithRes(TreeNode tn, Result res) {

        if (tn == null) {
            return 0;
        } else {
            int lsum = 0;
            int rsum = 0;
            if (tn.left != null) {
                lsum = maxPathSumWithRes(tn.left, res);
            }
            if (tn.right != null) {
                rsum = maxPathSumWithRes(tn.right, res);
            }
            int resultPath = Math.max(tn.val, tn.val + Math.max(lsum + rsum, Math.max(lsum, rsum)));
            res.value = Math.max(res.value, resultPath);
            return tn.val + Math.max(lsum, rsum);
        }
    }

    private class Result {
        int value = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        MaxSumPathInBinaryTree solution = new MaxSumPathInBinaryTree();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 3);
        System.out.println(solution.maxPathSum(problem));
    }
}
