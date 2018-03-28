package com.josedab.interviewbit.utils;

import com.josedab.interviewbit.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class TreeNodeUtils {

    public static TreeNode createTreeNodeListFromInOrderSequence(int... arrayOfIntegers) {
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

}
