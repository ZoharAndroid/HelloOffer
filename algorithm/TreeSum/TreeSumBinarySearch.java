package algorithm.TreeSum;


import java.util.Arrays;

/**
 * 利用二分查找方法来查找数组中的三元为0的个数
 *
 * 解题思路：
 * 首先对数组进行排序，然后对两个数进行求和，找到其余数据中与求和数据相反的数.
 *
 * 这种时间复杂度为O(N^2logN)
 *
 */
public class TreeSumBinarySearch implements TreeSum {
    @Override
    public int count(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                int target = -nums[i] - nums[j];
                int index = binarySearch(nums, target);

                if( j < index){
                    // 在后面找到了一个相反数
                    count++;
                }
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int target){

        int l = 0, h = nums.length - 1;
        while(h >= l){
            int m = l + (h - l)/2;
            if (nums[m] == target){
                return m;
            }else if (nums[m] > target ){
                h = m - 1;
            }else{
                l = m + 1;
            }
        }

        return -1;
    }
}
