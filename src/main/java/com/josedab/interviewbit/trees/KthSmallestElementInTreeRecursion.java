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

 Solution proposed. I think it is better than official one as it goes through the elements only once and stops
 once it finds the element.
 In solution @{@link KthSmallestElementInTree} there are edge cases where they go through more elements than necessary
 and they dont't take advantage of the inherent properties of a BST.

 TODO:
 Work on a benchmark
 */
public class KthSmallestElementInTreeRecursion {

    private class Counter {
        int count = 1;

        public Counter(int count) {
            this.count = count;
        }

        public int increaseCounter() {
            this.count++;
            return this.count;
        }

    }

    public int kthsmallest(TreeNode treeNode, int nthIndex) {
        Counter c = new Counter(1);
        return kthsmallest(treeNode, c, nthIndex);
    }

    private int kthsmallest(TreeNode treeNode, Counter counter, int nthIndex) {
        int result = -1;
        if (treeNode != null) {

            if (treeNode.left != null) {
                result = kthsmallest(treeNode.left, counter, nthIndex);
            }

            int count = counter.increaseCounter();
            if (result != -1) {
                return result;
            } else if (count == nthIndex) {
                return treeNode.val;
            }

            if (treeNode.right != null) {
                result = kthsmallest(treeNode.right, counter, nthIndex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KthSmallestElementInTreeRecursion solution = new KthSmallestElementInTreeRecursion();
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(2, 1, 3);
        System.out.println(solution.kthsmallest(problem, 2));
    }
}
