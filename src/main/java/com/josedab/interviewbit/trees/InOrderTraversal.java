package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

 Solution: not recursive. For recursive solution see {@link InOrderTraversalRecursive}
 */
public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode tn) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (tn != null) {
            leftBranchDiscovery(tn, stack);
        }
        while (!stack.isEmpty()) {
            TreeNode tnPointer = stack.pop();
            result.add(tnPointer.val);
            if (tnPointer.right != null) {
                leftBranchDiscovery(tnPointer.right, stack);
            }
        }
        return result;
    }

    private void leftBranchDiscovery(TreeNode tn, Stack<TreeNode> stack) {
        while (tn != null) {
            stack.push(tn);
            tn = tn.left;
        }
    }

    public static void main(String[] args) {
        InOrderTraversal solution = new InOrderTraversal();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromPreOrderSequence(1, 2, 3, 4, 5, 6, 7);
        System.out.println(solution.inorderTraversal(problem));
    }
}
