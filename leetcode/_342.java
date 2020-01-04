
public class _342 {

	public static void main(String[] args) {

	}

	class Solution {
		public boolean isPowerOfFour(int num) {
			if (num < 4 && num != 1) {
				return false;
			}

			while (num != 1) {
				if (num % 4 != 0) {
					return false;
				}
				num /= 4;
			}

			return true;
		}
	}
}
