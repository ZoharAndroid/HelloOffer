package offer;

import java.util.ArrayList;

/**
 * 面试题34：二叉树中和为某一值的路径
 */
public class Problem34 {

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return result;
        }

        // 回溯递归
        backTracking(root, target, new ArrayList());

        return result;
    }

    private void backTracking(TreeNode node, int target, ArrayList path){
        if (node == null){
            // 如果node为null，俺么就结束
            return;
        }

        // 路劲添加节点
        path.add(node.val);
        // 判断添加后的路径是否满足目标值
        target -= node.val;

        if (target == 0 && node.right == null && node.left == null){
            // 如果当前节点正好满足且为叶子节点
            result.add(new ArrayList<>(path));
        }else{
            backTracking(node.left, target, path);
            backTracking(node.right, target, path);
        }

        // 最后每次返回一次都需要删除当前的节点一次
        path.remove(path.size() - 1);
    }
}
