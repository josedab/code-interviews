package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree.
 Example :

 Input :
 Inorder : [2, 1, 3]
 Postorder : [2, 3, 1]

 Return :
   1
  / \
 2   3

 */
public class BinaryTreeFromInOrderAndPostOrder {

    public TreeNode buildTree(List<Integer> inOrder, List<Integer> postOrder) {
        int[] index = {postOrder.size() - 1};
        return build(index, 0, inOrder.size() - 1, inOrder, postOrder);

    }

    private TreeNode build(int[] index, int start, int end, List<Integer> inOrder, List<Integer> postOrder) {
        if (start > end || index[0] >= postOrder.size()) {
            return null;
        }
        for (int i = end; i >= start; i--) {
            if (inOrder.get(i).intValue() == postOrder.get(index[0]).intValue()) {
                TreeNode node = new TreeNode(inOrder.get(i));
                index[0]--;
                node.right = build(index, i + 1, end, inOrder, postOrder);
                node.left = build(index, start, i - 1, inOrder, postOrder);
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeFromInOrderAndPostOrder solution = new BinaryTreeFromInOrderAndPostOrder();
        List<Integer> inOrder = Arrays.asList(2, 1, 3);
        List<Integer> postOrder = Arrays.asList(2, 3, 1);
        System.out.println(TreeNodeUtils.getNodesOrderedByLayers(solution.buildTree(inOrder, postOrder)));

    }

}
