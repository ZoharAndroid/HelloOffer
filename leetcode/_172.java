

public class _172 {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.trailingZeroes(5));
		System.out.println(s.trailingZeroes(3));
	}
	
	static class Solution {
		/**
		 *  就是计算5的个数，5有多少个，其中末尾一定有多少个0
		 * @param n
		 * @return
		 */
	    public int trailingZeroes(int n) {
	        int result = 0;
	        while(n > 4) {
	        	n /= 5;
	        	result += n;
	        }
	        
	        return result;
	    }
	}

}
