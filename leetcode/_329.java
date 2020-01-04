package leetcode;

public class _329 {

    /**
     * 392. 判断子序列
     * <p>
     * https://leetcode-cn.com/problems/is-subsequence/
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc","ahbgdc"));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            /**
             * 依次从s取一个字符去比较t中的依次每个字符。直到找到相同的
             * 字符后，然后取S中的下一个字符接着和t中的剩余字符进行比较
             * 要么s比较完了，t没有比较完，说明是子序列
             * 如果s没比较完，t就完了，说明不是子序列
             *
             */

            char[] s_chars = s.toCharArray();
            char[] t_chars = t.toCharArray();
            int i = 0;
            int j = 0;
            while (i < s_chars.length && j < t_chars.length) {
                // 如果两者都相等，那么都进行移位
                if (s_chars[i] == t_chars[j]) {
                    i++;
                    j++;
                } else {
                    // 如果不相等，那么就只有j进行移位
                    j++;
                }
            }

            if (i == s_chars.length){
                return true;
            }

            return false;
        }
    }
}
