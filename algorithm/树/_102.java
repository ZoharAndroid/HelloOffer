package algorithm.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 *  给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 */
public class _102 {

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            // 解题思路：这里用两个队列，主队列和子队列，主队列主要是用于当前层的，子队列用来保存主队列访问的子队列。当主队列经过一个节点的时候
            // 就把子节点保存在子队列，当主队列为空的时候，也就是说明了当前层已经遍历完了，如果子队列不为空，就把子队列的所有节点赋值给主队列。

            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }

            Queue<TreeNode> mainQueue = new LinkedList<>();
            Queue<TreeNode> subQueue = new LinkedList<>();
            mainQueue.add(root);
            List<Integer> level = new ArrayList<>();
            while (!mainQueue.isEmpty()){
                TreeNode cur = mainQueue.poll();
                if (cur.left != null){
                    subQueue.add(cur.left);
                }
                if (cur.right != null){
                    subQueue.add(cur.right);
                }

                level.add(cur.val);
                if (mainQueue.isEmpty()){
                    while (!subQueue.isEmpty()){
                        mainQueue.offer(subQueue.poll());
                    }

                    result.add(level);
                    level = new ArrayList<>();
                    subQueue = new LinkedList<>();
                }

            }

            return result;
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);

        System.out.println(s.levelOrder(root));
    }
}
