package algorithm.数组和字符串;

/**
 * 283. 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283 {

    private void moveZeroes(int[] nums) {

        // 解题思路：首先想到的是用双指针，快指针遍历数组，还有一个慢指针：当非零的时候，就将快指针指向的数复制到慢指针指向的位置，
        // 当指向的数是零的时候就跳过，最后，添加零，这里需要考虑0的个数，也就是用数组长度减去慢指针移动的步数就可以得到零的个数了。

        if (nums == null || nums.length == 0){
            return;
        }


        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        // 添加0
        for (int i = index ; i < nums.length; i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args){
        _283 p = new _283();
        int[] nums = new int[]{0,1,0,3,12};
        p.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
