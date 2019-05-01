package algorithm.树;

/**
 * 104. 二叉树的最大深度
 *  给定一个二叉树，找出其最大深度。
 *  二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *  说明: 叶子节点是指没有子节点的节点。
 */
public class _104 {

    static class Solution {
        public int maxDepth(TreeNode root) {

            // 解题思路：直接用递归，递归每层然后+1，比较左右子树的大小，取较大的即可。

            if (root == null){
                return 0;
            }
            int count = 1;
            count+= Math.max(maxDepth(root.left), maxDepth(root.right));
            return count;

        }


    }

    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        root.left = l1;
        root.right = r1;
        r1.left = l2;
        r1.right = r2;
        System.out.println(s.maxDepth(root));
    }
}
