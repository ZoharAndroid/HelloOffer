package algorithm.树;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 */
public class _101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {

            // 解题思路：前序遍历是先根节点-》左子树-》右子树，如果我要判断是否是对称的子树，我遍历从根节点-》右子树-》左子树，然后两者
            // 进行比较，判断是否相同
            return isSymmetric(root, root);
        }

        private boolean isSymmetric(TreeNode root1, TreeNode root2){

            if (root1 == null && root2 == null){
                // 如果两者同时到达叶子节点，那么返回true
                return true;
            }

            if (root1 == null || root2 == null){
                // 如果两个有一个节点提前达到了叶子节点，那么就返回false
                return false;
            }

            if (root1.val != root2.val){
                return false;
            }

            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }
    }
}
