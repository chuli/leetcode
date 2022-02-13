package com.chuli.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kk
 * @Date: 2021-12-24 18:04
 */

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
 */

public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
//        int result = solution46.solution1(5, 3);
        int result = solution46.solution2(5, 3);
        System.out.println(result);
    }

    /**
     * 假设当前删除的位置是 idxidx，下一个删除的数字的位置是 idx + midx+m 。但是，由于把当前位置的数字删除了，后面的数字会前移一位，所以实际的下一个位置是 idx + m -
     * 1idx+m−1。由于数到末尾会从头继续数，所以最后取模一下，就是 (idx + m - 1) \pmod n(idx+m−1)(modn)。
     * @param n
     * @param m
     * @return
     */
    public int solution1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * 最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素），
     * 所以如果我们可以推出上一轮次中这个num的下标，然后根据上一轮num的下标推断出上上一轮num的下标，
     * 直到推断出元素个数为n的那一轮num的下标，那我们就可以根据这个下标获取到最终的元素了。推断过程如下：
     *
     * 首先最后一轮中num的下标一定是0， 这个是已知的。
     * 那上一轮应该是有两个元素，此轮次中 num 的下标为 (0 + m)%n = (0+3)%2 = 1; 说明这一轮删除之前num的下标为1；
     * 再上一轮应该有3个元素，此轮次中 num 的下标为 (1+3)%3 = 1；说明这一轮某元素被删除之前num的下标为1；
     * 再上一轮应该有4个元素，此轮次中 num 的下标为 (1+3)%4 = 0；说明这一轮某元素被删除之前num的下标为0；
     * 再上一轮应该有5个元素，此轮次中 num 的下标为 (0+3)%5 = 3；说明这一轮某元素被删除之前num的下标为3；
     * ....
     *
     * 因为我们要删除的序列为0-n-1, 所以求得下标其实就是求得了最终的结果。比如当n 为5的时候，num的初始下标为3，
     *  所以num就是3，也就是说从0-n-1的序列中， 经过n-1轮的淘汰，3这个元素最终存活下来了，也是最终的结果。
     *
     * 总结一下推导公式：(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标
     * @param n
     * @param m
     * @return
     */
    public int solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
