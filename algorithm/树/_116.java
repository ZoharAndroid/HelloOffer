package algorithm.树;

/**
 *
 * 116. 填充每个节点的下一个右侧节点指针
 *
 */
public class _116 {

    class Solution {
        public Node connect(Node root) {

            // 解题思路：用递归方法来解决。画一个草图更好理解
            if (root == null){
                return root;
            }
            if (root.left != null) {
                root.left.next = root.right; // 将root的左节点执行root的右节点
            }
            if (root.next != null && root.right != null){
                // root.next说明存在同级的右节点，并且root.right也不为null
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }

}
