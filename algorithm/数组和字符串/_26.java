package algorithm.数组和字符串;

/**
 * 26. 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26 {

    private int removeDuplicates(int[] nums) {

        // 解题思路：题目已知给定的数组是排序数组，那么就可以用两个指针来处列了，一个快指针，能够遍历数组，一个慢指针，不重复的时候，
        // 就向后移动1位，直到动指针移动到末尾

        if (nums == null || nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return 1;
        }

        int index = 0; // 慢指针
        for (int i = 1; i < nums.length; i++){ // 快指针，遍历数组
            if (nums[index] != nums[i]){
                // 如果不是重复的
                index++; // 慢指针向后移动1位
                nums[index] = nums[i]; // 重新赋值
            }
        }

        return index + 1;
    }

    public static void main(String[] args){
        _26 p = new _26();
        System.out.println(p.removeDuplicates(new int[]{1,1,}));
    }
}
