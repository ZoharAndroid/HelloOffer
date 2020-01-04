

import java.util.HashMap;
import java.util.Map;

public class _169 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.majorityElement(new int[] {2,2,1,1,1,2,2}));
	}

	static class Solution {
		/**
		 * 用key,value的方法就可以实现，对应的数字作为key，如果包含就+1
		 * @param nums
		 * @return
		 */
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					map.put(nums[i], map.get(nums[i]) + 1);
				} else {
					map.put(nums[i], 1);
				}
				
				if (map.get(nums[i]) > (nums.length/2)) {
					return nums[i];
				}
			}
			
			return -1;
		}
	}

}
