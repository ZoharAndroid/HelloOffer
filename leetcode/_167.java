

public class _167 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] indexs = s.twoSum(numbers, target);
		System.out.println(indexs[0] + " " + indexs[1]);
	}

	static class Solution {
		/**
		 * 解决思路：就是利用二分查找思路，首位相加依次进行比较，因为题目告诉我们一已知的数组是按照从小到大的顺序进行的
		 * 所以，如果首位两个数相加较小target，那么left就应该往大的方向移动，如果sum大于target，那么right就往 小的方向移动
		 * 
		 * @param numbers
		 * @param target
		 * @return
		 */
		public int[] twoSum(int[] numbers, int target) {
			int left = 0;
			int right = numbers.length -1;
			int sum = 0;
			while(left < right) {
				sum = numbers[left] + numbers[right];
				if (sum < target) {
					left++; 
				}else if(sum > target) {
					right--;
				}else {
					int[] indexs = new int[2];
					indexs[0] = left + 1;
					indexs[1] = right + 1;
					return indexs;
				}
			}
			
			return new int[] {-1,-1};
		}
	}

}
