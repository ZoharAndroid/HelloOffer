package algorithm.数组和字符串;

/**
 * 747. 至少是其他数字两倍的最大数
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 */
public class _747 {

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        if (nums.length == 1){
            return 0;
        }

        // 找到最大数字并记下索引
        int max = nums[0];
        int index = 0;
        for (int i = 1; i< nums.length; i++){
            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }


        // 判断是否每个数都小于最大数的两倍
        for (int i = 0; i < nums.length; i++){
            if (i != index && nums[i] * 2 > max){
                return -1;
            }
        }

        return index;

    }

    public static void main(String[] args){
        _747 p = new _747();
        System.out.println(p.dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(p.dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
