package com.chuli.solution.top100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: kk
 * @Date: 2022-02-13 09:52
 */
public class Solution102_levelOrder {

    public static void main(String[] args) {
        Solution102_levelOrder solution102_levelOrder = new Solution102_levelOrder();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        right1.left = new TreeNode(15);
        right1.right = new TreeNode(7);
        root.right = right1;

        List<List<Integer>> res = solution102_levelOrder.levelOrder1(root);
        System.out.println(res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int queueSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(1, root, res);
        return res;
    }

    private void dfs(int index, TreeNode node, List<List<Integer>> res) {
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        res.get(index - 1).add(node.val);
        if (node.left != null) {
            dfs(index + 1, node.left, res);
        }
        if (node.right != null) {
            dfs(index + 1, node.right, res);
        }
    }
}
