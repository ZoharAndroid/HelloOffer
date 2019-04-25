package algorithm.二分查找;

/**
 *
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * https://leetcode-cn.com/problems/powx-n/
 *
 */
public class _50 {

    static class Solution {
        public double myPow(double x, int n) {

            // 参考：http://www.cnblogs.com/grandyang/p/4383775.html

            double res = 1.0;
            for (int i = n; i!=0; i/=2){
                if (i%2 !=0){
                    res *=x;
                }
                x*=x;
            }
            return n < 0 ? 1/res : res;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.myPow(2,10));
    }
}
