package CCF._201803._1;

import java.util.Scanner;

/**
 * 201803-1
 * 跳一跳
 *
 * http://118.190.20.162/view.page?gpid=T73
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：主要分几种情况，
        // 1. 跳在方块上得1分
        // 2. 跳在方块中心，每次递增2分，这里需要重点处理的就是
        // 当连续跳到中心位置的时候，分数怎么进行累加？
        // 这里可以用一个变量进行保存，如果下一次没有
        // 跳到中心，那么进行重置。
        // 3. 没跳在方块上得0分并结束游戏

        Scanner sc = new Scanner(System.in);
        int score = 0;
        int centerScore = 2;
        int type;
        while ((type = sc.nextInt()) != 0){
            if (type == 1){
                score++;
                centerScore = 2; // 重置跳在中心的分数
            }else if (type == 2 ){
                score += centerScore;
                centerScore += 2;
            }
        }
        System.out.println(score);
    }
}
