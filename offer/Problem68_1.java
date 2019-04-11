package offer;

/**
 * 面试题68_1：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Problem68_1 {

    /**
     * 解题思路：
     *  因为是二叉搜索树数，所以根节点的左边子树 < 根节点 < 右边子树，所以，知道判断给定的 p 和 q 两个节点都小于当前节点的值，那么
     *  说明在当前节点左子树，如果大于当前节点的值，说明共同祖先的节点在当前节点的右子树中，如果出现了一个在左边，一个在右边，说明，
     *  当前节点为共同祖先节点。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            // 当前节点都大于给定的两个节点值，说明共同祖先节点在左子树
            return lowestCommonAncestor(root.left, p, q);
        }else if (root.val < p.val && root.val < q.val){
            // 当前节点都小于给定的两个节点，那么说明祖先节点在右子树中
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
