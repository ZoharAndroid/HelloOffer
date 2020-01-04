

public class _226 {
	public static void main(String[] args) {
		
	}
	
	
	static class Solution {
		/**
		 * 交换左右结点
		 * 
		 * @param root
		 * @return
		 */
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null) {
				return root;
			}
	        
	        TreeNode node = root.left;
	        root.left = root.right;
	        root.right = node;
	        
	        invertTree(root.left);
	        invertTree(root.right);
	        return root;
	    }
	}
}
