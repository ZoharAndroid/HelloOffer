package algorithm.队列和栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        return inOrderForRecursive(root, new ArrayList<>());
    }

    /**
     * 迭代方法
     *
     * @param root
     * @return
     */
    private List<Integer> inOrderIterative(TreeNode root){
        // 解题思路，可以用栈，先从根节点的左子树开始，每访问一个节点添加到栈中，到最后的叶子节点的时候，因为栈正好可以后进先出，
        // 正好可以处理叶子节点，然后访问根节点，然后再访问右子树
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){

            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
    }

    /**
     * 递归方法
     *
     * @param root
     * @return
     */
    private List<Integer> inOrderForRecursive (TreeNode root, List<Integer> result){
        if (root == null){
            return result;
        }

        // 左子树
        inOrderForRecursive(root.left, result);
        // 根节点
        result.add(root.val);
        // 右子树
        inOrderForRecursive(root.right,result);
        return result;
    }
}
