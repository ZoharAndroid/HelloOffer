import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。 示例: 输入： s = "abcd" t = "abcde" 输出： e 解释： 'e' 是那个被添加的字母
 * 
 * @author zohar
 *
 */
public class _389 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findTheDifference("a", "aa"));
	}

	/**
	 * 执行用时: 6 ms, 在Find the Difference的Java提交中击败了81.70% 的用户
	 * @author zohar
	 *
	 */
	static class Solution2 {
		class Solution {
			public char findTheDifference(String s, String t) {
				int[] count = new int[26];
				char[] schar = s.toCharArray();
				char[] tchar = t.toCharArray();
				for (int i = 0; i < schar.length; i++) {
					count[schar[i] - 'a']++;
				}
				
				for (int i = 0; i < tchar.length; i++) {
					count[tchar[i] - 'a']--;
				}
				
				for (int i = 0; i < count.length; i++) {
					if (count[i] != 0) {
						return (char) ('a' + i);
					}
				}
				return 'a';
			}
		}
	}

	/**
	 * 执行用时: 31 ms, 在Find the Difference的Java提交中击败了7.94% 的用户
	 * 
	 * @author zohar
	 *
	 */
	static class Solution {
		public char findTheDifference(String s, String t) {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < s.length(); i++) {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			}

			for (int i = 0; i < t.length(); i++) {
				if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
					return t.charAt(i);
				} else {
					map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
				}
			}
			return ' ';
		}
	}
}
