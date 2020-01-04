/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

示例：
给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

说明:
    你可以假设数组不可变。
    会多次调用 sumRange 方法。

 * @author zohar
 *
 */
public class _303 {
	public static void main(String[] args) {
		NumArray n = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(n.sumRange(2, 5));
	}
	
	
	static class NumArray {

		private int[] nums;
		
	    public NumArray(int[] nums) {
	        this.nums = nums;
	    }
	    
	    public int sumRange(int i, int j) {
	        int sum = 0;
	        for (int k = i; k <= j; k++) {
				sum += nums[k];
			}
	        
	        return sum;
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
	
}
