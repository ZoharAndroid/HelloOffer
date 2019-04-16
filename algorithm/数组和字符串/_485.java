package algorithm.数组和字符串;

/**
 * 485. 最大连续1的个数
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 */
public class _485 {

    private int findMaxConsecutiveOnes(int[] nums) {

        // 解题思路：用两个指针来移动，一个index指针，用来指向相同的连续的1，当后面一位为1，index就加1，相当于向后移动1位，如果
        // 遇到0了，那么就将index重置为0，重新开始，重置为0之前，首先保存一下index值。最后比较index值和保存的值，看哪个大输出哪个。

        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                index++;

                if (max < index){
                    max = index;
                }
            }else{
                // 当遇到0的时候
                index = 0;
            }
        }
        // 最后比较一下index和max的大小
//        if (max < index){
//            max = index;
//        }

        return max;
    }


    public static void main(String[] args){
        _485 p = new _485();
        System.out.println(p.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
