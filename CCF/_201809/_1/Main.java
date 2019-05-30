package CCF._201809._1;

import java.util.Scanner;

/**
 *
 * 201809-1
 * 卖菜
 *
 * http://118.190.20.162/view.page?gpid=T79
 *
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：（前值+自己+后值）/3，需要处理的就是第1位和最后一位

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++){
            if ( i == 0){
                result[i] = (nums[i] + nums[i + 1])/2;
            }else if ( i == len - 1){
                result[i] = (nums[i] + nums[i - 1])/2;
            }else{
                result[i] = (nums[i - 1] + nums[i] + nums[i + 1])/3;
            }
        }

        for (int i = 0; i < len; i++){
            System.out.print(result[i] + " ");
        }
    }
}
