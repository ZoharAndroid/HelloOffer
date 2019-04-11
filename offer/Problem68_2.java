package offer;

public class Problem68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }

        if (root == p || root == q){
            // 如果存在相同的节点，就返回当前节点
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            // 如果左右子树不为空,说明分布在左右子树中，也就是代表了根节点是祖先节点
            return root;
        }else if (left != null && right == null){
            // 说明节点在左子树部分
            return left;
        }else if (left == null && right != null){
            return right;
        }else{
            return null;
        }
    }
}
