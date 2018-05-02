package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Example :

 Input :

   1       1
  / \     / \
 2   3   2   3

 Output :
 1 or True
 */
public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        return isSameTreeAux(A, B) ? 1 : 0;
    }

    private boolean isSameTreeAux(TreeNode a, TreeNode b) {
        if (a == null & b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            return a.val == b.val
                    && isSameTreeAux(a.left, b.left)
                    && isSameTreeAux(a.right, b.right);
        }
    }

    public static void main(String[] args) {
        IdenticalBinaryTrees solution = new IdenticalBinaryTrees();

        TreeNode treeProblem1 = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(3, 4, 5, 6, -1, -1, -1);
        TreeNode treeProblem2 = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(3, 4, 5, 6, -1, -1, -1);
        System.out.println(solution.isSameTree(treeProblem1, treeProblem2));

        treeProblem1 = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(3, 4, 5, 6, 2, -1, -1);
        treeProblem2 = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(3, 4, 5, 6, -1, -1, -1);
        System.out.println(solution.isSameTree(treeProblem1, treeProblem2));
    }
}
