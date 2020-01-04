//427.建立四叉树
public class _427 {

	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 * 解题思路：题目的意思就是判断整个区域类是否是相同的值，如果包含有不相同的值，就进行四块切分
		 * 然后在每块区域类再进行判断值是否相同，不相同，再进行四块切分，如此不断递归实现。
		 * @param grid
		 * @return
		 * 执行用时: 4 ms, 在Construct Quad Tree的Java提交中击败了73.10% 的用户
		 */
	    public Node construct(int[][] grid) {
	        return fun(grid, 0, grid[0].length, 0, grid.length);
	    }
	    
	    private Node fun(int[][] grid,int left, int right, int top, int bottom) {
	    	Node root = null;
	    	int key = grid[top][left];
	    	for (int i = top; i < bottom; i++) {
				for (int j = left; j < right; j++) {
					if (key != grid[i][j]) {
						//如果该区域类有不相等的值，则进行四等分切分
						Node topLeft = fun(grid,left,(left + right)/2,top,(top + bottom)/2);
						Node topRight = fun(grid, (left + right)/2, right, top, (top+bottom)/2);
						Node bottomLeft = fun(grid, left,(left + right)/2, (top+bottom)/2, bottom);
						Node bottomRight = fun(grid, (left + right)/2, right, (top+bottom)/2, bottom);
						root = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
						return root;
					}
				}
			}
	    	root = new Node();
	    	root.val = key == 1?true:false;
	    	root.isLeaf = true;
	    	return root;
	    }
	}
}
