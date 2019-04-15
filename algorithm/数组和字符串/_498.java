package algorithm.数组和字符串;

/**
 * 498. 对角线遍历
 *
 * 解题思路：
 *  可以看做分层处理，每个对角线为一层，所以整个二维数组可以看做 ↗ —> ↙ ↓这些情况，其中 → ↓ 只有在边界情况下发生
 */
public class _498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int row = matrix.length; // 二维数组的长
        int col = matrix[0].length; // 二位数组的列
        int[] res = new int[row * col];
        int r = 0, c = 0; // r + c 用于判断当前位于第几层的具体哪个位置，用于判断边界情况
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // r + c 即为遍历的层数，偶数向上遍历，奇数向下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 往右移动一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 往下移动一格准备向下遍历
                    c++;
                } else {
                    // 往上移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 往右移动一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 往上移动一格准备向上遍历
                    r++;
                } else {
                    // 往下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        _498 p = new _498();
        p.findDiagonalOrder(new int[][]{{ 1, 2, 3 },{4, 5, 6},{7, 8, 9}});
    }
}
