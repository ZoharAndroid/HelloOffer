package CCF._201503._1;

import java.util.Scanner;

/**
 * 201503-1
 * 图像旋转
 *
 * http://118.190.20.162/view.page?gpid=T27
 */
public class Main {

    public static void main(String[] args){

        // 解题思路：从最后的列开始依次往前，作为新数组的从第0行开始
        // 注意：这道题提示内存超限，只有80分，应该是系统的问题，
        // 之后题目的内存限制都是512M，但是这道题只有215M。

        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int[][] matix = new int[col][row];
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                matix[i][j] = sc.nextInt();
            }
        }

        int[][] newMatix = new int[row][col];
        for (int i = row - 1; i >= 0; i--){
            for (int j = 0; j < col; j++){
                newMatix[row - i - 1][j] = matix[j][i];
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(newMatix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
