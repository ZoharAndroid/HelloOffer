package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();

        if (input == null || input.length <=0 || k > input.length || k <= 0){
            return result;
        }

        // 利用优先队列来储存K个数组
        /**
         * @return a negative integer, zero, or a positive integer as the
         *      *         first argument is less than, equal to, or greater than the
         *      *         second.
         */
        PriorityQueue<Integer> maxStack = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int val : input){
            // 添加val值
            maxStack.add(val);
            if (maxStack.size() > k){
                // 超过k位，就删除最顶端的数
                maxStack.poll();
            }
        }
        // 将最大堆添加到list中
        result.addAll(maxStack);

        return result;
    }

    public static void main(String[] args){
        Problem40 p = new Problem40();
        System.out.println(p.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4));
    }
}
