package com.chuli.solution.top100;

import java.util.*;

/**
 * @Author: kk
 * @Date: 2022-02-11 10:42
 */
public class Solution94_inorder_traversal {

    public static void main(String[] args) {
        Solution94_inorder_traversal solution94_inorder_traversal = new Solution94_inorder_traversal();
        TreeNode node1 = new TreeNode(1);
        node1.right = new TreeNode(2);
        node1.right.left = new TreeNode(3);
        List<Integer> res1 = solution94_inorder_traversal.inordertraversal(node1);
        System.out.println(res1);
    }

    public List<Integer> inordertraversal(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        map.put(root, 1);

        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            if (map.get(node) == 1) {
                if (node.right != null) {
                    stack.push(node.right);
                    map.put(node.right, 1);
                }
                stack.push(node);
                map.put(node, 2);
                if (node.left != null) {
                    stack.push(node.left);
                    map.put(node.left, 1);
                }
            } else {
                res.add(node.val);
            }
        }
        return res;
    }


    public List<Integer> inordertraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


