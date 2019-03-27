package offer;

/**
 * 面试题33：二叉搜索树的后序遍历序列
 *
 *
 */
public class Problem33 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }

        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySquenceOfBST(int[] sequence, int start, int end){
       if (end - start <= 1){
           return true;
       }

       // root的值在最后面
       int rootValue = sequence[end];

       int index = start;

       while (index < end && sequence[index] <= rootValue){
           // 找到且切分的左右子树的节点值
            index++;
       }

       // 判断右子树是否满足二叉树的条件
        for (int i = index; i < end; i++){
            if (sequence[i] < rootValue){
                return false;
            }
        }

        // 递归调用，左右子树进行判断
        return verifySquenceOfBST(sequence,start, index - 1) && verifySquenceOfBST(sequence,index, end - 1);
    }

    public static void main(String[] args){
        Problem33 p = new Problem33();
        int[] s1 = new int[]{5,7,6,9,11,10,8};
        System.out.println(p.VerifySquenceOfBST(s1));
        int[] s2 = new int[]{7,6,4,5};
        System.out.println(p.VerifySquenceOfBST(s2));
    }
}
