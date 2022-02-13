package com.chuli.solution;

/**
 * @Author: kk
 * @Date: 2021-12-27 17:02
 */
public class Solution44 {

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.solution1("I am a coder"));
    }

    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/java-shuang-zhi-zhen-yyds-by-shi-guang-c-2fcv/
     * 定义两个指针 i，j;
     * i保存单词起始端（实际i存的是单词起始端前的空格位置 i+1才是单词起始端）
     * j记录单词尾端
     * 使用substring()分离单词 此处注意substring方法中 endindex是不包含的所以用的j+1；
     * @param words
     * @return
     */
    public String solution1(String words) {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        while (words.charAt(start) == ' ') {
            start++;
        }
        int len = words.length();
        for (int i = len - 1; i >= start; i--) {
            int j = i;
            while (i >= 0 && words.charAt(i) != ' ') {
                i--;
            }
            if (i != j) {
                sb.append(words.substring(i + 1, j + 1));
                if (i > start) {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }
}
