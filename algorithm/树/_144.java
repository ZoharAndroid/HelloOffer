package algorithm.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *  给定一个二叉树，返回它的 前序 遍历。
 *
 *  https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 */
public class _144 {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            // 解题思路：前序遍历：就是先从根节点出发，然后遍历左子树，最后遍历右子树

            List<Integer> result = new ArrayList<>();
            preOrder(root, result);
            return result;
        }

        private void preOrder(TreeNode root, List<Integer> result){
            if (root == null){
                return;
            }

            result.add(root.val);
            preOrder(root.left,result);
            preOrder(root.right, result);

        }
    }
}
