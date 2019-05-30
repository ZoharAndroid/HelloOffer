package CCF._201812._1;

import java.util.Scanner;

/**
 *  201812-1
 *  小明上学
 *
 *  http://118.190.20.162/view.page?gpid=T80
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：主要是分清楚k的几种情况，
        // 当k等于0的时候，时间累积
        // 当k等于1的时候，也就是红灯，时间累积
        // 当k等于2的时候，黄灯，时间累积，并且需要加上红灯的时减
        // 当k等于3的时候，跳过

        Scanner sc = new Scanner(System.in);
        int rTime = sc.nextInt();
        int yTime = sc.nextInt();
        int gTime = sc.nextInt();
        int streets = sc.nextInt();
        int[][] times = new int[streets][2];
        for (int i = 0; i < streets; i++){
            for (int j = 0; j < 2; j++){
                times[i][j] = sc.nextInt();
            }
        }

        int totalTime = 0;
        for (int i = 0; i < streets; i++){
            int type = times[i][0];
            int time = times[i][1];
            switch (type) {
                case 0: // 街道
                case 1: // 红灯
                    totalTime += time;
                    break;
                case 2: // 黄灯
                    totalTime += time + rTime;
                    break;
                case 3:
                    break;
            }
        }
        System.out.println(totalTime);
    }
}
