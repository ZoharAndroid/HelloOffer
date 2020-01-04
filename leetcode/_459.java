//459. 重复的子字符串
public class _459 {
	
	class Solution {
		/**
		 * 从原字符串长度的一半遍历到1，如果当前长度能被总长度整除，说明可以分成若干个子字符串，我们将这些子字符串拼接起来看跟原字符串是否相等。 如果拆完了都不相等，返回false。
		 * @param s
		 * @return
		 */
	    public boolean repeatedSubstringPattern(String s) {
	        int len = s.length();
	        for (int i = len/2; i >= 1; i--) {
	        	String pattern = s.substring(0, i);
				if(len % i == 0) {
					StringBuilder temp = new StringBuilder();
					int c = len / i;
					for(int j = 0; j < c;j++) {
						temp.append(pattern);
					}
					
					if (temp.toString().equals(s)) {
						return true;
					}
				}
				
			}
	        return false;
	    }
	}
}
