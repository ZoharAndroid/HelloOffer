package algorithm.队列和栈;

/**
 * 733. 图像渲染
 *
 * https://leetcode-cn.com/problems/flood-fill/
 *
 */
public class _733 {

    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        //解题思路：可以参考200题(https://github.com/ZoharAndroid/HelloOffer/blob/master/algorithm/%E9%98%9F%E5%88%97%E5%92%8C%E6%A0%88/_200.java)的解法
        // 这上面两题的解题思路是一样的，这不过的起始点是从任意的一个点开始，只需要判定一个节点即可，而200题则是判断所有的点。

        if (image == null || image.length == 0){
            return image;
        }

        // 用于判断是否遍历过
        visited = new boolean[image.length][image[0].length];
        paint(image, sr,sc,newColor, image[sr][sc]);
        return image;
    }

    private void paint(int[][] image, int i, int j,int newColour,int basicColour){
        visited[i][j] = true;
        image[i][j] = newColour;

        // 分别从上下左右四个方向出发
        // 上
        if ( i > 0 && image[i-1][j] == basicColour && !visited[i-1][j]){
            paint(image, i - 1, j, newColour, basicColour);
        }

        // 下
        if ( i < image.length - 1 && image[i+1][j] == basicColour && !visited[i+1][j]){
            paint(image, i + 1, j, newColour, basicColour);
        }

        // 左
        if ( j > 0 && image[i][j - 1] == basicColour && !visited[i][j - 1]){
            paint(image, i, j - 1, newColour, basicColour);
        }

        // 右
        if ( j < image[0].length - 1  && image[i][j+1] == basicColour && !visited[i][j+1]){
            paint(image, i, j+1, newColour, basicColour);
        }
    }
}
