import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//414.第三大的数
public class _414 {
	public static void main(String[] args) {
		System.out.println(new Solution2().thirdMax(new int[] {2,2,3,1}));
	}
	
	static class Solution2{
		/**
		 * 解题思路：从给定的数组中直接找前三个最大的数;注意这里一个坑就是INT_MIN的处理
		 * @param nums
		 * @return
		 * //执行用时: 6 ms, 在Third Maximum Number的Java提交中击败了47.59% 的用户
		 */
		  public int thirdMax(int[] nums) {
			  long max1 = Long.MIN_VALUE;
			  long max2 = Long.MIN_VALUE;
			  long max3 = Long.MIN_VALUE;
			  
			  for (int i : nums) {
				max1 = Math.max(i, max1);
			}
			  for (int i : nums) {
				if (i == max1) {
					continue;
				}
				max2 = Math.max(i, max2);
			}
			  for (int i : nums) {
				if (i == max1 || i == max2) {
					continue;
				}
				max3 = Math.max(i, max3);
			}
			  return (int) ((max3 == Long.MIN_VALUE)?max1:max3);
		  }
	}
	
	static class Solution {
		/**
		 * 解题思路：去除重复的数字，用到了list，和数组的sort函数；如果数组大小为1，那么返回的就是本身，如果大小为2，取较大的，若大于3，对数组进行排序，取第三大的数
		 * @param nums
		 * @return
		 * //执行用时: 121 ms, 在Third Maximum Number的Java提交中击败了4.60% 的用户
		 */
	    public int thirdMax(int[] nums) {
	    	List<Integer> list = new ArrayList<>();
	    	for (int i = 0; i < nums.length; i++) {
	    		if (!list.contains(nums[i])) {
	    			list.add(nums[i]);				
				}
			}
	    	
	    	if (list.size() == 1) {
				return list.get(0);
			}else if(list.size() == 2) {
				return Math.max(list.get(0), list.get(1));
			}else {
				int[] results = new int[list.size()];
		    	for (int i = 0; i < list.size(); i++) {
					results[i] = list.get(i);
				}
		    	Arrays.sort(results);//从小到大进行排列
		    	return results[list.size() - 3];
			}
	    	
	    }
	}
}
