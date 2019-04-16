package algorithm.数组和字符串;

/**
 * 27. 移除元素
 *
 * https://leetcode-cn.com/problems/remove-element/
 */
public class _27 {

    private int removeElement(int[] nums, int val) {

        // 解题思路：用两个指针，一个for循环中的i，可以遍历所有数组，一个index，当与val相等的时候，不移动，不重复的时候就向后移动，这样就可以覆盖掉指定的数所在的位置

        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }


    public static void main(String[] args){
        _27 p = new _27();
        int[]  nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(p.removeElement(nums,2));
    }
}
