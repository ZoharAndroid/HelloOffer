package algorithm.数组和字符串;

/**
 *
 * 125. 验证回文串
 *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 */
public class _125 {

    static class Solution {
        public boolean isPalindrome(String s) {

            // 解题思路：可以用两个指针，一个指针指向开头，
            // 一个指针指向末尾，当遇到字母或者数字的时候，
            // 两个指针就进行比较，如果某个指针指向的不是
            // 字母或者数字的话，那么就移动到下面一个字符,
            // 直到两者相遇。

            if (s == null){
                return false;
            }

            if (s.equals(" ")){
                return true;
            }

            String str  = s.toLowerCase(); // 全部转换成小写字符
            char[] chars = str.toCharArray();
            int start = 0;
            int end = chars.length - 1;

            while (start <= end){
                while (!((chars[start] >= '0' && chars[start] <= '9') || (chars[start] >='a' && chars[start] <= 'z'))  && start < end){
                    // 如果不是字母或者数字
                    start++;
                }

                while (!((chars[end] >= '0' && chars[end] <= '9') || (chars[end] >='a' && chars[end] <= 'z')) && start < end ){
                    // 如果不是字母或者数字
                    end--;
                }

                if (chars[start] != chars[end]){
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }
    }


    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.isPalindrome("                   A man, a plan, a canal: Panama          "));
        System.out.println(s.isPalindrome(" "));
        System.out.println(s.isPalindrome(" race a car                   "));
    }
}
