package algorithm.数组和字符串;

import java.util.*;

/**
 *
 * 169. 求众数
 *  给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 *  你可以假设数组是非空的，并且给定的数组总是存在众数。
 * https://leetcode-cn.com/problems/majority-element/
 */
public class _169 {

    static class Solution {
        public int majorityElement(int[] nums) {

            // 解题思路：用HashMap来记录每次出现的次数

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if (map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i]) + 1);
                }else{
                    map.put(nums[i], 1);
                }
            }

            // 然后判断次数出现的是否是大于n/2的元素
            int len = nums.length;
             Iterator iterator =  map.keySet().iterator();
            while (iterator.hasNext()){
                int key = (Integer)iterator.next();
                int value = map.get(key);
                if (value > len/2){
                    return key;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
