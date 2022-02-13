package com.chuli.solution.top100;

/**
 * @Author: kk
 * @Date: 2022-02-09 15:16
 */
public class Solution6_convert {

    public static void main(String[] args) {
        Solution6_convert solution6_convert = new Solution6_convert();
//        String s1 = "PAYPALISHIRING";
//        int numRows1 = 3;
//        String ret1 = solution6_convert.convert(s1, numRows1);
//        System.out.println(ret1);
//
//        String s2 = "PAYPALISHIRING";
//        int numRows2 = 4;
//        String ret2 = solution6_convert.convert(s2, numRows2);
//        System.out.println(ret2);

        String s3 = "ABCD";
        int numRows3 = 2;
        String ret3 = solution6_convert.convert(s3, numRows3);
        System.out.println(ret3);
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        int strLen = s.length();
        int arrLen = Math.min(numRows, strLen);
        String[] formatChar = new String[arrLen];
        for (int i = 0; i < arrLen; i++) {
            formatChar[i] = "";
        }
        boolean down = false;
        int loc = 0;

        for (int i = 0; i < strLen; i++) {
            formatChar[loc] += s.charAt(i);
            if (loc == 0 || loc == numRows - 1) {
                down = !down;
            }
            loc += down ? 1 : -1;
        }

        String res = "";
        for (String row : formatChar) {
            res += row;
        }
        return res;
    }

    public String convert1(String s, int numRows) {
        if (s.isEmpty()) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        int strLen = s.length();

        int tmpCnt = 0;
        int cel = 0;
        boolean needPlus = true;
        char[][] formtS = new char[numRows][strLen];

        for (int i = 0; i < strLen; i++) {
            if (needPlus && tmpCnt < numRows) {
                formtS[tmpCnt][cel] = s.charAt(i);
                tmpCnt++;
                if (tmpCnt == numRows) {
                    needPlus = false;
                    tmpCnt = numRows - 1;
                    cel++;
                    continue;
                }
            }
            if (!needPlus && tmpCnt > 0) {
                tmpCnt--;
                formtS[tmpCnt][cel] = s.charAt(i);
                if (tmpCnt - 1 <= 0) {
                    needPlus = true;
                    tmpCnt = 0;
                    cel++;
                    continue;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < strLen; j++) {
                if (formtS[i][j] != '\0') {
                    sb.append(formtS[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
