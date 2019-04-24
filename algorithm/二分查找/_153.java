package algorithm.二分查找;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class _153 {

    static class Solution {

        public int findMin(int[] nums){

            // 解题思路：利用二分查找算法，具体判断过程如代码所示。

            if (nums == null || nums.length == 0){
                return -1;
            }

            if (nums.length == 0){
                return nums[0];
            }

            int start = 0;
            int end = nums.length - 1;
            while (start < end){
                int mid = start + (end - start)/2;
                if (nums[mid] > nums[end]){
                    // 如果中间的数大于了最右边的数，说明最小的数在mid之后
                    start = mid + 1;
                }else{
                    // 如果中间数小于最后面的数，说明最小数在mid之前
                    end  = mid;
                }
            }

            return nums[start];

        }

        public int findMin2(int[] nums) {

            // 解题思路：考虑到时间复杂度尽量低，一般的查找算法就不考虑了，这里考虑用另外一种算法。

            if (nums == null || nums.length == 0){
                return -1;
            }

            if (nums.length == 0){
                return nums[0];
            }

            int start = 0;
            int end = nums.length - 1;

            while (start <= end){
                if (nums[start] > nums[end]){
                    start++;
                }else {
                    break;
                }
            }

            return nums[start];
        }

    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findMin2(new int[]{1,2,0}));
        System.out.println(s.findMin(new int[]{1,2,0}));
    }
}
