package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.

 Example :
 Given


      1
     / \
    2   5
   / \   \
 3   4   6
 The flattened tree should look like:

 1
  \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 Note that the left child of all nodes should be NULL.
 */
public class FlattenBinaryTreeToLinkedList {
    public TreeNode flatten(TreeNode a) {
        TreeNode preSolution = new TreeNode(-1);
        TreeNode pointerSolution = preSolution;
        TreeNode pointer = a;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (a != null) {
            stack.push(a);
        }
        while (!stack.isEmpty()) {
            TreeNode element = stack.pop();
            pointerSolution.right = new TreeNode(element.val);
            pointerSolution = pointerSolution.right;
            if (element.right != null) stack.push(element.right);
            if (element.left != null) stack.push(element.left);
        }
        return preSolution.right;
    }

    public static void main(String []args){
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 5, 3, 4, -1, 6);
        System.out.println(TreeNodeUtils.getNodesOrderedByLayers(solution.flatten(problem)));
    }
}
