package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;

/**
 * Given a binary tree, return the preorder traversal of its nodes’ values.

 Example :
 Given binary tree

  1
   \
   2
  /
 3
 return [1,2,3].
 */
public class PreOrderTraversalRecursive {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A != null) {
            preorderTraversalAux(A, result);
        }
        return result;

    }

    private void preorderTraversalAux(TreeNode tn, ArrayList<Integer> result) {
        result.add(tn.val);
        if (tn.left != null) {
            preorderTraversalAux(tn.left, result);
        }
        if (tn.right != null) {
            preorderTraversalAux(tn.right, result);
        }
    }

    public static void main(String[] args) {
        PreOrderTraversalRecursive solution = new PreOrderTraversalRecursive();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromPreOrderSequence(1, -1, 2, 3, -1);
        System.out.println(solution.preorderTraversal(problem));
    }
}
