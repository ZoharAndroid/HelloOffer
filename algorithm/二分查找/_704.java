package algorithm.二分查找;

/**
 * 704. 二分查找
 *
 * https://leetcode-cn.com/problems/binary-search/
 */
public class _704 {

    public int search(int[] nums, int target) {

        // 解题思路：利用二分查找算法进行判断，如果找到对应目标值，则直接返回索引，如果没有找到目标值，就判断当前的值是小于还是等于中间值
        // 如果小于中间值，说明mid的值偏小了，需要调大，如果大于中间值，说明mid值偏大了，需要调小。
        // 注意：二分查找只适合顺序的数组

        if (nums == null || nums.length == 0){
            return -1;
        }

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (target == nums[midIndex]){
                return midIndex;
            }else if(target < nums[midIndex]){
                // 目标值小于中间值
                endIndex = midIndex - 1;
            }else{
                startIndex = midIndex + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args){
        _704 p = new _704();
        System.out.println(p.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(p.search(new int[]{-1,0,3,5,9,12}, 2));

    }
}
