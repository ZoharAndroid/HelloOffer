package algorithm.数组和字符串;

/**
 * 189. 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class _189 {

    private void rotate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        // 解题思路：循环，每次都是保存最后一位，然后移动1位，最后保存的最后一位赋值到第0位
        int lastIndex = nums.length - 1;
        for (int i = 0; i < k; i++){
            // 要移动的位数
            int temp = nums[lastIndex];
            // 向后移动一位
            for (int j = lastIndex; j > 0; j--){
                nums[j] = nums[j - 1];
            }
            // 赋值到第0位
            nums[0] = temp;
        }
    }

    public static void main(String[] args){
        _189 p = new _189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        p.rotate(nums, 3);
        for (int num : nums){
            System.out.print(num + " ");
        }
    }
}
