package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题32-2：分行从上到下打印二叉树
 *
 */
public class Problem32_2 {

     public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>  result = new ArrayList<>();
         // 每行的数据结果
         ArrayList<Integer> rowList = new ArrayList<>();
         if (pRoot == null){
             return result;
         }

         // 定义一个队列
         Queue<TreeNode> nodes = new LinkedList<>();
         // 将根节点添加进去
         nodes.add(pRoot);
         // 当前打印的个数
         int curCount = 1;
         //下一行的个数
         int nextCount = 0;
         while ( !nodes.isEmpty()){

             // 如果对列中还有数据
             TreeNode curNode = nodes.poll(); // 获取当前的数据
             // 添加到行
             rowList.add(curNode.val);
             curCount--; // 减去当前行的个数

             if (curNode.left != null){
                 // 如果左边有子节点
                 nodes.add(curNode.left);
                 // 增加个数
                 ++nextCount;
             }

             if (curNode.right != null){
                 nodes.add(curNode.right);
                 ++nextCount;
             }


             // 判断一行是否添加完毕
             if (curCount == 0){
                 // 说明一行的数据已经添加完毕
                 result.add(rowList);
                 curCount = nextCount;
                 nextCount = 0;
                 // 一行数据清空完毕，就需要清空rowList
                 rowList = new ArrayList<>();
             }

         }

         return result;
    }

}
