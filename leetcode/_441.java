//441. 排列硬币
public class _441 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.arrangeCoins(3));
	}
	
	static class Solution {
		/**
		 * 解题思路：第一行：1  第二行 ：1 1，第三行：1 1 1。。。。。。题目的意思就是，1为递增，1,2,3.。，直到sum<=需要判断的数，就可以直到在第几层了 
		 * @param n
		 * @return
		 * 执行用时: 60 ms, 在Arranging Coins的Java提交中击败了42.75% 的用户
		 */
	    public int arrangeCoins(int n) {
	    	if (n <= 0) {
				return 0;
			}
	    	if (n == 1) {
				return 1;
			}
	    	
	        long sum = 0;
	        int count = 0;
	        while(sum <= n) {
	        	count ++;
	        	sum += count;
	        }

			return count - 1;
			
	    }
	}

}
