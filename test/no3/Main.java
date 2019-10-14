package test.no3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int length  = sc.nextInt();

        int[] nums = new int[length];
        for (int i = 0; i < length; i++){
            nums[i] = sc.nextInt();
        }

        // 便利每个数字，判断当前数字是否是最大的

        int max = nums[0];
        for (int i = 1; i < length; i++){
            if (max < nums[i]){
                max = nums[i];
            }else{
                nums[i] = max;
            }
        }

        for (int num : nums){
            System.out.print(num + " ");
        }
    }
}
