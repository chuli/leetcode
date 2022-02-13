package com.chuli.solution.top100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: kk
 * @Date: 2022-02-13 10:42
 */
public class Solution104_max_depth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        right1.left = new TreeNode(15);
        right1.right = new TreeNode(7);
        root.right = right1;

        Solution104_max_depth solution104_max_depth = new Solution104_max_depth();
        int res1 = solution104_max_depth.maxDepth1(root);
        System.out.println(res1);
    }

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDepth = Math.max(left, right) + 1;
        return maxDepth;
    }

    public int maxDepth1(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
