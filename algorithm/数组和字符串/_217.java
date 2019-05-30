package algorithm.数组和字符串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 217. 存在重复元素
 *  给定一个整数数组，判断是否存在重复元素。
 *  如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 *
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class _217 {

    static class Solution {
        public boolean containsDuplicate(int[] nums) {

            // 解题思路：判断数组中是否存在重复的数字，那么用hashmap来进行处理,
            // 记录当前的出现的次数.

            if (nums.length == 1){ // 只有一个重复的
                return false;
            }

            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for (int num :
                    nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // 遍历values结合
            Iterator iterator = map.values().iterator();
            while (iterator.hasNext()){
                if ((int)iterator.next()>1){
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
        System.out.println(s.containsDuplicate(new int[]{7,10,5,5,6,6,4,10,5,4,9,4,9,6,5,9,6,3,6,5,6,7,7,4,9,9,10,5,8,1,8,3,2,7,5,10,1,8,5,8,4,3,6,4,9,4,2,8,3,2,2,1,5,6,3,2,6,1,8,6,2,9,1,4,5,10,8,5,10,5,10,1,4,8,3,6,4,10,9,1,1,1,2,2,9,6,6,8,1,9,2,5,5,2,1,8,5,2,3,10}));
    }
}
