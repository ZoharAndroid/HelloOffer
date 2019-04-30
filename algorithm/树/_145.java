package algorithm.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 *  给定一个二叉树，返回它的 后序 遍历。
 *
 *  https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 */
public class _145 {

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            // 解题思路：后序遍历，先遍历左子树，然后遍历右子树，最后遍历根节点
            List<Integer> result = new ArrayList<>();
            postOrder(root, result);
            return result;
        }

        private void postOrder(TreeNode root, List<Integer> result){
            if (root == null){
                return ;
            }

            postOrder(root.left, result);
            postOrder(root.right, result);
            result.add(root.val);
        }
    }
}
