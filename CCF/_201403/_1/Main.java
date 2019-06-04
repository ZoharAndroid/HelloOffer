package CCF._201403._1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 201403-1
 * 相反数
 *
 * http://118.190.20.162/view.page?gpid=T10
 */
public class Main {

    public static void main(String[] args){
        // 解题思路：加入List中，为了防止重复判断，我只判断正数，
        // 如果List中包含了对应的负数，那么就形成了相反数
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++){
            list.add(sc.nextInt());
        }

        int count = 0;
        for (int i = 0; i < len; i++){
            int temp = list.get(i);
            if ( temp > 0 && list.contains( -temp)){
                count++;
            }
        }

        System.out.println(count);
    }
}
