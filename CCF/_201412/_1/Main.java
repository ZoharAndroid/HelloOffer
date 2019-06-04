package CCF._201412._1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 201412-1
 * 门禁系统
 *
 *
 * http://118.190.20.162/view.page?gpid=T21
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：用HashMap来记录每次出现的次数

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        while (count < len){
            int no  = sc.nextInt();
            map.put(no, map.getOrDefault(no, 0) + 1);
            System.out.print(map.get(no) + " ");
            count++;
        }
    }
}
