package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

 Example :
 Given binary tree

      3
     / \
    9  20
      /  \
    15   7
 return

 [
 [3],
 [20, 9],
 [15, 7]
 ]
 */
public class ZigZagLevelOrderTraversalBT {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<TreeNode> nodeList = new LinkedList<TreeNode>();

        if (A != null) {
            nodeList.add(A);
            ArrayList<Integer> firstLayer = new ArrayList<Integer>();
            firstLayer.add(A.val);
            result.add(firstLayer);
        }

        int layer = 2;
        while (!nodeList.isEmpty()) {
            List<TreeNode> previousNodeList = nodeList;
            nodeList = new LinkedList<TreeNode>();
            for (int i = 0; i < previousNodeList.size(); i++) {
                TreeNode node = previousNodeList.get(i);
                if (node.left != null) nodeList.add(node.left);
                if (node.right != null) nodeList.add(node.right);
            }

            ArrayList<Integer> resultLayer = new ArrayList<Integer>();
            for (int i = 0; i < nodeList.size(); i++) {
                TreeNode node = nodeList.get((layer % 2 == 0) ? (nodeList.size() - 1 - i) : i);
                resultLayer.add(node.val);
            }
            if (!resultLayer.isEmpty()) {
                result.add(resultLayer);
            }
            layer++;

        }

        return result;

    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversalBT solution = new ZigZagLevelOrderTraversalBT();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(3, 9, 20, -1, -1, 15, 7);
        System.out.println(solution.zigzagLevelOrder(problem));
    }

}
