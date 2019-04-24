package algorithm.二分查找;

/**
 *
 * 278. 第一个错误的版本
 *
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class _278 {

     static class Solution extends VersionControl {

        public int firstBadVersion(int n) {
            // 解题思路：从第一个false之后，后面的全部都是false，这样也就切分为两个部分，前面一部分是true，后面一部分是false

            int start = 1;
            int end = n ;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (isBadVersion(mid)){
                    // 如果为true说明后面都是有问题的版本
                    end = mid;
                }else{
                    // 如果为false，说明前面的都是没有问题的
                    start = mid + 1;
                }
            }

            return start;
        }
    }

    static class VersionControl {

         boolean isBadVersion(int version) {
            if (version >= 4){
                return true;
            }else{
                return false;
            }
        }
    }


    public static void main(String[] args){
         Solution s = new Solution();
         System.out.println(s.firstBadVersion(5));
    }

}