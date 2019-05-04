package algorithm.树;

/**
 * 236. 二叉树的最近公共祖先
 *  给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *  百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *  满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *  https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class _236 {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // 解题思路：从根节点出发，如果其中有一个等于根节点，那么不管另外一个节点在任何位置，最近公共祖先也就是根节点。
            // 如果同时为左子树，那么最先找到的就是公共祖先
            // 如果左右子树各一个，说明根节点也就是最近公共祖先
            // 如果同时为右子树，那么最先找到的右边子树就是最近公共祖先

            if (root == null){
                return root;
            }

            if (root == p || root == q){
                return root; // 递归退出条件，如果那个先找到则先返回哪个节点
            }

            TreeNode left = lowestCommonAncestor(root.left, p , q);
            TreeNode right = lowestCommonAncestor(root.right, p ,q);

            if (left != null && right != null){
                return root; // 分布在左右子树，那么最近公共祖先肯定就是root节点了
            }else if (left != null && right == null){
                // 全部分布在左子树，最先找到的也就是最近公共左线
                return left;
            }else if (left == null && right != null){
                return  right;
            }else{
                return null;
            }
        }
    }
}
