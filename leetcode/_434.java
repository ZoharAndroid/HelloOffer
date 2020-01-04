//434.字符串中的单词数
public class _434 {

	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 * 解题思路：以空格作为单词分隔的标志，如果是空格，直接省略当前循环，如果不是空格，说明遇到了一个单词，那么result++，然后知道遇到下一个
		 * 空格，这样循环就可以判断出来了。
		 * @param s
		 * @return
		 * 
		 * 执行用时: 2 ms, 在Number of Segments in a String的Java提交中击败了88.83% 的用户
		 */
	    public int countSegments(String s) {
	    	int result = 0;
	        for(int i = 0;i< s.length();i++) {
	        	if (s.charAt(i) == ' ') {
					continue;//遇到空格直接跳过
				}
	        	
	        	result++;
	        	while (i<s.length() && s.charAt(i)!= ' ' ) {
	        		//不等于空格，就移动i，知道移动到了空格，说明新的单词到来了
	        		i++;
				}
	        }
	        return result;
	    }
	}
}
