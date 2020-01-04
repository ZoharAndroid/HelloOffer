import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//448. 找到所有数组中消失的数字
public class _448 {
	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 * 解题思路：将数组中的数都置位相反数。如果num[i]对应的num[num[i]-1]是正数，则置位相反数
		 * 如果是负数，则保持不变，然后相应的索引位置就是多余重复出来的数字所占的位置。
		 * @param nums
		 * @return
		 * 执行用时: 18 ms, 在Find All Numbers Disappeared in an Array的Java提交中击败了41.84% 的用户
		 */
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	    	for (int i = 0; i < nums.length; i++) {
				int index = Math.abs(nums[i]) - 1;
				if (nums[index]>0) {
					nums[index] = -nums[index];
				}
			}
	    	//遍历找出不为负数的位置
	    	List<Integer> result = new ArrayList<>();
	    	for (int i = 0; i < nums.length; i++) {
				if (nums[i]>0) {
					result.add(i+1);
				}
			}
	    	
	    	return result;
	    }
	}
}
