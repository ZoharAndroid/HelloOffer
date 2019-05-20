package algorithm.数组和字符串;

/**
 *
 * 152. 乘积最大子序列
 *  给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 */
public class _152 {

    static class Solution {
        public int maxProduct(int[] nums) {

            // 解题思路：当遍历数组中的元素的时候，
            // 如果是最大值遇到正数，那么相乘即可，
            // 如果最大值遇到负数，那么就直接变成了最小值了。
            if (nums.length == 0){
                return 0;
            }

            if (nums.length == 1){
                return nums[0];
            }

            int[] max = new int[nums.length];
            int[] min = new int[nums.length];

            int value = nums[0];
            max[0] = nums[0];
            min[0] = nums[0];

            for (int i = 1; i < nums.length; i++){
                max[i] = Math.max(nums[i], Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]));
                min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
                value = Math.max(value, max[i]);
            }

            return value;

        }
    }


    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[]{2,3,-2,4}));

    }
}
