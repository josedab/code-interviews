package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Example :

 Input :
   1
  / \
 2   3

 Return : True or 1

 Input 2 :
     3
    /
   2
  /
 1

 Return : False or 0
 Because for the root node, left subtree has depth 2 and right subtree has depth 0.
 Difference = 2 > 1.

 Solution: O(n)
 Depth auxiliary method calculates if we should still calculate depth of the node
 and if the right and left are balanced.
 It also avoids extra calculation.
 */
public class BalancedBinaryTree {

    private static final int NO_BALANCED_DEPTH = -1;

    public int isBalanced(TreeNode A) {
        return balancedDepth(A) != -1 ? 1 : 0;
    }

    private int balancedDepth(TreeNode tn) {
        if (tn == null) {
            return 0;
        } else {
            int depthLeft = balancedDepth(tn.left);
            if (depthLeft == NO_BALANCED_DEPTH) {
                return NO_BALANCED_DEPTH;
            }
            int depthRight = balancedDepth(tn.right);
            if (depthRight == NO_BALANCED_DEPTH) {
                return NO_BALANCED_DEPTH;
            }
            int result = (Math.abs(depthRight - depthLeft) <= 1) ?
                    1 + Math.max(depthRight, depthLeft) : NO_BALANCED_DEPTH;
            return result;
        }
    }

    public static void main(String []args){
        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println(solution.isBalanced(TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2,3)));
        System.out.println(solution.isBalanced(TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(3, 2, -1, 1, -1)));

    }
}
