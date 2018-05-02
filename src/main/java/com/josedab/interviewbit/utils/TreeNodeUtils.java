package com.josedab.interviewbit.utils;

import com.josedab.interviewbit.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeUtils {

    public static TreeNode createTreeNodeListFromOrderedNodeLayerSequence(int... arrayOfIntegers) {
        TreeNode result = null;
        int indexOfParents = 0;
        List<TreeNode> queue = new LinkedList<TreeNode>();

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            TreeNode tn = (arrayOfIntegers[i] == -1) ? null : new TreeNode(arrayOfIntegers[i]);

            if (queue.isEmpty()) {
                // First element
                result = tn;
                queue.add(tn);
            } else {
                TreeNode tnLeft = tn;
                i++;
                TreeNode tnRight = (arrayOfIntegers[i] == -1) ? null : new TreeNode(arrayOfIntegers[i]);
                TreeNode parent = queue.get(indexOfParents);
                parent.left = tnLeft;
                parent.right = tnRight;
                indexOfParents++;

                if (tnLeft != null) {
                    queue.add(tnLeft);
                }

                if (tnRight != null) {
                    queue.add(tnRight);
                }

            }

        }
        return result;
    }

    public static ArrayList<Integer> getNodesOrderedByLayers(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A != null) {
            preorderTraversalHelper(A, result);
        }
        return result;

    }

    private static void preorderTraversalHelper(TreeNode tn, ArrayList<Integer> result) {
        result.add(tn.val);
        if (tn.left != null) {
            preorderTraversalHelper(tn.left, result);
        }
        if (tn.right != null) {
            preorderTraversalHelper(tn.right, result);
        }
    }

    public static ArrayList<Integer> getNodesInOrderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A != null) {
            inorderTraversalHelper(A, result);
        }
        return result;

    }

    private static void inorderTraversalHelper(TreeNode tn, List<Integer> result) {
        if (tn.left != null) {
            inorderTraversalHelper(tn.left, result);
        }
        result.add(tn.val);
        if (tn.right != null) {
            inorderTraversalHelper(tn.right, result);
        }
    }

}
