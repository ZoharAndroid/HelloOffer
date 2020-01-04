
public class _344 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverseString("hello"));
		System.out.println(s.reverseString("A man, a plan, a canal: Panama"));
	}
	
	static class Solution {
	    public String reverseString(String s) {
	        StringBuilder builder = new StringBuilder(s);
	        return builder.reverse().toString();
	    }
	}
}

