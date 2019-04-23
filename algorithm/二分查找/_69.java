package algorithm.二分查找;

/**
 * 69. x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class _69 {

    public int mySqrt(int x) {

        // 解题思路：用二分查找，这里需要注意一下的是leetcode测试平台当超过int范围的时候的处理，所以这里使用了long类型。

        long start = 1;
        long end = x;
        long mid;
        while (start <= end){
            mid = start + (end - start)/2;
            if ( mid * mid == x){
                return (int)mid;
            }else if ( mid * mid < x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return (int)end;
    }

    public static void main(String[] args){
        _69 p = new _69();
        System.out.println(p.mySqrt(2147395599));
    }
}
