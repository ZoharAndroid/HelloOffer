package offer;

/**
 * 面试题28 ： 对称的二叉树
 *
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem28 {

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        if (pRoot1 == null && pRoot2 == null){
            // 如果同时达到叶子节点
            return true;
        }

        if (pRoot1 == null || pRoot2 == null){
            // 如果其中有一个提前达到叶子节点
            return false;
        }

        if (pRoot1.val != pRoot2.val){
            // 判断两个节点是否相等
            return false;
        }

        // 递归，判断遍历的前序序列节点后对称的前序遍历节点是否相等
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right , pRoot2.left);
    }
}
