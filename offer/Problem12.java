package offer;

/**
 * 面试题12
 * 矩阵中的路径
 *
 * 用递归回溯法
 */
public class Problem12 {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null ||str == null || rows < 1 || cols < 1){
            return false;
        }

        // 将一位数组转换成二维数组
        char[][] newMatrix = arrayToMatrix(matrix,rows,cols);

        // 创建和矩阵同样大小的标识矩阵，用来代表这个空格是否已经被进入了，如果被进入了，就设置为True，不能在进入进去了。
        boolean[][] visited = new boolean[rows][cols];

        int pathLength = 0;
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (hasPathCore(newMatrix,row, rows, col, cols, str, pathLength, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[][] matrix, int row, int rows, int col, int cols,char[] str,int pathLength, boolean[][] visited){
        if (pathLength == str.length){
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >=0 && col < cols && matrix[row][col] == str[pathLength] && !visited[row][col]){
            pathLength++;//进入到下一级
            visited[row][col] = true;//设置true，表示进入了这个空格

            // 然后递归，分别进入上下左右
            hasPath = hasPathCore(matrix,row + 1, rows, col, cols,str,pathLength,visited) ||
                    hasPathCore(matrix, row -1 ,rows, col, cols, str, pathLength, visited) ||
                    hasPathCore(matrix, row, rows, col - 1, cols, str, pathLength,visited) ||
                    hasPathCore(matrix,row, rows, col + 1, cols, str, pathLength ,visited);

            if (!hasPath){
                // 如果不满足，就会退到上一级
                pathLength--;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }

    /**
     * 将一维数组转换成二位矩阵
     *
     * @param array
     * @param rows
     * @param cols
     * @return
     */
    private char[][] arrayToMatrix(char[] array,int rows, int cols){
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                matrix[i][j] = array[index++];
            }
        }

        return matrix;
    }


    public static void main(String[] args){
        Problem12 p = new Problem12();
        System.out.println(p.hasPath("ABTGCFCSJDEH".toCharArray(),3,4,"BFCE".toCharArray()));
    }
}
