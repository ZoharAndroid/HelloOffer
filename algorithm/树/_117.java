package algorithm.树;

/**
 *
 * 117 填充每个节点的下一个右侧节点指针II
 *
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 */
public class _117 {

    class Solution {
        public Node connect(Node root) {

            // 解题思路：方法同116，用递归的方法来进行处理

            if (root == null ){
                return root;
            }

            if (root.left != null){
                // 分为两种情况 有右子树，和没有右子树
                if (root.right != null){
                    root.left.next = root.right;
                }else{
                    root.left.next = getNextNode(root.next);
                }
            }

            if (root.right != null){
                root.right.next = getNextNode(root.next);
            }

            connect(root.right); // 这里需要先完成root.right的，因为root.left的信息建立在root.right上面的，所以需要先建立root.right的信息。
            connect(root.left);

            return root;
        }

        private Node getNextNode(Node node){
            while (node != null){
                if (node.left != null){
                    return node.left;
                }

                if (node.right != null){
                    return node .right;
                }
                node = node.next;
            }

            return null;
        }
    }
}
