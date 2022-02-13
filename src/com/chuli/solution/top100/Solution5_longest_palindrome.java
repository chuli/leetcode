package com.chuli.solution.top100;

/**
 * @Author: kk
 * @Date: 2022-02-08 18:54
 */
public class Solution5_longest_palindrome {

    public static void main(String[] args) {
        Solution5_longest_palindrome solution5_longest_palindrome = new Solution5_longest_palindrome();
        String s1 = "babad";
        String ret1 = solution5_longest_palindrome.longestPalindrome(s1);
        System.out.println(ret1);

        String s2 = "cbbd";
        String ret2 = solution5_longest_palindrome.longestPalindrome(s2);
        System.out.println(ret2);

        String s3 = "a";
        String ret3 = solution5_longest_palindrome.longestPalindrome(s3);
        System.out.println(ret3);

        String s4 = "ac";
        String ret4 = solution5_longest_palindrome.longestPalindrome(s4);
        System.out.println(ret4);
    }

    public String longestPalindrome(String s) {
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >=0 && s.charAt(i) == s.charAt(left)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(i) == s.charAt(right)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
