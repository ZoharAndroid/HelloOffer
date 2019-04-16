package algorithm.数组和字符串;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * https://leetcode-cn.com/problems/array-partition-i/
 */
public class _561 {

    public int arrayPairSum(int[] nums) {

        // 解题思路：其实就是将数组进行排序，依次两个组成一对，也就形成了最大的值了
        Arrays.sort(nums); // 排序
        int sum = 0;
        for (int i = 0; i <nums.length; i+=2){
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args){
        _561 p = new _561();
        System.out.println(p.arrayPairSum(new int[]{1,4,3,2}));
    }
}
