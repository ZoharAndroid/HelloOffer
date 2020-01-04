

public class _204 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countPrimes(10));
	}

	static class Solution {
		public int countPrimes(int n) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (isPrimes(i)) {
					count++;
				}
			}

			return count;
		}

		/**
		 * 判断 是否是素数
		 * 
		 * @param n
		 * @return
		 */
		private boolean isPrimes(int n) {
			if (n <= 3) {
				return n > 1;
			}

			// 不在6的倍数两侧一定不是素数，要么余数为1，要么余数为5
			if (n % 6 != 1 && n % 6 != 5) {
				return false;
			}

			for (int i = 5; i <= Math.sqrt(n); i+=6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}

			return true;
		}
	}
}
