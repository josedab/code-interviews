package com.josedab.interviewbit.trees;

import com.josedab.interviewbit.model.TreeNode;
import com.josedab.interviewbit.utils.TreeNodeUtils;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 Example :


          _______3______
         /              \
     ___5__          ___1__
    /      \        /      \
    6      _2_     0        8
          /   \
         7    4
 For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor
 Please note that LCA for nodes 5 and 4 is 5.

 You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 There are no duplicate values.
 You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 */
public class LeastCommonAncestor {
    public int lca(TreeNode tn, int a, int b) {
        Stack<TreeNode> stackForA = findStackOfParentsForValue(tn, a);
        Stack<TreeNode> stackForB = findStackOfParentsForValue(tn, b);

        while (stackForA.size() > stackForB.size()) {
            stackForA.pop();
        }

        while (stackForB.size() > stackForA.size()) {
            stackForB.pop();
        }

        while (!stackForA.isEmpty() && !stackForB.isEmpty()) {
            TreeNode tnA = stackForA.pop();
            TreeNode tnB = stackForB.pop();
            if (tnA.val == tnB.val) {
                return tnA.val;
            }
        }

        return -1;
    }

    private Stack<TreeNode> findStackOfParentsForValue(TreeNode tn, int n) {
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> visited = new TreeSet<>();
        if (tn != null) {
            leftBranchDiscovery(tn, stack);
        }
        while (!stack.isEmpty()) {
            TreeNode tnPointer = stack.peek();
            if (tnPointer.val == n) {
                return stack;
            } else {
                if (visited.contains(tnPointer.val)) {
                    stack.pop();
                }
            }
            if (tnPointer.right != null) {
                leftBranchDiscovery(tnPointer.right, stack);
            }
            visited.add(tnPointer.val);
        }
        return stack;
    }

    private void leftBranchDiscovery(TreeNode tn, Stack<TreeNode> stack) {
        while (tn != null) {
            stack.push(tn);
            tn = tn.left;
        }
    }

    public static void main(String[] args) {
        TreeNode problem = TreeNodeUtils.createTreeNodeListFromOrderedNodeLayerSequence(1, 2, 3, 4, 5, 6, 7);
        LeastCommonAncestor solution = new LeastCommonAncestor();
        System.out.println(solution.lca(problem, 4, 3));
    }
}
