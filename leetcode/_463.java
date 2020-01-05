package leetcode;

public class _463 {

    /**
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     * <p>
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     * <p>
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * <p>
     *  
     * <p>
     * 示例 :
     * <p>
     * 输入:
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * <p>
     * 输出: 16
     * <p>
     * 解释: 它的周长是下面图片中的 16 个黄色的边：
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/island-perimeter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.islandPerimeter(new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}}));  // 16
    }

    static class Solution {
        public int islandPerimeter(int[][] grid) {
            /**
             * 遍历整个二位数组，遇到1就加4， 然后检查上下左右是否有1，遇到一个1就减去一个
             */

            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        count = count + 4;
                        // 接下来判断上下左右是否为1
                        if (i > 0 && grid[i - 1][j] == 1) {
                            count--;
                        }
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                            count--;
                        }

                        if (j > 0 && grid[i][j - 1] == 1) {
                            count--;
                        }
                        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                            count--;
                        }
                    }
                }
            }

            return count;

        }

    }
}
