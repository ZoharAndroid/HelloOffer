package offer;

/**
 * // 面试题53（三）：数组中数值和下标相等的元素
 * // 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * // 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * // 1, 3, 5}中，数字3和它的下标相等。
 */
public class Problem53_3 {

    public int GetNumberSameAsIndex(int[] array){

        if (array == null || array.length == 0){
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while( start <= end){
            int mid = start + (end - start)/2;
            if (array[mid] == mid){
                return mid;
            }else if (array[mid] > mid){
                // 如果数值大于索引，而数组又是递增的，说明数组中的有半部分都是大于索引mid的
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Problem53_3 p = new Problem53_3();
        System.out.println(p.GetNumberSameAsIndex(new int[]{-3, -1, 1, 3, 5})); // 3
        System.out.println(p.GetNumberSameAsIndex(new int[]{0, 1, 3, 5, 6})); // 0
        System.out.println(p.GetNumberSameAsIndex(new int[]{ -1, 0, 1, 2, 4}));// 4
        System.out.println(p.GetNumberSameAsIndex(new int[]{-1, 0, 1, 2, 5})); // -1
        System.out.println(p.GetNumberSameAsIndex(new int[]{0})); // 0
        System.out.println(p.GetNumberSameAsIndex(new int[]{10})); // -1
    }
}
