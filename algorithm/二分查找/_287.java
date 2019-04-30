package algorithm.二分查找;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 */
public class _287 {

    static class Solution {
        public int findDuplicate1(int[] nums) {

            // 解题思路：通常想到的方法就是一次遍历数组中的每个数，然后与后面的每个数进行比较。
            for (int i = 0; i< nums.length; i++){
                for (int j = i + 1; j < nums.length; j++){
                    if (nums[i] == nums[j]){
                        return nums[i];
                    }
                }
            }

            return -1;
        }


        public int findDuplicate2(int[] nums) {

            // 解题思路：利用二分查找，因为数组中的数字是1~n，说明那个最大的数就是n，那么数组中的个数中有小于等于mid的个数多余mid个，
            // 说明1~mid中必然存在重复的数字

            int start = 1;
            int end = nums.length;
            while (start < end ){
                int mid = start + (end - start)/2;
                // 统计1~mid中的个数
                int count = 0;
                for (int num: nums) {
                    if (num <= mid){
                        count++;
                    }
                }

                // 如果统计的数，小于等于mid个数，说明重复的数必定在 mid~nums.length中
                if (count <= mid){
                    start = mid + 1;
                }else{
                    end = mid;
                }

            }


            return end;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findDuplicate1(new int[]{1,3,4,2,2}));
        System.out.println(s.findDuplicate2(new int[]{1,3,4,2,2}));
    }
}
