import java.util.HashMap;
import java.util.Map;

/**
 * 面试题7
 *
 * 参考：
 * 书上测试c++代码和测试例子:
 * https://github.com/zhedahht/CodingInterviewChinese2/blob/master/07_ConstructBinaryTree/ConstructBinaryTree.cpp
 */
public class Problem07 {

    private Map<Integer, Integer> indexForInorder = new HashMap<>();

    /**
     * 重构二叉树
     * @param preOrder 前序
     * @param inOrder 后序
     * @return
     *  BinaryTreeNode
     */
    public BinaryTree reConstructBinaryTree(int[] preOrder, int[] inOrder){

        if (preOrder == null || inOrder == null ||preOrder.length == 0 || inOrder.length == 0){
            return null;
        }

        // 可以根据中序的值来找到相应得位置索引
        for (int i = 0; i < inOrder.length; i++){
            indexForInorder.put(inOrder[i],i);
        }

        return reConstructBinaryTree(preOrder,0, preOrder.length - 1, 0);
    }

    private BinaryTree reConstructBinaryTree(int[] pre, int preL, int preR, int inorderL){
        if (preL > preR){
            return null;
        }
        BinaryTree root = new BinaryTree();
        root.m_value = pre[preL];
        // 在中序序列中获取根节点的位置
        int rootIndex = indexForInorder.get(root.m_value);
        // 左节点个数
        int  leftTreeSize = rootIndex - inorderL; // 根节点 - 后序节点
        // 开始递归
        root.m_left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inorderL);
        root.m_right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inorderL + leftTreeSize + 1);
        return root;
    }


    public static void main(String[] args){

        Problem07 p = new Problem07();

        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTree root = p.reConstructBinaryTree(preorder,inorder);
        System.out.println(root.m_value);
        System.out.println(root.m_left.m_value);
        System.out.println(root.m_right.m_value);
    }
}
