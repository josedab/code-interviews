package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Stack;

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

 Solution: not recursive. For recursive solution see {@link PostOrderTraversalRecursive}
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode tn) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lastNode = null;
        while (!stack.isEmpty() || tn != null) {
            if (tn != null) {
                stack.push(tn);
                tn = tn.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastNode != peekNode.right) {
                    tn = peekNode.right;
                } else {
                    result.add(peekNode.val);
                    lastNode = stack.pop();
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        PostOrderTraversal solution = new PostOrderTraversal();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 3, 4, 5, 6, 7);
        System.out.println(solution.postorderTraversal(problem));
    }
}
