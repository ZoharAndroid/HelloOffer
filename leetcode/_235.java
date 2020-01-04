

public class _235 {
	public static void main(String[] args) {

	}

	static class Solution {
		/**
		 * 由于二叉搜索树的特点是左<根<右，所以根节点的值一直都是中间值， 大于左子树的所有节点值，小于右子树的所有节点值，那么我们可以做如下的判断，
		 * 如果根节点的值大于p和q之间的较大值，说明p和q都在左子树中，那么此时我们就进入根节点的左子节点继续递归，
		 * 如果根节点小于p和q之间的较小值，说明p和q都在右子树中，那么此时我们就进入根节点的右子节点继续递归，
		 * 如果都不是，则说明当前根节点就是最小共同父节点，直接返回即可
		 * 
		 * @param root
		 * @param p
		 * @param q
		 * @return
		 */
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null || p == null || q == null) {
				return root;
			}
			
			if (root.val > Math.max(p.val, q.val)) {
				return lowestCommonAncestor(root.left, p, q);
			}else if(root.val < Math.min(p.val, q.val)) {
				return lowestCommonAncestor(root.right, p, q);
			}else {
				return root;
			}
		}
	}
}
