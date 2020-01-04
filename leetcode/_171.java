

public class _171 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.titleToNumber("A"));
		System.out.println(s.titleToNumber("ZY"));
	}
	
	static class Solution {
		/**
		 * 26进制转换成10进制公式的利用
		 * 
		 * @param s
		 * @return
		 */
	    public int titleToNumber(String s) {
	    	int sum = 0;
	        for (int i = 0; i < s.length(); i++) {
				sum += Math.pow(26, s.length()-i-1) * (s.charAt(i)-'A'+1); 
			}
	        
	        return sum;
	    }
	}

}
