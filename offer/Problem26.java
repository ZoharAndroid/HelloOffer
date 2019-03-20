package offer;

/**
 * 面试题26：树的子结构
 *
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 */
public class Problem26 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if (root1 == null || root2 == null){
            return false;
        }

        if (root1.val == root2.val){
            // 如果两个的根节点的值相等
            result = isSubtreeWithRoot(root1, root2);
        }

        if (!result){
            //如果不相等，则继续寻找下一个相等的根节点
            result = HasSubtree(root1.left, root2);
        }

        if (!result){
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    /**
     * 根节点下的子树节点是不是相等
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2){
        if (root2 == null){
            //root2遍历到叶子节点
            return true;
        }

        if (root1 == null){
            // 如果root1遍历到了叶子节点，那么就是说明了不匹配
            return false;
        }

        if (root1.val != root2.val){
            // 如果两个值不相等，就直接返回false
            return false;
        }

        // 递归判断左右子树
        return isSubtreeWithRoot(root1.left,root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}
