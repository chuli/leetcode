package com.chuli.solution.top100;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kk
 * @Date: 2022-02-07 14:47
 */
public class Solution3_longest_substr {

    public static void main(String[] args) {
        Solution3_longest_substr solution3_longest_substr = new Solution3_longest_substr();
        String s = "dvdf";
        int maxLength = solution3_longest_substr.lengthOfLongestSubstring(s);
        System.out.println(maxLength);

        String s1 = "abcabcbb";
        int maxLength1 = solution3_longest_substr.lengthOfLongestSubstring(s1);
        System.out.println(maxLength1);

        String s2 = "bbbb";
        int maxLength2 = solution3_longest_substr.lengthOfLongestSubstring(s2);
        System.out.println(maxLength2);

        String s3 = "";
        int maxLength3 = solution3_longest_substr.lengthOfLongestSubstring(s3);
        System.out.println(maxLength3);

        String s4 = "pwwkew";
        int maxLength4 = solution3_longest_substr.lengthOfLongestSubstring(s4);
        System.out.println(maxLength4);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        StringBuilder tmp = new StringBuilder();
        int tmpMax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (tmp.toString().contains(s.substring(i, i + 1))) {
                if (tmp.length() > tmpMax) {
                    tmpMax = tmp.length();
                }
                tmp.delete(0, tmp.indexOf(s.substring(i, i + 1)) + 1);
            }
            tmp.append(s.substring(i, i + 1));
        }
        if (tmp.length() > tmpMax) {
            tmpMax = tmp.length();
        }
        return tmpMax;
    }
}
