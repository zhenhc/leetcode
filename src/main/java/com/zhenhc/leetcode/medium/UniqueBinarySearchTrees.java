package com.zhenhc.leetcode.medium;


import com.zhenhc.leetcode.data.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees binarySearchTrees = new UniqueBinarySearchTrees();
        List<TreeNode> treeNodeList = binarySearchTrees.generateTrees(3);
        for (TreeNode treeNode : treeNodeList){
            System.out.println(TreeNode.sequenceTraverse(treeNode));
        }
    }
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<TreeNode>();
        }
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
