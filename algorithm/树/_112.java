package algorithm.树;

/**
 *
 * 112. 路径总和
 *  给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *  说明: 叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/path-sum/
 *
 */
public class _112 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {

            // 解题思路：每次遍历一个节点，然后减去这个节点的值，直到相减的值为0；
            if (root == null){
                return false;
            }

            if (root.left == null && root.right == null){
                // 同时位于叶子节点
                return sum - root.val == 0;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        }

    }
}
