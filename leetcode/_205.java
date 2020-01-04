

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _205 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isIsomorphic("ab", "aa"));
		System.out.println(s.isIsomorphic("foo", "bar"));
		System.out.println(s.isIsomorphic("abb", "cpp"));
	}
	
	
	static class Solution {
		/**
		 *   思路：可以使用map来解决，如果有对应的key，则取出来，进行判断，如果没有对应的key，则添加对应的关系
		 * @param s
		 * @param t
		 * @return
		 */
	    public boolean isIsomorphic(String s, String t) {
	    	if (s == null || t == null || s.length() != t.length()) {
				return false;
			}
	    	
	        Map<Character, Character> map = new HashMap<>();
	        for (int i = 0; i < s.length(); i++) {
				if (map.containsKey(s.charAt(i))) {
					//获取当前的key。value进行比较
					if (map.get(s.charAt(i)) != t.charAt(i)) {
						return false;
					}
				}else {
					if (map.containsValue(t.charAt(i))) {
						return false;
					}
					
					map.put(s.charAt(i), t.charAt(i));//添加对应关系
				}
			}
	        return true;
	    }
	}

}
