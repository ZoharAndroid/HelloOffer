package offer;

/**
 * 面试题49：丑数
 */
public class Problem49 {

    public int GetUglyNumber_Solution(int N) {
        if (N <= 6){
            return N;
        }

        int[] uglyNumbers = new int[N]; // 生成相应个数的丑数数组用于存储按顺序排列的数组
        uglyNumbers[0] = 1;// 默认第一个丑数为1

        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < N; i++) {
            // 求去下一个2/3/5相乘的下一个丑数值
            int next2 = uglyNumbers[i2] * 2;
            int next3 = uglyNumbers[i3] * 3;
            int next5 = uglyNumbers[i5] * 5;
            // 将最小的丑数加入到数组中
            uglyNumbers[i] = Math.min(next2, Math.min(next3, next5));
            if (uglyNumbers[i] == next2){
                // 如果加入的是乘以2的丑数，那么i2索引就偏移1位，同理，其他的3、5也是一样的操作
                i2++;
            }

            if (uglyNumbers[i] == next3){
                i3++;
            }

            if (uglyNumbers[i] == next5){
                i5++;
            }

        }

        return uglyNumbers[N-1];// 最后也就会返回需要得到的丑数
    }
}
