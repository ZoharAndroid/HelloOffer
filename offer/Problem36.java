package offer;

/**
 * 面试题36：二叉搜索树与双向链表
 */
public class Problem36 {

    private TreeNode pre = null; // 前一个节点
    private TreeNode head = null; // head节点

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode root){
        if (root == null){
            return;
        }

        // 递归调用到最左边的节点
        inOrder(root.left);
        // 节点左边的指向前一个节点
        root.left = pre;
        // 移动到root节点
        if (pre != null){
            pre.right = root;
        }
        pre = root;// 移动到root节点
        if (head == null){
            // 设置head节点
            head = root;
        }

        inOrder(root.right);
    }


    public static void main(String[] args){
        Problem36 p = new Problem36();
        TreeNode head = new TreeNode();
        head.val = 10;
        TreeNode l1_left = new TreeNode();
        l1_left.val = 6;
        TreeNode l1_right = new TreeNode();
        l1_right.val= 14;
        head.left = l1_left;
        head.right = l1_right;

        head = p.Convert(head);
        System.out.println(head.val + " " + head.right.val + " " + head.right.right.val);
    }
}
