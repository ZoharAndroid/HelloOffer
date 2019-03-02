public class Problem03_2 {

    /**
     * 面试题3
     * 题目2：不修改数组找出重复的数字
     * 要求：时间复杂度O(nlogn),空间复杂度O(1)
     * @param numbers
     * @return
     *     正数：输出重复的数字
     *     负数：无重复的数字
     */
    private int getDuplication(int[] numbers){
        if (numbers == null || numbers.length <=0){
            return -1;
        }

        int start = 1;
        int end = numbers.length - 1;   // 1~n个数
        while(end >= start) {
            int middle = (end - start) / 2 + start;    //获取中间的数值
            int count = countRange(numbers, start, middle); //统计该范围中的数值
            // 判断是否是重复的数字
            if (start == end){
                if (count > 1){
                    return start; // 返回重复的数字
                }else{
                    break;// 没有找到重复的数字
                }
            }
            if (count > middle - start + 1){
                // 说明重复的在这个范围
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] numbers, int start, int end){
        if (numbers == null){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] >= start &&numbers[i] <= end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Problem03_2 p = new Problem03_2();

        int[] test1 = {2, 3, 5, 4, 3, 2, 6, 7 };//多个重复的值
        int[] test2 = {3, 2, 1, 4, 4, 5, 6, 7};//1个重复的值
        int[] test3 = { 1, 2, 3, 4, 5, 6, 7, 1, 8};//重复的数字是数组中最小的
        int[] test4 = {1, 7, 3, 4, 5, 6, 8, 2, 8};//重复的数字是数组中最大的
        int[] test5 = {1, 1};
        int[] test6 = {3, 2, 1, 3, 4, 5, 6, 7};//重复数字位于当中
        int[] test7 = {1, 2, 2, 6, 4, 5, 6 };//多个重复的数字
        int[] test8 = {1, 2, 2, 6, 4, 5, 2};//一个数字重复多次
        int[] test9 = {1, 2, 6, 4, 5, 3};//无重复
        int[] test10 = null;//无效输入

        System.out.println("1: " + p.getDuplication(test1));
        System.out.println("2: " + p.getDuplication(test2));
        System.out.println("3: " + p.getDuplication(test3));
        System.out.println("4: " + p.getDuplication(test4));
        System.out.println("5: " + p.getDuplication(test5));
        System.out.println("6: " + p.getDuplication(test6));
        System.out.println("7: " + p.getDuplication(test7));
        System.out.println("8: " + p.getDuplication(test8));
        System.out.println("9: " + p.getDuplication(test9));
        System.out.println("10: " + p.getDuplication(test10));


    }
}
