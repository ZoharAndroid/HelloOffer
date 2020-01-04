import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1: 输入: "hello" 输出: "holle"
 * 
 * 示例 2: 输入: "leetcode" // eeoe lxxtcxdx 输出: "leotcede" //
 * 
 * 说明: 元音字母不包含字母"y"。
 * 
 * @author zohar
 *
 */
public class _345 {
	public static void main(String[] args) {

	}

	static class Solution {
		public String reverseVowels(String s) {
			StringBuilder sb = new StringBuilder(s);
			Set<Character> set = new HashSet<>();
			set.add('a');
			set.add('e');
			set.add('i');
			set.add('o');
			set.add('u');
			set.add('A');
			set.add('E');
			set.add('I');
			set.add('O');
			set.add('U');
			
	        int i = 0;
	        int j = s.length() - 1;
	        while (i < j) {
				char left = s.charAt(i);
				char right = s.charAt(j);
				// 左边移动到第一个元音字母的位置
				while (i < j && !set.contains(left)) {
					i++;
					left = s.charAt(i);
				}
				
				while (i < j && !set.contains(right)) {
					j--;
					right = s.charAt(j);
				}
				
				//交换
				char temp = left;
				sb.setCharAt(i, right);
				sb.setCharAt(j, temp);
				i++;
				j--;
			}
	        return sb.toString();
	    }
	}
}
