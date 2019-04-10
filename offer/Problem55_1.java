package offer;

/**
 * // 面试题55（一）：二叉树的深度
 * // 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
 * // 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Problem55_1 {

    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftLength = TreeDepth(root.left); // 递归知道左子树的叶节点
        int rightLength = TreeDepth(root.right);

        return (leftLength > rightLength) ? (leftLength + 1) : (rightLength + 1);
    }
}
