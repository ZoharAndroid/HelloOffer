package algorithm.二分查找;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34 {

    static class Solution {

        public int[] searchRange(int[] nums, int target) {

            // 解题思路：首先找到目标值，通过二分查找。
            // 如果找到了目标值，然后分别左右循环找到相应的临界点

            int[] range = new int[2];
            range[0] = -1;
            range[1] = -1;

            if (nums == null || nums.length == 0){
                return range;
            }


            int start = 0;
            int end = nums.length - 1;

            while (start+1 < end){
                int mid = start + (end - start)/2;
                if (nums[mid] == target){
                    // 如果找到目标值
                    // 从左右两个方向找到临界点
                    int left = mid;
                    while(left > 0 && nums[mid] == nums[left - 1]){
                        left--;
                    }
                    range[0] = left;

                    int right = mid;
                    while (right < nums.length - 1 && nums[mid] == nums[right+1]){
                        right++;
                    }
                    range[1] = right;
                    break;
                }else if (nums[mid] < target){
                    start = mid;
                }else{
                    end = mid;
                }
            }

            // 为什么要加这一部分代码？当程序运行到这个部分的时候，说明还没有找到对应的目标，此刻 start+1 = end。如果正好start等于目标值
            // 那么就需要重新判断了，如果没有进行这一步，那么就不正确了。
            if (nums[start] == target){
                // 如果一开始就等于目标值
                range[0] = start;
                while (start < nums.length - 1 && nums[start] == nums[start + 1]){
                    start++;
                }
                range[1] = start;
            }else if (nums[end] == target){
                range[1] = end;

                while (end > 0 && nums[end] == nums[end - 1]){
                    end--;
                }
                range[0] = end;
            }

            return range;
        }

    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = s.searchRange(new int[]{1,3},1);
        System.out.println(nums[0] + " " + nums[1]);
    }
}
