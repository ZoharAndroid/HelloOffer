package CCF._201612._1;

import java.util.Scanner;

/**
 * 201612-1
 * 中间数
 *
 * http://118.190.20.162/view.page?gpid=T52
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：首先应该想到的方法就是，取一个数，
        // 然后依次与整个数组中的数进行比较。这样做估计
        // 时间为O(N^2)，不知道平台上的时间是否允许，先尝试下.

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i <len; i++){
            nums[i] = sc.nextInt();
        }

        int less = 0;
        int big = 0;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (i == j){
                    continue;
                }
                if (nums[i] < nums[j]){
                    big++;
                }else if (nums[i] > nums[j]){
                    less++;
                }
            }
            if (big == less){
                System.out.println(nums[i]);
                return;
            }else{
                big = 0;
                less = 0;
            }
        }

        System.out.println(-1);
    }
}
