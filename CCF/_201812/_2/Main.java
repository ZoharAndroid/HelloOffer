package CCF._201812._2;

import java.util.Scanner;

/**
 *
 * 201812-2
 * 小明放学
 *
 * http://118.190.20.162/view.page?gpid=T81
 *
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：红灯 -> 绿灯 -> 黄灯，而这里的k分别取值为0,1,2,3，分别代表的是街道、红、黄、绿
        // 首先需要解决的就是要求出进过等待时间，红路灯的状态变化
        // 具体变成了什么状态
        // 注意：这道题只有80分，后序待优化

        Scanner sc = new Scanner(System.in);
        int setRedTime = sc.nextInt();
        int setYellowTime = sc.nextInt();
        int setGreenTime = sc.nextInt();
        int len = sc.nextInt();
        int[] types = new int[len];
        long[] times = new long[len];
        for (int i = 0; i < len; i++){
                types[i] = sc.nextInt();
                times[i] = sc.nextLong();
        }

        long count = 0;
        for (int i = 0; i < len; i++){
            int currentType = types[i];
            long time = times[i];
            if (currentType == 0){
                // 到了就直接增加时间
                count += time;
            }else{
                // 首先经过count时间之后，要变化到相应的红路灯下，以及剩下的时间
                long reminingTime = count - time;
                while(reminingTime >= 0){
                    if (currentType == 1){
                        // 当前为红灯,下一个状态就是绿灯
                        reminingTime -= setGreenTime;
                        currentType = changeType(currentType);
                    }else if (currentType == 2){
                        // 当前状态为黄灯，下一个状态就是红灯
                        reminingTime -= setRedTime;
                        // 重新设置当前的红路灯状态
                        currentType = changeType(currentType);
                    }else if (currentType == 3){
                        // 当前状态为绿灯，下个状态就是黄灯灯
                        reminingTime -= setYellowTime;
                        currentType = changeType(currentType);
                    }
                }

                //获取了当前的剩余时间经过如果个等待的时间之后红路灯的变化状态
                if (currentType == 1)
                    // 如果是红灯
                    count += -reminingTime;
                else if (currentType == 2){
                    // 如果为黄灯
                    count += (-reminingTime + setRedTime);
                }
            }
        }

        System.out.println(count);
    }


    // 转换灯的状态
    private static int changeType(int currentType){
        if (currentType == 3){
            // 如果当前状态为绿灯，就要变成为2黄灯
            currentType = 2;
        }else if (currentType == 1){
            // 当前状态为红灯，下一个状态就是绿灯
            currentType = 3;
        }else if (currentType == 2){
            // 当前状态为黄灯，下一个状态就是要变成红灯
            currentType = 1;
        }

        return currentType;
    }
}
