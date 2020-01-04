//404.左子叶之和
public class _404 {
	public static void main(String[] args) {

	}

	static class Solution {
		/**
		 * 执行用时: 8 ms, 在Sum of Left Leaves的Java提交中击败了56.98% 的用户
		 * 
		 * @param root
		 * @return
		 */
		public int sumOfLeftLeaves(TreeNode root) {
			int sum = 0;
			if (root == null) {
				return sum;
			}

			if (root.left != null) {
				if (root.left.left == null && root.left.right == null) {
					sum += root.left.val;
				} else {
					sum += sumOfLeftLeaves(root.left);
				}
			}

			if (root.right != null) {
				sum += sumOfLeftLeaves(root.right);
			}

			return sum;
		}
	}
}
