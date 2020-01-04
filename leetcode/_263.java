
public class _263 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isUgly(6));
	}
	
	
	static class Solution {
	    /**
	     *  判断丑数就是要求这个数字不断除以2，3，5，然后最后结果相处为1 那么就是丑数了/
	     * @param num
	     * @return
	     */
		public boolean isUgly(int num) {
	        while (num >= 2) {
				if (num % 2 == 0) {
					num/=2;
				}else if(num % 3 == 0) {
					num /= 3;
				}else if(num % 5 == 0) {
					num /= 5;
				}else {
					return false;
				}
				
	        }
	        return num == 1;
	    }
	}
}
