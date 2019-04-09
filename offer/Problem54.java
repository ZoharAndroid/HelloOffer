package offer;

public class Problem54 {

    private int count = 0;
    private TreeNode result;

    public TreeNode KthNode(TreeNode pRoot, int k) {

        KthNodeCore(pRoot, k);
        return result;
    }

    private void KthNodeCore(TreeNode pRoot, int k){
        if (pRoot == null || count >= k){
            return;
        }

        KthNodeCore(pRoot.left, k );
        count++;
        if (count == k){
            // 如果当前的为第k个
            result= pRoot;
        }
        // 如果左子树照完了，还是不满足，那么继续右子树
        KthNodeCore(pRoot.right, k);
    }
}
