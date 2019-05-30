package algorithm.树;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106 {

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {

            // 解题思路：根据有序遍历的最后一个节点肯定是根节点，然后在中序遍中划分左子树和右子树，然后在后序遍历中找到左右子树，
            // 最后一个节点就是子根节点，然后用递归，直到构建完成。

            if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
                return null;
            }

            return buildTreeCore(inorder,0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTreeCore(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
            if (instart > inend){
                return null;
            }

            TreeNode root = new TreeNode(postorder[postend]);// 根节点
            // 确定根节点在中序中的位置
            int rootIndex = instart;
            while (rootIndex <= inend && inorder[rootIndex] != root.val){
                ++rootIndex;
            }

            // 找到中旬遍历之后划分左右子树
            root.left = buildTreeCore(inorder,instart,rootIndex - 1, postorder, poststart, poststart + (rootIndex - 1 - instart));
            root.right = buildTreeCore(inorder, rootIndex+ 1, inend, postorder,poststart + (rootIndex - instart), postend - 1);

            return root;
        }
    }
}
