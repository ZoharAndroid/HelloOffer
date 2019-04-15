package algorithm.数组和字符串;

/**
 * 54. 螺旋矩阵
 *
 * 解题思路：
 *  分别通过上下左右四个方向来进行移动
 */

import java.util.ArrayList;
import java.util.List;

public class _54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0){
            return result;
        }

        int rowStart = 0; // 行开始位置
        int columnStart = 0; // 列开始位置
        int rowEnd = matrix.length - 1; // 行结束的位置
        int columnEnd = matrix[0].length - 1; // 列结束的位置

        while (rowStart <= rowEnd && columnStart <= columnEnd){
            // 向右移动
            for (int i = columnStart; i <= columnEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++; // 已经搞完一行了

            // 向下移动
            for (int i = rowStart; i <= rowEnd; i++){
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            // 向左移动
            if (rowStart <= rowEnd){
                for (int i = columnEnd; i >= columnStart; i--){
                    result.add(matrix[rowEnd][i]);
                }

            }
            rowEnd--;

            // 向上移动
            if (columnStart <= columnEnd){
                for (int i = rowEnd; i >= rowStart; i--){
                    result.add(matrix[i][columnStart]);
                }
            }
            columnStart++;

        }
        return result;
    }
}
