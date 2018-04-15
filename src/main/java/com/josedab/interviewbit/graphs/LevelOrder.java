package com.josedab.interviewbit.graphs;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

 Example :
 Given binary tree

      3
     / \
    9  20
   /    \
 15     7
 return its level order traversal as:

 [
   [3],
   [9,20],
   [15,7]
 ]
 Also think about a version of the question where you are asked to do a level order traversal
 of the tree when depth of the tree is much greater than number of nodes on a level.
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode tn) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        List<TreeNode> layerNodes = new ArrayList();
        layerNodes.add(tn);

        ArrayList<Integer> resultLayer = new ArrayList();

        while (!layerNodes.isEmpty()) {
            List<TreeNode> newLayerNodes = new ArrayList();
            resultLayer = new ArrayList();
            for (int i = 0; i < layerNodes.size(); i++) {
                TreeNode treeNode = layerNodes.get(i);
                if (treeNode.left != null) newLayerNodes.add(treeNode.left);
                if (treeNode.right != null) newLayerNodes.add(treeNode.right);
                resultLayer.add(treeNode.val);
            }
            result.add(resultLayer);
            layerNodes = newLayerNodes;
        }

        return result;
    }

    // Official solution
    // Interesting to see how they deal with different layers without intermediary list objects
    public ArrayList<ArrayList<Integer>> levelOrderOfficial(TreeNode tn) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (tn == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(tn);

        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                tn = queue.poll();
                al.add(tn.val);
                if (tn.left != null) queue.add(tn.left);
                if (tn.right != null) queue.add(tn.right);
            }
            res.add(al);
        }

        return res;
    }

    public static void main(String[] args) {
        LevelOrder solution = new LevelOrder();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromPreOrderSequence(3, 9, 20, -1, -1, 15, 7);
        System.out.println(solution.levelOrder(problem));
    }
}
