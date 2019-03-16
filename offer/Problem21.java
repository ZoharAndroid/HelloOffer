package offer;

/**
 * 面试题21：
 *
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 *  测试平台： https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Problem21 {

    /**
     * @param array
     */
    public void reOrderArray(int[] array) {
        // 奇数数目
        int countOdd = 0;
        // 统计奇数数目
        for (int i: array) {
            if (i % 2 != 0) {
                countOdd++;
            }
        }
        // 复制一个数组
        int[] copy = array.clone();
        // 定义起始位置
        int i = 0;
        int j = countOdd;
        for (int num : copy){
            if (num % 2 == 1){
                //如果当前数为奇数
                array[i++] = num;
            }else{
                array[j++] = num;
            }
        }

    }


    public static void main(String[] args){
        Problem21 p =new Problem21();
        int[] array = new int[]{1,2,3,4,5};
        p.reOrderArray(array);
        for (int num : array){
            System.out.println(num);
        }
    }
}
