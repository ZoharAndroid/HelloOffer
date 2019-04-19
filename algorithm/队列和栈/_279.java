package algorithm.队列和栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 279. 完全平方数
 *
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class _279 {


    private int numSquares(int n) {

        // 解题思路：BFS的一个应用，所有的节点就是1、4、9...这些节点，然后将target值利用完全平方数进行组合。将目标值依次减去对应的
        // 完全平方数，得到剩余的值，然后对target - 完全平方数 得到的结果进行判断，判断是否为0，如果为0，表示这一层中有满足条件的，
        // 当这一层相减还不能满足条件，那么对相减后的结果加入到队列中，继续下一轮操作，直到相减结果出现为0的情况，即为个数最小的情况。

        // 首先产生满足target值的所有完全平方数
        List<Integer> squares = generatePerfectSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        queue.offer(n); // 将目标加入队列
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            // 对当前队列中的数进行判断
            for (int i = 0; i < size; i++){
                int cur = queue.poll(); // 取出队列中的数据，进行判断
                // 当前的数 依次减去 完全平方数节点
                for (int square : squares){
                    int temp = cur - square;
                    if (temp < 0){
                        break;
                    }

                    if (temp == 0){
                        // 说明这层有满足条件的
                        return level;
                    }

                    if (marked[temp]){
                        // 判断是否访问过
                        continue;
                    }
                    marked[temp] = true;
                    queue.offer(temp);
                }

            }
        }

        return -1;

    }

    private List<Integer> generatePerfectSquares(int n){
        List<Integer> result = new ArrayList<>();
        int base = (int)Math.sqrt(n);
        for (int i = 1; i <= base; i++ ){
            result.add((int)Math.pow(i,2));
        }

        return result;
    }


    public static void main(String[] args){
        _279 p = new _279();
        System.out.println(p.numSquares(12));
    }
}
