package CCF._201609._1;

import java.util.Scanner;

/**
 * 	201609-1
 * 	最大波动
 *
 * 	http://118.190.20.162/view.page?gpid=T47
 */
public class Main {
    public static void main(String[] args){

        // 解题思路：就是前后数相减，然后比较与最大值，
        // 大于最大值，那么重新赋值给最大值
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++){
            int temp = Math.abs(nums[i - 1] - nums[i]);
            if (temp > max){
                max = temp;
            }
        }

        System.out.println(max);
    }
}
