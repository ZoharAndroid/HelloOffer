

import java.util.HashMap;
import java.util.Map;

public class _219 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
	}

	static class Solution {
		public boolean containsNearbyDuplicate(int[] nums, int k) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					// 如果map里面包含了重复的值，那么久进行判断索引是否小于等于k	
					if ((i - map.get(nums[i])) <= k) {
						return true;
					}else {
						// 更新一下map的索引
						map.put(nums[i], i);
					}
				} else {
					map.put(nums[i], i);
				}
			}
			return false;
		}
	}

}
