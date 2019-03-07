package offer;

public class Problem03_1 {

    /**
     * 面试题3
     * 题目1：找出数组中重复的数字
     * 要求：时间复杂度为O(n)，空间复杂度为O(1)
     * @param numbers：给定的数组
     * @return
     *  true：数组中存在重复的数字
     *  false：输入数组不正确或者不存在重复的数字
     */
    private boolean duplicate(int[] numbers){
        if(numbers == null || numbers.length <= 0)
            return false;

        for(int i = 0; i <  numbers.length ; ++i) {
            if(numbers[i] < 0 || numbers[i] >  numbers.length  - 1)
                return false;
        }

        for(int i = 0; i <  numbers.length ; ++i) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    // 输出重复的值
                    System.out.println(numbers[i]);
                    return true;
                }

                // 交换numbers[i]和numbers[numbers[i]]
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }

    public static void  main(String[] args){

        Problem03_1 p = new Problem03_1();

        int[] test1 = {2, 1, 3, 1, 4};  // 重复值为数组中最小的
        int[] test2 = {2, 4, 3, 1, 4}; //重复值为数组中最大的
        int[] test3 = {2, 4, 2, 1, 4};  //数组中存在多个重复的值
        int[] test4 = {2, 1, 3, 0, 4};  //数组中没有重复的值
        int[] test5 = null; //无效输入

        System.out.println(p.duplicate(test1));
        System.out.println(p.duplicate(test2));
        System.out.println(p.duplicate(test3));
        System.out.println(p.duplicate(test4));
        System.out.println(p.duplicate(test5));
    }
}
