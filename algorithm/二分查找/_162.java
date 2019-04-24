package algorithm.二分查找;

/**
 * 162. 寻找峰值
 *
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class _162 {

    static class Solution {

        public int findPeakElement(int[] nums){
            // 解题思路：利用二分查找算法，注意这里利用二分查找算法数组并不是整个都是有序的，而是局部有序。
            // 如果nums[i] > nums[i+1]，那么峰值一定存在与i之前的元素
            // 如果nums[i] < nums[i+1], 那么峰值一定存在于i+1之后的元素

            int start = 0;
            int end = nums.length - 1;
            while (start < end){
                int mid = start + (end - start)/2;
                if (nums[mid] > nums[mid + 1]){
                    // 当前元素大于后面的元素，说明峰值在前面
                    end = mid;
                }else{
                    start = mid + 1;
                }
            }

            return start;
        }


        public int findPeakElement2(int[] nums) {

            // 解题思路：新建一个数组，把最小值添加到新建数组的前后，然后依次比较前后的数值，找出峰值即可。
            // 但是这种算法的时间复杂度为O(n)，并不满足题目的要求，题目要求为O(logN)

            if (nums.length == 0 || nums == null){
                return -1;
            }

            if (nums.length == 1){
                return 0;
            }


            int[] m_nums = new int[nums.length + 2]; // 创建一个新的数组，前后都是最小值
            m_nums[0] = Integer.MIN_VALUE;
            m_nums[m_nums.length - 1] = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++){
                m_nums[i+1] = nums[i];
            }
            // 循环比较前后值
            for (int i = 1; i < m_nums.length - 1; i++){
                if (m_nums[i] > m_nums[i-1] && m_nums[i] > m_nums[i+1]){
                    return i - 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findPeakElement2(new int[]{2,1}));

        System.out.println(s.findPeakElement(new int[]{1,2}));
    }

}
