package com.chuli.solution.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kk
 * @Date: 2022-01-29 16:48
 */
public class Solution1_two_sum {

    public int[] twoSUm(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution1_two_sum solution1_two_sum = new Solution1_two_sum();
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] ret = solution1_two_sum.twoSUm(nums, target);
        for (int i :
             ret) {
            System.out.println(i);
        }
    }
}
