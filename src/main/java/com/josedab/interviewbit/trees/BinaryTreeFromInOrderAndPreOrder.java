package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
 Example :

 Input :
 Preorder : [1, 2, 3]
 Inorder  : [2, 1, 3]

 Return :
   1
  / \
 2   3
 */
public class BinaryTreeFromInOrderAndPreOrder {

    public TreeNode buildTree(List<Integer> preOrder, List<Integer> inOrder) {

        TreeNode root = null;
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        for (int preOrderIdx = 0, in = 0; preOrderIdx < preOrder.size(); ) {

            TreeNode node = null;
            do {
                node = new TreeNode(preOrder.get(preOrderIdx));
                if (root == null) {
                    root = node;
                }
                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    } else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);
            } while (preOrder.get(preOrderIdx++).intValue() != inOrder.get(in).intValue() && preOrderIdx < preOrder.size());

            node = null;
            while (!stack.isEmpty() && in < inOrder.size() && stack.peek().val == inOrder.get(in).intValue()) {
                node = stack.pop();
                in++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInOrderAndPreOrder solution = new BinaryTreeFromInOrderAndPreOrder();
        List<Integer> preOrder = Arrays.asList(1, 2, 3);
        List<Integer> inOrder = Arrays.asList(2, 1, 3);
        System.out.println(TreeNodeUtils.getNodesOrderedByLayers(solution.buildTree(preOrder, inOrder)));

    }

}
