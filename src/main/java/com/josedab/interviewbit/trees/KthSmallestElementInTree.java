package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

/**
 * Given a binary search tree, write a function to find the kth smallest element in the tree.

 Example :

 Input :
    2
   / \
  1   3

 and k = 2

 Return : 2

 As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST

 Official solution
 For improved solution see @{@link KthSmallestElementInTreeRecursion} and {@link KthSmallestElementInTreeStack}
 */
public class KthSmallestElementInTree {
    public int kthsmallest(TreeNode root, int nthLowest) {
        if (root == null) {
            return 1;
        }
        int nLeftElements = elementsInTree(root.left);
        if (nthLowest > nLeftElements) {
            if (nthLowest == nLeftElements + 1) {
                return root.val;
            } else {
                return kthsmallest(root.right, nthLowest - nLeftElements - 1);
            }

        } else if (nthLowest <= nLeftElements) {
            return kthsmallest(root.left, nthLowest);

        }
        return -1;
    }

    public int elementsInTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int result = 0;
        if (root.left != null) {
            result += elementsInTree(root.left) + 1;
        }

        if (root.right != null) {
            result += elementsInTree(root.right) + 1;

        }
        return result;
    }

    public static void main(String[] args) {
        KthSmallestElementInTree solution = new KthSmallestElementInTree();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromPreOrderSequence(2, 1, 3);
        System.out.println(solution.kthsmallest(problem, 2));
    }
}
