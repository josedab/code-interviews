package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.

 Example :
 Given binary tree

  1
   \
   2
  /
 3
 return [1,3,2].

 */
public class InorderTraversalRecursive {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrderAux(A, result);
        return result;
    }

    private void inOrderAux(TreeNode tn, List<Integer> result) {
        if (tn.left != null) {
            inOrderAux(tn.left, result);
        }
        result.add(tn.val);
        if (tn.right != null) {
            inOrderAux(tn.right, result);
        }
    }

    private boolean isLeaf(TreeNode tn) {
        return tn.left == null && tn.right == null;
    }

    public static void main(String[] args) {
        InorderTraversalRecursive solution = new InorderTraversalRecursive();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromInOrderSequence(1, -1, 2, 3, -1);
        System.out.println(solution.inorderTraversal(problem));
    }
}
