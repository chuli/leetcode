package com.chuli.solution.top100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: kk
 * @Date: 2022-02-13 11:06
 */
public class Solution114_flatten {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        right1.left = new TreeNode(15);
        right1.right = new TreeNode(7);
        root.right = right1;

        Solution114_flatten solution114_flatten = new Solution114_flatten();
        solution114_flatten.flatten(root);
        System.out.println(root);
    }

    public void flatten(TreeNode root) {
        TreeNode node = root;
        Queue<Integer> queue = new ArrayDeque<>();
        preorder(root, queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            node.val = queue.poll();
            if (queue.size() > 0) {
                node.right = new TreeNode();
                node.left = null;
                node = node.right;
            }
        }
    }

    private void preorder(TreeNode node, Queue<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}
