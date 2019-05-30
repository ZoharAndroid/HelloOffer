package CCF._201604._1;

import java.util.Scanner;

/**
 * 201604-1
 * 折点计数
 *
 * http://118.190.20.162/view.page?gpid=T42
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：依次遍历数组，然后前后两个数相减，判断是
        // 正好还是符号，下一次循环的时候一样的操作，如果两次操作
        // 比如：前面一次是正好，后面一次是负号，那么该节点就是折点
        // 这里与前面一次的比较，我是采用的异或比较

        Scanner sc  = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++){
            nums[i] = sc.nextInt();
        }

        int count = 0;
        // 如果只有1-2个数，那么折点就是0个
        if (len <= 2){
            System.out.println(count);
            return;
        }
        boolean flag1 = false;
        if (nums[0] - nums[1] > 0){
            flag1 = true;
        }
        for (int i = 2; i < len; i++){
            boolean flag2 = false;
            if (nums[i - 1] - nums[i] > 0){
                flag2 = true;
            }

            if (flag1^flag2){
                count++;
            }

            flag1 = flag2;
        }

        System.out.println(count);
    }
}
