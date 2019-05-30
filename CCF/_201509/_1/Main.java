package CCF._201509._1;

import java.util.*;

/**
 *
 * 201509-1
 * 数列分段
 *
 * http://118.190.20.162/view.page?gpid=T32
 *
 */
public class Main {

    public static void main(String[] args) {

        // 解题思路：遍历整个数组，然后比较前面的数是否相同，如果不相同，则计数器加1
        // 如果相同不作操作。

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Integer[] nums = new Integer[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }

        int count = 1;
        if (len == 1){
            System.out.println(count);
            return;
        }

        int pre = nums[0];
        for (int i = 1; i < len; i++){
            if (pre != nums[i]){
                count++;
            }
            pre = nums[i];
        }

        System.out.println(count);
    }
}
