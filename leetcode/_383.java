import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个赎金信 (ransom)
 * 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true
 * ；否则返回 false。
 * 
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * 
 * 注意：
 * 
 * 你可以假设两个字符串均只含有小写字母。
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author zohar
 */
public class _383 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.canConstruct("aa", "ab"));
	}

	static class Solution {
		/**
		 * @param ransomNote
		 * @param magazine
		 * @return
		 */
		public boolean canConstruct(String ransomNote, String magazine) {
			char[] magChars = magazine.toCharArray();
			char[] charCounts = new char[256];
			for (int i = 0; i < magChars.length; i++) {
				charCounts[magChars[i]- 'a']++;
			}
			
			char[] noteChars = ransomNote.toCharArray();
			for (int i = 0; i < noteChars.length; i++) {
				if (charCounts[noteChars[i] - 'a'] <= 0) {
					return false;
				}
				charCounts[noteChars[i] - 'a']--;
			}
			
			return true;
			
		}
	}
}
