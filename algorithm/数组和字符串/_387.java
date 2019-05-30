package algorithm.数组和字符串;

/**
 * 387. 字符串中的第一个唯一字符
 *  给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class _387 {
    static class Solution {
        public int firstUniqChar(String s) {

            // 解题思路：记录每个字符串中的字符出现的次数，
            // 然后依次读取次数为1的即为首次第一次的字符.

            if (s == null || s.length() == 0){
                return -1;
            }

            char[] chars = s.toCharArray();

            int[] counts = new int[26];
            for (char ch : chars) {
                counts[ch - 'a']++;
            }

            // 依次读取
            for (int i = 0; i < s.length(); i++){
                if (counts[chars[i] - 'a'] == 1){
                    return i;
                }
            }

            return -1;
        }
    }


    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }
}
