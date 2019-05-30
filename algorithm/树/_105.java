package algorithm.树;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _105 {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            // 解题思路：前序遍历的第一个节点就是根节点，根据根节点，然后在中序中找到根节点的位置，划分左右子树，然后根据相应的个数，到
            // 前序中找到左右子树的个数，递归构建左右字数即可。

            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
                return null;
            }

            return build(preorder, 0, preorder.length - 1, inorder,0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){

            if (prestart > preend || instart > inend){
                return null;
            }

            // 创建根节点，每次根节点都是数组中的第一个
            TreeNode root = new TreeNode(preorder[prestart]);

            // 然后到中序遍历中找到对应的根节点索引位置
            int rootIndex = instart;
            while (rootIndex <= inend && inorder[rootIndex] != root.val){
                ++rootIndex;
            }

            int leftLength = rootIndex - instart; // 左子树长度

            // 然后构建左右子树，前序序列中获取左右子树的长度是，从根节点开始，rootIndex长为左子树，后面都是右子树的
            root.left = build(preorder,prestart+1 , prestart + leftLength, inorder, instart, rootIndex - 1);
            root.right = build(preorder, prestart + leftLength + 1, preend, inorder, rootIndex + 1, inend);
            return root;
        }
    }


}
