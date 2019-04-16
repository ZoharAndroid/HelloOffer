package algorithm.数组和字符串;

/**
 * 209. 长度最小的子数组
 *
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class _209 {

    private int minSubArrayLen(int s, int[] nums) {

        // 解题思路：滑动窗口，从第1位开始为起始位，取1位，然后求和，判断是否是小于目标值，如果小于目标值，则取起始位后面的，直到大于目标值
        // 然后判断移动的个数是否是最小的。
        // 接下来，就把第2位当做起始位，从这位开始，取后面的值相加，判断是否大于目标值。
        // 直到数组的最后一位
        int sum = 0;
        int count = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];// 移动的动指针
            while ( sum >= s){
                minCount = Math.min(minCount, i - count + 1);
                sum -= nums[count++]; // 减去起始位的数
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;

    }
    // 上面的代码实现，需要改变一下思维，把第一层的循环当做是移动的指针
    // 这也是一个滑动窗口的问题


    public static void main(String[] args){
        _209 p = new _209();
        System.out.println(p.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
