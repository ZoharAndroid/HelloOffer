import java.util.ArrayList;
import java.util.List;

//438. 找到字符串中所有字母异位词
public class _438 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findAnagrams("abab", "ab"));
	}
	
	static class Solution {
		/**
		 * 解题思路：截取s中相应的p位字符，然后判断是否包含有不同的字符，如果不包含说明满足条件，list加1
		 * @param s
		 * @param p
		 * @return
		 * 执行用时: 740 ms, 在Find All Anagrams in a String的Java提交中击败了4.78% 的用户 
		 *
		 */
	    public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> result = new ArrayList<>();
	        
	    	for(int i = 0; i<= s.length() - p.length(); i++) {
	    		if (isCorrect(s.substring(i, i+p.length()),p)) {
					result.add(i);
				}
	    	}
	        return result;
	    }
	    
	    
	   private boolean isCorrect(String subStr,String p) {
		   int[] c = new int[26];
		   for(int i = 0; i<p.length();i++) {
			   c[subStr.charAt(i) - 'a']++;
			   c[p.charAt(i) - 'a']--;
		   }
		   
		   for (int i : c) {
			if (i!=0) {
				return false;
			}
		}
		   return true;
	   }

	
	}

}
