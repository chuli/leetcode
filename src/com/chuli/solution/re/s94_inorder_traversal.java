package com.chuli.solution.re;

import com.chuli.solution.base.TreeNode;

import java.util.*;

/**
 * @Author: kk
 * @Date: 2022-02-13 09:33
 */
public class s94_inorder_traversal {

    public static void main(String[] args) {
        s94_inorder_traversal s94_inorder_traversal = new s94_inorder_traversal();
        TreeNode node1 = new TreeNode(1);
        node1.setRight(new TreeNode(2));
        node1.getRight().setLeft(new TreeNode(3));
        List<Integer> res1 = s94_inorder_traversal.inordertraversal(node1);
        System.out.println(res1);
    }

    public List<Integer> inordertraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        map.put(root, 1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (map.get(node) == 1) {
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    map.put(node.getRight(), 1);
                }
                stack.push(node);
                map.put(node, 2);
                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                    map.put(node.getLeft(), 1);
                }
            } else {
                res.add(node.getVal());
            }
        }
        return res;
    }


    public List<Integer> inordertraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            inorder(root, res);
        }
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft(), res);
        res.add(root.getVal());
        inorder(root.getRight(), res);
    }
}
