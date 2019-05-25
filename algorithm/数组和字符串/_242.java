package algorithm.数组和字符串;

import java.util.Arrays;

/**
 *
 * 242. 有效的字母异位词
 *  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 *  https://leetcode-cn.com/problems/valid-anagram/
 *
 */
public class _242 {
    static class Solution {
        public boolean isAnagram(String s, String t) {

            // 解题思路：直接转换成字符数组，然后比较两个字符串是否相等

            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();

            Arrays.sort(schar);
            Arrays.sort(tchar);

            return String.valueOf(schar).equals(String.valueOf(tchar));
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";
        String s1 = "rat";
        String t1 = "car";
        String s2 = "ab";
        String t2 = "ba";
        System.out.println(solution.isAnagram(s2, t2));
    }
}
