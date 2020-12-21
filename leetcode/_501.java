package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _501 {

    public static void main(String[] args) {

    }

    static class Solution {
        List<Integer> answer = new ArrayList<>();
        int base, count, maxCount;

        public int[] findMode(TreeNode root) {
            dfs(root);
            int[] mode = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++){
                mode[i] = answer.get(i);
            }

            return mode;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            update(node.val);
            dfs(node.right);

        }

        private void update(int val) {
            if (val == base) {
                ++count;
            } else {
                count = 1;
                base = val;
            }

            if (count == maxCount){
                answer.add(base);
            }

            if (count > maxCount){
                maxCount=count;
                answer.clear();
                answer.add(base);
            }
        }
    }
}
