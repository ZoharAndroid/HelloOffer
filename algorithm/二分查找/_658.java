package algorithm.二分查找;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 *
 */
public class _658 {

    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 解题思路： 利用二分查找找到对应的位置，这个相对的位置可能是找得到，可以也找不到，但是也移动到了相对较近的位置了
            // 然后利用双指针判断相应的条件然后添加到List中

            List<Integer> result = new ArrayList<>();
            if (arr == null || arr.length == 0){
                return result;
            }

            // 二分查找找到相应的位置
            int start = 0;
            int end = arr.length - 1;
            while (start + 1 < end){
                int mid = start + (end - start)/2;
                if (arr[mid] == x){
                    start = mid;
                    end = mid + 1;
                }else if(arr[mid] < x){
                    start = mid;
                }else{
                    end = mid;
                }
            }
            // 找到相应的位置
            while (k > 0){
                // 利用双指针指向，比较大小，较小的添加到数组中
                if (start >= 0 && end < arr.length){
                    if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)){
                        // start较小
                        result.add(arr[start]);
                        start--;
                    }else{
                        result.add(arr[end]);
                        end++;
                    }
                }else if (start < 0){
                    // start到头了，那么只能移动end端了
                    result.add(arr[end]);
                    end++;
                }else{
                    result.add(arr[start]);
                    start--;
                }
                k--;
            }


            // 排序
            Integer[] arrs = new Integer[result.size()];
            int i = 0;
            Iterator iterator = result.iterator();
            while(iterator.hasNext()){
                arrs[i++] = (Integer)iterator.next();
            }
            Arrays.sort(arrs);

            return new ArrayList<>(Arrays.asList(arrs));
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findClosestElements(new int[]{1,2,3,4,5},4,3));
    }
}
