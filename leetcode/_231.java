

public class _231 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPowerOfTwo(16));
	}

	static class Solution {
		public boolean isPowerOfTwo(int n) {
			if (n == 0) {
				return false;
			}
			int temp = (int)( Math.log(n)/Math.log(2));
			if (Math.pow(2, temp) == n) {
				return true;
			}else {
				return false;
			}
		}
	}
}
