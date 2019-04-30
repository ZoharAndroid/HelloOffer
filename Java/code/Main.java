package Java.code;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int strCount = sc.nextInt(); // 字符串个数
        sc.nextLine();
        String[] strs = new String[strCount];
        for (int i = 0; i < strCount; i++){
            strs[i] = sc.nextLine();
        }

        StringBuilder sb  = new StringBuilder();

        // 1. 进行切分
        for (int i = 0; i < strs.length; i++){
            // 遍历每个字符串
            char[] ch = strs[i].toCharArray();
            if (ch.length < 8){
                sb.append(ch);
                // 添加字符0
                int diff = 8 - ch.length;
                for (int j = 0; j < diff; j++){
                    sb.append('0');
                }
            }else if (ch.length == 8){
                // 长度等于8，不用进行修改
                sb.append(ch);
            }else{
                // 长度大于8
                sb.append(strs[i]); // 添加
                int diff = 8 - ch.length % 8;
                for (int j = 0; j < diff; j++){
                    sb.append('0');
                }
            }
        }

        //每8个字符进行切分
        String str = sb.toString();
        int counts = str.length()/8;
        String[] strings = new String[counts];
        for (int i = 0; i < counts; i++){
            strings[i] = String.valueOf(sb.substring(i * 8, i* 8 + 8));
        }

        // 接下来进行排序
        for (int i = counts -1; i > 0 ; i--){
            for (int j = 0 ; j < i; j++){
                if ( strings[j].compareTo(strings[j + 1]) > 0){
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i< counts; i++) {
            System.out.print(strings[i] + " ");
        }
    }



}
