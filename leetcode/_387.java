import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 
 * 案例:
 * 
 * s = "leetcode" 返回 0.
 * 
 * s = "loveleetcode", 返回 2.
 * 
 * 
 * 
 * 注意事项：您可以假定该字符串只包含小写字母。
 * 
 * @author zohar
 *
 */
public class _387 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.firstUniqChar("leetcode"));
	}

	static class Solution {
		public int firstUniqChar(String s) {
			char[] ss = s.toCharArray();
			char[] counts = new char[26];
			
			for (char c : ss) {
				counts[c - 'a']++;
			}
			
			for (int i = 0; i < s.length(); i++) {
				if (counts[ss[i]- 'a'] == 1) {
					return i;
				}
			}
			return -1;
		}
	}

}
