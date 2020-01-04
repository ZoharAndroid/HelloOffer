//409.最长回文串

public class _409 {
	
	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("abccccdd"));
	}
	
	static class Solution {
		/**
		 * 解题思路：就是判断成对出现的字符，如果成对出现的字符小于总的字符数，肯定存在奇数个字符，最后结果再加上1
		 * @param s
		 * @return
		 */
	    public int longestPalindrome(String s) {
	        char[] chars = new char[128];
	        int len = 0;
	        for (int i = 0; i < s.length(); i++) {
				chars[s.charAt(i)]++;//记录个数
				if (chars[s.charAt(i)] ==2) {
					len +=2;
					chars[s.charAt(i)] = 0;//重置为0
				}
			}
	        if (len < s.length()) {
				len += 1;
			}
	        return len;
	    }
	}
}
