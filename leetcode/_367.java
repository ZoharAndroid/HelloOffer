/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如 sqrt。
 * 
 * 示例 1： 输入：16 输出：True
 * 
 * 示例 2： 输入：14 输出：False
 * 
 * @author zohar
 *
 */
public class _367 {

	public static void main(String[] args) {

	}

	static class Solution1{
		// 二分查找
		public boolean isPerfectSquare(int num) {
			long left = 0;
			long right = num;
			while (left <= right) {
				long mid = left + (right - left)/2;
				long temp = mid * mid;
				if (temp == num) {
					return true;
				}else if(temp < num) {
					left = mid + 1;
				}else if(temp > num) {
					right = mid - 1;
				}
			}
			return false;
		}
	}
	
	static class Solution {
		/**
		 * 完全平方数是一系列奇数之和，例如：
		 * 
		 * 1 = 1 4 = 1 + 3 9 = 1 + 3 + 5 16 = 1 + 3 + 5 + 7 25 = 1 + 3 + 5 + 7 + 9
		 * 
		 * @param num
		 * @return
		 */
		public boolean isPerfectSquare(int num) {
			long i = 1;
			long temp = 1;
			while (temp < num) {
				i += 2;
				temp += i;
			}
			return temp == num;
		}
	}
}
