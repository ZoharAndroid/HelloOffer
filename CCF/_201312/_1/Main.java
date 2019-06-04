package CCF._201312._1;

import java.util.*;

/**
 * 201312-1
 * 出现次数最多的数
 *
 * http://118.190.20.162/view.page?gpid=T5
 *
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：用HashMap来记录每次出现的次数，然后遍历Map找出数最大的

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 遍历map集合，判断个数最大的
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        int min = Integer.MAX_VALUE;
        int countMax = 0;
        while (iterator.hasNext()){
            int num = iterator.next();
            int count = map.get(num);
            if (countMax < count ){
                countMax = count;
                min = num;
            }else if (countMax == count){
                if (min > num){
                    min = num;
                }
            }
        }

        System.out.println(min);
    }
}
