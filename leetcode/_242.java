

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _242 {
	public static void main(String[] args) {
		
	}
	
	static class Solution2 {
	    public boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) {
				return false;
			}
	        
	        int[] counts = new int[26];
	        for (int i = 0; i < s.length(); i++) {
				counts[s.charAt(i) - 'a']++;
				counts[t.charAt(i) - 'a']--;
			}
	        
	        for (int i : counts) {
				if (i!= 0) {
					return false;
				}
			}
	        
	        return true;
	        
	    }
	}
	
	static class Solution {
	    public boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) {
				return false;
			}
	        
	        char[] schar = s.toCharArray();
	        char[] tchar = t.toCharArray();
	        
	        Arrays.sort(schar);
	        Arrays.sort(tchar);
	        
	        return new String(schar).equals(new String(tchar));
	    }
	}
}
