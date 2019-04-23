package algorithm.队列和栈;

import java.util.LinkedList;
import java.util.Queue;

public class _542 {

    public int[][] updateMatrix(int[][] matrix) {

        // 解题思路：利用BFS和队列，因为数组中的元素如果为0，那么距离就是直接为0，所以可以把数组中的为0的元素当做第一层，然后BFS。
        // 如果数组中的元素不为0，那么可以设置成 最大的值。

        Queue<int[]> queue = new LinkedList<>();
        int[][] vector = new int[][]{{-1,0}, {1,0}, {0,-1},{0,1}}; // 上下左右四个方向

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j]==0){
                    // 在队列中添加数组中所有元素都为0的点，当做第一层（根节点）来处理
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE; // 设置成最大值
                }
            }
        }

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < vector.length; i++){
                int x = cur[0] + vector[i][0];
                int y = cur[1] + vector[i][1]; // 上下左右节点

                if ( x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[cur[0]][cur[1]] + 1){
                    // 判断上下左右节点如果大于当前节点 +1的值，那么就需要重置一下上下左右节点的值
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args){
        _542 p = new _542();
        int[][] matix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        for (int i = 0; i < matix.length; i++){
            for (int j = 0; j < matix[0].length; j++){
                System.out.print(p.updateMatrix(matix)[i][j]+" ");
            }
            System.out.println();
        }
    }
}
