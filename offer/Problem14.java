package offer;


import java.awt.*;

/**
 * 面试题14：
 *   剪绳子
 *  给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class Problem14 {

    /**
     * 使用动态规划方法
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 2){
            return 0;
        }else if (n == 2){
            return 1;
        }else if (n == 3){
            return 2;
        }

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <=n; i++ ){
            max = 0;
            for (int j = 1; j < i; j++){
                int product = products[j] * products[i - j];

                if (product > max){
                    max = product;
                }
            }
            products[i] = max;
        }

        max = products[n];

        return max;
    }


    /**
     * 贪心算法
     *
     * @param n
     * @return
     */
    public int integerBreak2(int n){
        if (n < 2){
            return 0;
        }else if(n == 2){
            return 1;
        }else if(n == 3){
            return 2;
        }

        //尽可能多的剪出长度为3的子段
        int timesOf3 = n/3;

        //当剩余的长度为4的时候，就不要剪成1和3了，就要剪成两个2的子段
        if (n - timesOf3 * 3 == 1){
            timesOf3--;
        }
        int timesOf2 = (n - timesOf3 * 3)/2;

        return (int)Math.pow(3,timesOf3) * (int) Math.pow(2,timesOf2);
    }
}
