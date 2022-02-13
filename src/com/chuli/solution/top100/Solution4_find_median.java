package com.chuli.solution.top100;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: kk
 * @Date: 2022-02-07 15:48
 */
public class Solution4_find_median {

    public static void main(String[] args) {
        Solution4_find_median solution4_find_median = new Solution4_find_median();
//        int[] num1 = {0, 0, 0, 0, 0};
//        int[] num2 = {-1, 0, 0, 0, 0, 0, 1};
//        int[] num1 = {1, 2};
//        int[] num2 = {3, 4};
//        int[] num1 = {1, 3};
//        int[] num2 = {2};
//        int[] num1 = {};
//        int[] num2 = {2};
        int[] num1 = {2, 2, 4, 4};
        int[] num2 = {2, 2, 4, 4};
        double ret = solution4_find_median.findMedianSortedArrays(num1, num2);
        System.out.println(ret);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        Map<Integer, Integer> map = new TreeMap<>();

        int mapCount = 0;

        for (int i = 0; i < length1; i++) {
            int value = 1;
            if (map.containsKey(nums1[i])) {
                value += map.get(nums1[i]);
            }
            map.put(nums1[i], value);
            mapCount++;
        }

        for (int j = 0; j < length2; j++) {
            int value = 1;
            if (map.containsKey(nums2[j])) {
                value += map.get(nums2[j]);
            }
            map.put(nums2[j], value);
            mapCount++;
        }

        int tmpMedia = 0;
        int left = 0;
        boolean flag = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tmpMedia += entry.getValue();
            if (mapCount % 2 != 0) {
                if (tmpMedia >= mapCount / 2 + 1) {
                    return (float)entry.getKey();
                }
            } else {

                int right = 0;
                if (flag && tmpMedia >= mapCount / 2) {
                    left = entry.getKey();
                    flag = false;
                }
                if (tmpMedia >= mapCount / 2 + 1) {
                    right = entry.getKey();
                    return (float)(left + right) / 2;
                }
            }
        }
        return 0;
    }


    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        double median = 0;
        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        if (length1 == 0) {
            median = (float)(((nums2[(length2 + 1) / 2 - 1]) + nums2[length2 / 2])) / 2;
            return median;
        }
        if (length2 == 0) {
            median = (float)(((nums1[(length1 + 1) / 2 - 1]) + nums1[length1 / 2])) / 2;
            return median;
        }

        int tmpInitLength = Math.max(length1 + length2, nums1[length1 - 1] + nums2[length2 - 1]);
        int[] tmp = new int[tmpInitLength];

        for (int i = 0; i < length1; i++) {
            tmp[nums1[i]] = nums1[i];
        }
        for (int j = 0; j < length2; j++) {
            tmp[nums2[j]] = nums2[j];
        }

        if (tmp.length % 2 == 0) {
            median = (float) (tmp[tmp.length / 2] + tmp[tmp.length / 2 - 1]) / 2;
        } else {
            median = (float) (tmp[tmp.length / 2]);
        }
        return median;
    }
}
