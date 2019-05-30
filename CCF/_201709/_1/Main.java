package CCF._201709._1;

import java.util.Scanner;

/**
 *
 *  201709-1
 *  打酱油
 *
 *  http://118.190.20.162/view.page?gpid=T63
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：首先应该想到的是，如何才能达到酱油数量最多，那么久尽量先达到
        // 5的倍数瓶，然后再就是3的倍数瓶，如果都不满足，那么就只能买没有促销的瓶数了。
        // 由于酱油每瓶10元，而钱数又是10的倍数，所以可以先将钱数除以10得到
        // 没有促销应该够买到的酱油数量。
        // 接下来就是要处理下，促销后得到的酱油数量
        // 将酱油数量除以5得到超过5瓶促销数量
        // 然后酱油数量以5取余，然后在除以3，剩下的就是满足3瓶的促销，接相加即可。

        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int num = money/10;
        int _5 = num / 5;
        int _3 = (num % 5)/3;
        int count = num + _5 * 2 + _3 ;
        System.out.println(count);
    }
}
