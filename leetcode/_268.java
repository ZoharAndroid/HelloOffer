import java.util.Arrays;

public class _268 {
	public static void main(String[] args) {
		System.out.println(new Solution2().missNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}

	/**
	 * 既然0到n之间少了一个数，我们将这个少了一个数的数组合0到n之间完整的数组异或一下，那么相同的数字都变为0了，剩下的就是少了的那个数字了
	 * 
	 * @author zohar
	 *
	 */
	static class Solution2 {
		public int missNumber(int[] nums) {
			int result = 0;
			int i = 0;
			for (; i < nums.length; i++) {
				result = result ^ (i + 1) ^ nums[i];
			}

			return result;
		}
	}

	/**
	 * 解法1：就是将0~n项的数字相加，然后减去给定的n-1个数字和，就是剩下的那个数字了
	 * 
	 * @author zohar
	 *
	 */
	static class Solution1 {
		public int missingNumber(int[] nums) {
			int sum = 0, n = nums.length;
			for (int i : nums) {
				sum += i;
			}

			return n * (n + 1) / 2 - sum;
		}
	}
}
