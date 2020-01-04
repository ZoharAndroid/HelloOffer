

import java.util.HashSet;
import java.util.Set;

public class _202 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isHappy(19));
	}

	static class Solution {
		public boolean isHappy(int n) {
			if (n == 1) {
				return true;
			}

			Set<Integer> set = new HashSet<>();
			while (n != 1) {
				String nums = String.valueOf(n);
				n = 0;
				for (int i = 0; i < nums.length(); i++) {
					int temp = Character.getNumericValue(nums.charAt(i));
					n += temp * temp;
				}

				if (n == 1) {
					return true;
				}

				if (!set.add(n)) {//用hashset判断是否有重复的，如果有重复的需要设置成false，跳出死循环
					return false;
				}

			}

			return false;
		}
	}
}
