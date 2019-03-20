package offer;

import java.util.ArrayList;

/**
 * 面试题29：顺时针打印矩阵
 *
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 测试平台
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem29 {

    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();

        if (matrix == null){
            return null;
        }

        int c1 = 0, c2 = matrix.length - 1, r1 = 0, r2 = matrix[0].length - 1;// 定义行 和 列的初始值
        while (r1 <= r2 && c1 <= c2){
            for (int i = r1; i <= r2; i++){
                // 从左往右
                result.add(matrix[c1][i]);
            }
            for (int i = c1 + 1; i <= c2; i++){
                // 从上到下
                result.add(matrix[i][r2]);
            }

            if (c1 != c2){
                // 从右到左，用c1 c2的不同来判断是否有该种情况，c1!=c2说明有多个行
                for (int i = r2 -1; i >= r1; i--){
                    result.add(matrix[c2][i]);
                }
            }

            if (r1 != r2){
                // 从下岛上
                for (int i = c2 -1; i > c1; i--){
                    result.add(matrix[i][r1]);
                }
            }

            r1++;r2--;c1++;c2--;
        }

        return result;
    }


    /**
     * 以下代码错误
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix1(int [][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null){
            return null;
        }

        int start = 0; // 定义起始坐标，起始的位置都是x == y ,所以只需要定义一个变量即可
        int columns = matrix.length; // 行数
        int rows = matrix[0].length; // 列数
        while (columns > start * 2 && rows > start * 2){
            // 这里的条件是控制循环需要打印的圈数，判断一共需要打印几个圈
            printMatrixCircle(matrix, columns, rows, start, result);
            start++;
        }

        return result;
    }

    private void printMatrixCircle(int[][] matrix, int columns, int rows, int start, ArrayList<Integer> result){
        //ArrayList result = new ArrayList();
        // 定义对角坐标位置
        int endX = columns - start - 1;
        int endY = rows - start - 1;

        //从左打印到右边
        for (int i = start; i <= endY; i++){
            //添加数据
            result.add(matrix[start][i]);
        }

        //从上到下打印数据
        if (start < endY){
            for (int i = start + 1; i <= endY; i++){
                result.add(matrix[i][endX]);
            }
        }

        // 从右边到左边进行打印
        if (start < endX && start < endY){
            // 这里必须需要两个条件，因为当有从右到左的数据的时候，必须这样，如果没有，就要考虑特殊情况了
            for (int i = endX - 1; i >= start; i--){
                result.add(matrix[endY][i]);
            }
        }

        // 从下到上进行打印
        if (start < endX && start < endY - 1 ){
            // 如果没有start < endY -1 ，那么就不会有从下到上的数据进行打印了
            for (int i = endY - 1; i >= start + 1; --i){
                result.add(matrix[i][start]);
            }
        }

    }


    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args){

        Problem29 p = new Problem29();
        int[][] test = new int[][]{{1}};
        int[][] test1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] test2 = new int[][]{{1},{2},{3},{4},{5}};
        System.out.println(p.printMatrix(test2));
    }
}
