package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 Example :


          _______3______
         /              \
     ___5__          ___1__
    /      \        /      \
    6      _2_     0        8
          /   \
         7    4
 For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
 Please note that LCA for nodes 5 and 4 is 5.

 You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 There are no duplicate values.
 You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.

 Solution: recursive. For iterative solution with a stack, see {@link LeastCommonAncestor}
 */
public class LeastCommonAncestorRecursive {

    public int lca(TreeNode tn, int a, int b) {

        if (tn == null) {
            return -1;
        }
        boolean v1 = checkIfValueExists(tn, a);
        boolean v2 = checkIfValueExists(tn, b);

        if (v1 && v2) {
            return lcaAlgorithm(tn, a, b);
        }
        return -1;
    }

    private int lcaAlgorithm(TreeNode tn, int a, int b) {

        if (tn == null) {
            return -1;
        }

        if (tn.val == a || tn.val == b) {
            return tn.val;
        }

        int leftResult = lcaAlgorithm(tn.left, a, b);
        int rightResult = lcaAlgorithm(tn.right, a, b);

        if (leftResult != -1 && rightResult != -1) {
            // Solution or not found
            return (leftResult == rightResult) ? leftResult : tn.val;
        } else if (leftResult != -1) {
            return leftResult;
        } else {
            return rightResult;
        }
    }

    private boolean checkIfValueExists(TreeNode a, int val) {
        if (a != null && a.val == val) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return checkIfValueExists(a.left, val) || checkIfValueExists(a.right, val);
    }

    public static void main(String[] args) {
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 3, 4, 5, 6, 7);
        LeastCommonAncestorRecursive solution = new LeastCommonAncestorRecursive();
        System.out.println(solution.lca(problem, 4, 3));
        System.out.println(solution.lca(problem, 4, 30));
    }
}
