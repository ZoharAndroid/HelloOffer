package algorithm.数组和字符串;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class _167 {


    private int[] twoSum(int[] numbers, int target) {

        // 解题思路，题目已知这是一个递增的序列，使用双指针操作，start指向开头，end指向末尾，然后依次相加判断是否等于目标值
        // 如果相等，那么start、end即为所求索引
        // 如果加起来的值小于目标值，那么移动较小的start索引；
        // 如果加起来大于目标值，那么移动较大的end索引

        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end){
            if (numbers[start] + numbers[end] == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if (numbers[start] + numbers[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return result;
    }

//      该思路超时

//      private int[] twoSum(int[] numbers, int target) {
//
//        // 解题思路：遍历数组，依次取每个数，目标值减去当前的数，然后在数组中寻找是否包含减去的值.
//        // 最后别忘记了题目要求： 较小的索引在前，大的索引在后，索引从1开始
//
//        int[] result = new int[2]; // 用于存储结果
//        for (int i = 0; i < numbers.length; i++){
//            int temp = target - numbers[i]; // 目标值减去当前值
//            // 剩下的部分寻找temp值
//            for (int j = 0; j < numbers.length; j++){
//                if (i != j && numbers[j] == temp){
//                    if (i > j){ // 比较大小
//                        result[0] = j + 1;
//                        result[1] = i + 1;
//                    }else{
//                        result[0] = i + 1;
//                        result[1] = j + 1;
//                    }
//                    return result;
//                }
//            }
//        }
//
//        return  result;
//    }



    public static void main(String[] args){
        _167 p = new _167();

        int[] result = p.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
