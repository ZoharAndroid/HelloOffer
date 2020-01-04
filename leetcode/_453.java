//453. 最小移动次数使数组元素相等
public class _453 {

	public static void main(String[] args) {

	}
	
	class Solution {
		/**
		 * 解题思路：题目原本的意思就是，每次找到最大值，然后让其余的n-1个数加1，这样程序会比较耗时。实际上，给n-1个数加1，就是相当于让
		 * 最大的数减1，这样也并不会影响数字之间的差异了，将所有数字与最小值之间的差异值相加，也就可以得到移动的步数了。
		 * @param nums
		 * @return
		 * 执行用时: 11 ms, 在Minimum Moves to Equal Array Elements的Java提交中击败了51.52% 的用户
		 */
	    public int minMoves(int[] nums) {
	        int sum = 0,min = Integer.MAX_VALUE;
	        // 找出最小值
	        for (int i : nums) {
				min = Math.min(i, min);
			}
	        //累加与最小值的差距
	        for (int i : nums) {
				sum+= i - min;
			}
	        return sum;
	    }
	}

}
