//437.路径总和 III
public class _437 {
	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 * 解题思路：递归遍历所有的节点，如果满足则+1
		 * @param root
		 * @param sum
		 * @return
		 * 执行用时: 28 ms, 在Path Sum III的Java提交中击败了52.36% 的用户
		 */
	    public int pathSum(TreeNode root, int sum) {
	        if (root == null) {
				return 0;
			}
	        return fun(root,sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
	    }
	    
	    private int fun(TreeNode root,int sum) {
	    	if (root == null) {
				return 0;
			}
	    	return ((root.val == sum)?1:0)+fun(root.left,sum-root.val)+fun(root.right,sum-root.val);
	    }
	}
}
