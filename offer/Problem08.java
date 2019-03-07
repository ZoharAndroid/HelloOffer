package offer;

public class Problem08 {

    /**
     * 面试题8：二叉树的下一个节点
     * 解题思路：
     * 1. 当一个节点的右子树不为空，那么这个节点的下一个节点就是右子树的最左边的节点。
     * 2. 当没有子树或者子节点，那么下一个节点就是向上找第一个左父节点。
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null){
            // 当一个节点的右子树不为空的时候
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left; // 循环到最优后一个子树左节点
            }
            return node;
        }else{
            while( pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode){ // 第一个左子树节点
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args){

    }
}
