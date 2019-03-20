package offer;

/**
 * 面试题27：二叉树的镜像
 *
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 测试平台
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 
 *
 */
public class Problem27 {

    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            // 如果没有子节点，那么交换就到此结束
            return;
        }

        // 有子树，那么就交换当前的节点
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        // 递归左右子树节点的交换
        if ( root.right != null){
            Mirror(root.right);
        }

        if (root.left != null){
            Mirror(root.left);
        }
    }
}
