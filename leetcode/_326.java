/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 
 * 示例 1: 输入: 27 输出: true
 * 
 * 示例 2: 输入: 0 输出: false
 * 
 * 示例 3: 输入: 9 输出: true
 * 
 * 示例 4: 输入: 45 输出: false
 * 
 * 进阶： 你能不使用循环或者递归来完成本题吗？
 * 
 * @author zohar
 *
 */
public class _326 {
	public static void main(String[] args) {

	}

	static class Solution3{
		/**
		 * 有一个投机取巧的方法，由于输入是int，正数范围是0-2^31，在此范围中允许的最大的3的次方数为3^19=1162261467，那么我们只要看这个数能否被n整除即可
		 * @param n
		 * @return
		 */
		public boolean isPowerOfThree(int n) {
			return ( n > 0 && 1162261467 % n == 0);
		}
	}
	
	static class Solution1 {
		public boolean isPowerOfThree(int n) {
			if (n < 3) {
				return false;
			}
			
			while (n != 1) {
				if (n % 3 != 0) {
					return false;
				}
				n /= 3;
			}
			return true;
		}
	}
}
