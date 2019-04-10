package offer;

/**
 * // 面试题55（二）：平衡二叉树
 * // 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
 * // 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Problem55_2 {

    private boolean isBanlce = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBanlce;
    }

    /**
     * 判断树的高度
     *
     * @param root
     * @return
     */
    private int height(TreeNode root){
        if (root == null || !isBanlce){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1){
            isBanlce = false;
        }
        return 1 + Math.max(left, right);
    }
}
