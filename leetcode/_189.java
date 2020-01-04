

public class _189 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {-1,-100,3,99};
		s.rotate(nums, 2);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	static class Solution {
	    public void rotate(int[] nums, int k) {
	    	int n = nums.length;
	        k %= n;//循环多次
	        for (int i = 0; i < k; i++) {
				int temp = nums[n - 1];//记录最后面的一个元素
				//移动：向右移动
				for (int j = n - 1; j > 0; j--) {
					nums[j] = nums[j -1];
				}
				nums[0] = temp;//始终把末尾的放在开头
				
			}
	    }
	}

}
