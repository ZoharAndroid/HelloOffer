package algorithm.二分查找;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。注意数组中可能存在重复的元素。
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class _154 {

    static class Solution {
        public int findMin(int[] nums) {
            // 解题思路：双指针思想，旋转点即是最小值。如果
            // nums[mid] < right，说明mid~right这一部分不是旋转过得
            // nums[mid] > right, left~mid 包含了旋转过得

            int start = 0;
            int end = nums.length - 1;
            while (start < end){
                int mid = start + (end -start)/2;
                if (nums[mid] < nums[end]){
                    end  = mid;
                }else if (nums[mid] > nums[end]){
                    start = mid + 1;
                }else{
                    end--;
                }
            }

            return nums[end];
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{2,2,2,0,1}));
    }
}
