package algorithm.二分查找;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 */
public class _350 {

   static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++){
                list1.add(nums1[i]);
            }
            List<Integer> list2 = new ArrayList<>();

            for(int i = 0; i < nums2.length; i++){
                if (list1.contains(nums2[i])){
                    list2.add(nums2[i]); //添加
                    list1.remove(Integer.valueOf(nums2[i])); // 然后移除
                }
            }

            int[] result = new int[list2.size()];
            int i = 0;
            Iterator<Integer> iterator = list2.iterator();
            while (iterator.hasNext()){
                result[i++] = iterator.next();
            }

            return result;
        }
    }

    public static void main(String[] args){
       Solution s = new Solution();
       int[] result =  s.intersect(new int[]{1,2,2,1}, new int[]{2,2});
       for (int i = 0; i < result.length; i++){
           System.out.print(result[i] + " ");
       }


       int[] result2 = s.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int i = 0; i < result2.length; i++){
            System.out.print(result2[i] + " ");
        }
    }
}
