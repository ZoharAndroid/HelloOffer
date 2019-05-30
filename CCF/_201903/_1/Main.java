package CCF._201903._1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  201903-1
 * 小中大
 *
 * http://118.190.20.162/view.page?gpid=T89
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：存在的盲点就是求中位数。
        // 求解中位数，如果个数是偶数个，那么中位数就是中间两个数相加然后除以2
        // 如果个数是奇数个，那么中位数就是中间的那个数。
        // 还有一个主要注意的点就是，中位数可能会存在小数点，因此需要处理一下：
        // 如果能够被整除，那么就需要强制转换一下，如果不能被整除，那么直接输出即可。

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++){
            nums[i] = sc.nextInt();
        }

        // 进行排序
        Arrays.sort(nums);
        // 去最小值
        int min = nums[0];
        // 最大值
        int max = nums[length - 1];
        System.out.print(max + " ");

        // 中位数
        double mid;
        if (length % 2 == 0){
            // 偶数 -> 去中间的两个数求和然后除以2
            mid = (nums[length/2] + nums[length/2 - 1])/2.0;
            if ((nums[length/2] + nums[length/2 - 1]) % 2 == 0){
                // 如果能够被整除
                System.out.print((int)(mid) + " ");
            }else{
                System.out.print(mid + " ");
            }

        }else{
            // 奇数 -> 取中间的即为中位数
            mid = nums[length/2];
            System.out.print((int)mid + " ");
        }

        System.out.print(min + " ");
    }
}
