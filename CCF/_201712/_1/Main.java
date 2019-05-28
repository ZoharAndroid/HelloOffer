package CCF._201712._1;

import java.util.Scanner;

/**
 * 201712-1
 * 最小差值
 *
 * http://118.190.20.162/view.page?gpid=T68
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：取一个数与后面的数相减与最小值进行比较
        // 如果小于最小值，则重新复制给最小值

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                int temp = Math.abs(nums[i] - nums[j]);
                if (temp < min){
                    min = temp;
                }
            }
        }

        System.out.println(min);
    }
}
