package CCF._201512._1;

import java.util.Scanner;

/**
 * 201512-1
 * 数位之和
 *
 * http://118.190.20.162/view.page?gpid=T37
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：对一个数进行取余，然后重新赋值。一开始以为会超过范围，发现
        // 注意这里Integer最大值2147483647，小于题目的要求，所以不需要用Long类型。
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        System.out.println(sum);
    }
}
