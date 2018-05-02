package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;

/**
 * Given a binary tree, return the postorder traversal of its nodes’ values.

 Example :

 Given binary tree

  1
   \
   2
  /
 3
 return [3,2,1].
 */
public class PostOrderTraversalRecursive {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A != null) {
            postOrderTraversalAux(A, result);
        }
        return result;

    }

    private void postOrderTraversalAux(TreeNode tn, ArrayList<Integer> result) {
        if (tn.left != null) {
            postOrderTraversalAux(tn.left, result);
        }
        if (tn.right != null) {
            postOrderTraversalAux(tn.right, result);
        }
        result.add(tn.val);
    }

    public static void main(String[] args) {
        PostOrderTraversalRecursive solution = new PostOrderTraversalRecursive();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, -1, 2, 3, -1);
        System.out.println(solution.postorderTraversal(problem));
    }
}
