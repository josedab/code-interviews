package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,

       5
      / \
     4   8
    /   / \
   11  13  4
  /  \    / \
 7    2  5   1
 return

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class RoofToLeafPathsWithSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        List<Integer> partialResult = new LinkedList<>();
        pathSumAux(A, B, partialResult, results);
        return results;
    }

    private void pathSumAux(TreeNode tn, int b, List<Integer> partialResult, ArrayList<ArrayList<Integer>> results) {
        if (tn.left == null && tn.right == null) {
            if (b == tn.val) {
                ArrayList<Integer> result = new ArrayList<Integer>(partialResult);
                result.add(tn.val);
                results.add(result);
            }
        } else {

            partialResult.add(tn.val);

            if (tn.left != null) pathSumAux(tn.left, b - tn.val, partialResult, results);
            if (tn.right != null) pathSumAux(tn.right, b - tn.val, partialResult, results);

            partialResult.remove(partialResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        RoofToLeafPathsWithSum solution = new RoofToLeafPathsWithSum();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1);
        System.out.println(solution.pathSum(problem, 22));
    }
}
