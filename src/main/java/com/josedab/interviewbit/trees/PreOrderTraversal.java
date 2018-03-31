package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Stack;

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

 Solution: not recursive. For recursive solution see @{@link PreOrderTraversalRecursive}
 */
public class PreOrderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (A != null) {
            stack.push(A);
        }
        while (!stack.isEmpty()) {
            TreeNode pointer = stack.pop();
            result.add(pointer.val);
            if (pointer.right != null) stack.push(pointer.right);
            if (pointer.left != null) stack.push(pointer.left);
        }
        return result;
    }

    public static void main(String[] args) {
        PreOrderTraversal solution = new PreOrderTraversal();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromPreOrderSequence(1, 2, 3, 4, 5, 6, 7);
        System.out.println(solution.preorderTraversal(problem));
    }
}
