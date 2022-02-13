package com.chuli.solution.top100;

/**
 * @Author: kk
 * @Date: 2022-02-05 11:27
 */
public class Solution2_add_two_num {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2= new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution2_add_two_num solution2_add_two_num = new Solution2_add_two_num();
        ListNode result = solution2_add_two_num.addTwoNum(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("error input listNode");
        }

        int high = 0;
        int low = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int tmp = val1 + val2 + high;
            high = tmp / 10;
            low = tmp % 10;

            cur.next = new ListNode(low);
            cur = cur.next;
        }
        if (high == 1) {
            cur.next = new ListNode(high);
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}