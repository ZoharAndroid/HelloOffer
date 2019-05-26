package algorithm.Sort;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 *  在未排序的数组中找到第 k 个最大的元素。
 *  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 */
public class _215 {

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);

            return nums[nums.length - k];
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
