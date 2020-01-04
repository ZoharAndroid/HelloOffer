

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _217 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.containsDuplicate(new int[] { 1, 2, 3 }));
	}

	static class Solution {
		/**
		 * 这里用hash比较好，因为会有在较大规模的数据集的情况下会超时。
		 * 
		 * @param nums
		 * @return
		 */
		public boolean containsDuplicate(int[] nums) {
			if (nums == null || nums.length == 0) {
				return false;
			}
			Set<Integer> set = new HashSet<>();
			for (int i : nums) {
				if (!set.add(i)) {
					return true;
				}
			}
			return false;
		}
	}
}
