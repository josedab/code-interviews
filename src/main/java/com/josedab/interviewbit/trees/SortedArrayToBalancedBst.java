package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Example :


 Given A : [1, 2, 3]
 A height balanced BST  :

   2
  / \
 1   3
 */
public class SortedArrayToBalancedBst {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return buildBst(a, 0, a.size()-1);
    }

    private TreeNode buildBst(final List<Integer> lnodes, int start, int end){
        TreeNode result = null;
        if(start>end){
            result = null;
        }else{
            int middle = (start+end)/2;
            result = new TreeNode(lnodes.get(middle));
            result.left = buildBst(lnodes, start, middle-1);
            result.right = buildBst(lnodes, middle+1, end);
        }
        return result;
    }

    public static void main(String []args){
        SortedArrayToBalancedBst solution = new SortedArrayToBalancedBst();
        TreeNode tn = solution.sortedArrayToBST(Arrays.asList(1,2,3,4,5));
        System.out.println(TreeNodeUtils.getNodesInOrderTraversal(tn));
    }
}
