package CCF._201703._1;

import java.util.Scanner;

/**
 *
 * 201703-1
 *
 * 分蛋糕
 *
 * http://118.190.20.162/view.page?gpid=T57
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：依次遍历每块蛋糕的重量，当大于等于k时，人数加1，
        // 这里需要注意的是，最后一个人的蛋糕分配，蛋糕重量不足k的时候，
        // 也应该算作一个人。这里每次给与的蛋糕重量和是否为0进行判断,
        // 如果不为0，说明最后一部分蛋糕还没有分配完，但是人数应该还是要
        // 加1的。

        Scanner sc = new Scanner(System.in);
        int cakes = sc.nextInt();
        int k = sc.nextInt();
        int[] weights = new int[cakes];

        for (int i = 0; i < cakes; i++){
            weights[i] = sc.nextInt();
        }

        int sum = 0;
        int peoples = 0;
        for (int weight : weights){
            sum += weight;
            if (sum >= k){
                peoples++;
                sum = 0;
            }
        }

        if (sum != 0){
            peoples++;
        }

        System.out.println(peoples);
    }
}
