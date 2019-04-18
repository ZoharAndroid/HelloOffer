package algorithm.队列和栈;


/**
 * 200. 岛屿的个数
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class _200 {

    private boolean visited[][];

    private int numIslands(char[][] grid) {

        // 解题思路：就是使用深度优先搜索和广度优先搜索的一个应用。不管用DFS还是BFS，从一个节点出发，分别从上下左右出发，新建一个浏览过的标记二维数组
        // 如果当前节点没有被标记过，那么就说明搜索搜索不到这个位置，也就是独立的岛屿。

        int num = 0;

        if ( grid == null || grid.length == 0){
            return 0;
        }

        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (!visited[i][j]){
                    // 如果没有被浏览过，通过从该节点出发，利用广度优先搜索，标记满足条件的节点
                    BFS(i, j, grid);
                    // 如果剩下的，没有被标记过的 且为1的，说明是不连续的
                    if ('1' == grid[i][j]){
                        num++;
                    }
                }
            }
        }

        return num;
    }

    /**
     * 广度优先搜索
     *
     * @param x
     * @param y
     * @param grid
     */
    private void BFS(int x, int y, char[][] grid){

        visited[x][y] = true;

        // 从上下左右四个方向来搜索
        if ('1' == grid[x][y]) {
            if (x < grid.length - 1 && !visited[x + 1][y]) {
                BFS(x + 1, y, grid);
            }

            if (y < grid[x].length - 1 && !visited[x][y + 1]) {
                BFS(x, y + 1, grid);
            }

            if (x > 0 && !visited[x - 1][y]) {
                BFS(x - 1, y, grid);
            }

            if (y > 0 && !visited[x][y - 1]) {
                BFS(x, y - 1, grid);
            }
        }
    }


    public static void main(String[] args){
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        _200 p = new _200();
        System.out.println(p.numIslands(grid));
    }
}
