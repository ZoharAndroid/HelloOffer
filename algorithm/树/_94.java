package algorithm.树;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *  给定一个二叉树，返回它的中序 遍历。
 *
 *  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94 {

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            // 解题思路：中序遍历，先左子树，然后根节点，最后右子树

            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            return result;
        }

        private void inOrder(TreeNode root, List<Integer> result){
            if (root == null){
                return;
            }

            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right,result);
        }
    }
}
