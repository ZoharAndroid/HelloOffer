package algorithm.队列和栈;

import java.util.ArrayList;
import java.util.List;

/**
 * 155. 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/
 */
public class _155 {

    static class MinStack {

        // 解题思路，既然要找到最小值，那么每次把加入到栈的元素进行比较，来暂时保存最小值。这样就用常数时间获取最小值了

        private List<Integer> data;
        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            this.data = new ArrayList<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            // push前先判断当前的这个值是否比最小值还小，如果比最小值还小的话，就替换掉最小值
            if (min > x){
                min = x;
            }
            data.add(x);
        }

        public void pop() {
            if (data.isEmpty()){
                return;
            }
            // 删除之前，先要判断是否是删除的最小值，如果删除了最小值，那么就需要重新处理了。
            int popResult = data.get(data.size() - 1);
            data.remove(data.size() - 1); // 删除最后面加入的数
            if ( popResult == min){
                // 如果正好删除的数是最小值，那么重新在剩下的数据找到最小的
                min = Integer.MAX_VALUE;
                for (int i = 0; i < data.size(); i++){
                    if (min > data.get(i)){
                        min = data.get(i);
                    }
                }
            }

        }

        public int top() {
            return data.get(data.size() - 1); // 返回最后加入的元素
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.
    }

}
