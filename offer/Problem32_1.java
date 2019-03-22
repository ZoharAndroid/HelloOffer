package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题32-1 ： 从上到下打印二叉树
 *
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 测试平台：
 *
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 */
public class Problem32_1 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null){
            // 这里需要注意的是，不能直接返回null，而是返回result，否则平台将会报错
            return result;
        }

        // 首先添加第一个root节点
        queue.add(root);

        while(!queue.isEmpty()){
            //如果队列不为空
            //获取当前节点
            TreeNode curNode = queue.poll();
            result.add(curNode.val);
            //队列添加左右子节点
            if (curNode.left != null){
                queue.add(curNode.left);
            }

            if (curNode.right != null){
                queue.add(curNode.right);
            }

        }

        return result;
    }
}
