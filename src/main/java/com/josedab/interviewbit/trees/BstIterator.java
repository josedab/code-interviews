package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 The first call to next() will return the smallest number in BST.
 Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 Try to optimize the additional space complexity apart from the amortized time complexity.


 Approach 1 : Do an inorder traversal of the tree and store the entries in an array with the current
 pointer set to the start of the array. hasNext checks if the pointer is less than the size of the array.
 next() would return the element at the current position incrementing the position by 1.
 However, this has an additional space complexity of O(N) where N = number of nodes in the tree.
 This might be an acceptable answer. Most interviewers would look for you to do better.

 Approach 2 : Lets look at the version of this problem when the trees have a back pointer.
 Can you solve the problem without using additional space ? When you are on node N and
 are asked for next element, you obviously won’t go to the left subtree as all the elements
 there are smaller than N. We would go to the smallest number in the right subtree if
 the right subtree is not null. If the right subtree is null, that means that we need
 to move up, and keep moving up till we are coming from the right subtree.
 Now we don’t have the back pointer in this case. So, we need something to keep track
 of the path from root to the current node, so we can move to the parent when needed.
 Do note that storing the path from root to the current node only requires memory
 equivalent to the length of the path which is the depth of the tree.
 Also, we can track the path using stack.

 This solution is Approach 1. For approach 2 see {@link BstIteratorV2}
 */
public class BstIterator {
    private Stack<Integer> stack;

    public BstIterator(TreeNode root) {
        stack = new Stack<Integer>();
        if (root != null) {
            populateStack(root);
        }
    }

    private void populateStack(TreeNode tn) {
        if (tn.right != null) {
            populateStack(tn.right);
        }
        stack.push(tn.val);
        if (tn.left != null) {
            populateStack(tn.left);
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return stack.pop();
    }

    public static void main(String[] args) {
        BstIterator it = new BstIterator(TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(5, 3, 7, 1, 4, 6, 10));
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
