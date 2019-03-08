package offer;

/**
 * 面试题13
 *  机器人的运动范围
 *
 *  还是一种利用回溯方法来解决的问题
 *
 */
public class Problem13 {

    /**
     *
     * @param threshold 规定的值，阈值
     * @param rows 行数
     * @param cols 列数
     * @return
     *  机器人能达到的格子
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0){
            return 0;
        }

        // 创建相同大小的标志位矩阵
        boolean[][] visited = new boolean[rows][cols];

        int count = movingCountCore(threshold, rows,cols, 0, 0, visited);

        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited){
        int count = 0;
        // 判断是否能够进入当前的格子
        if (check(threshold,rows,cols,row,col,visited)){
            // 设置当前空格标志位
            visited[row][col] = true;

            //递归调用,求邻近的上下左右
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }

        return count;
    }


    /**
     * 检查当前的格子是否满足条件
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    private boolean check(int threshold,int rows, int cols, int row, int col,boolean[][] visited){
        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigitalSum(row) + getDigitalSum(col) <= threshold && !visited[row][col]){
            return true;
        }

        return false;
    }

    /**
     * 求每位相加之和
     *
     * @param numbers
     * @return
     */
    private int getDigitalSum(int numbers){
        int sum = 0;
        while(numbers > 0){
            sum += numbers % 10;
            numbers /= 10;
        }

        return sum;
    }

    public static void main(String[] args){

    }
}
