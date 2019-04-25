package algorithm.二分查找;

/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/
 *
 */
public class _367 {

    static class Solution {
        public boolean isPerfectSquare(int num) {

            // 解题思路：二分，判断是否有数 相乘等于num的。
            // 注意：这里测试平台给出的数会比较大，所有使用了long类型。
            long start = 1;
            long end = num/2;

            while ( start <= end){
                long mid = start + (end - start)/2;
                if (mid * mid == num){
                    return true;
                }else if (mid * mid < num){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.isPerfectSquare(2147483647));
    }
}
