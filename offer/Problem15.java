package offer;

/**
 * 面试题15
 *    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Problem15 {

    /**
     * 方法1：
     *
     * @param n
     * @return
     */
    public int NumberOf1_1(int n) {
        return  Integer.bitCount(n);
    }


    /**
     * 方法2
     * @param n
     * @return
     */
    public int NumberOf1_2(int n){
        int count = 0;

        while (n != 0){
            count++;//n不为0 说明肯定会有至少一个1
            n &= (n - 1);//让n与n-1相与，相当于把最右边的数进行变换
        }

        return count;
    }
}
