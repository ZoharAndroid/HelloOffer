package CCF._201409._1;

import java.util.Scanner;

/**
 * 201409-1
 * 相邻数对
 *
 * http://118.190.20.162/view.page?=T16
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：取一个数，然后依次遍历后面的数，判断是否相差1

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (Math.abs(nums[i] - nums[j]) == 1){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
