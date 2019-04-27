package algorithm.二分查找;

import java.util.*;

/**
 *
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class _349 {

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            // 解题思路：转换成集合，然后判断是否包含第二个数组中的内容
            Integer[] nums1s = new Integer[nums1.length];
            for (int i = 0; i < nums1.length; i++){
                nums1s[i] = nums1[i];
            }
            Integer[] nums2s = new Integer[nums2.length];
            for (int i = 0; i < nums2.length; i++){
                nums2s[i] = nums2[i];
            }

            Set<Integer> set1 = new HashSet<>(Arrays.asList(nums1s));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(nums2s));

            Iterator<Integer> iterator = set1.iterator();
            List<Integer> result = new ArrayList<>();
            while (iterator.hasNext()){
                int num = iterator.next();
                if (set2.contains(num)){
                    result.add(num);
                }
            }

            int[] results = new int[result.size()];
            for (int i = 0; i < result.size(); i++){
                results[i] = result.get(i);
            }
            return results;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] result  = s.intersection(new int[]{4,9,5},new int[]{9,4,9,8,4});
        for (int num : result){
            System.out.println(num);
        }
    }

}
