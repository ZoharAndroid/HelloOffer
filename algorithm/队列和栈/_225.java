package algorithm.队列和栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225 {

    // 解题思路：用两个队列来实现栈。
    // push操作：队列1直接用于添加数据的队列，然后判断队列2中是否有数据，如果有数据，把队列2中的数据添加到队列1，整合一下，然后再赋值给队列2

    static class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        private int count;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
            this.count = 0;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            // 反正数据之添加到队列1中
            queue1.offer(x);
            count++;
            // 将队列2中的数据添加到队列1中
            if (!queue2.isEmpty()){
                int size = queue2.size();
                for (int i = 0; i < size; i++){
                    queue1.offer(queue2.poll());
                }
            }
            // 接下来再把队列1中的数据全部都弄到队列2中，这到后面不管怎么样，都可以对队列2操作，而不用管队列1了
            int size = queue1.size();
            for (int i = 0; i < size; i++){
                queue2.offer(queue1.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            count--;
            return queue2.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue2.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return count == 0 ? true : false;
        }
    }

    public static void main(String[] args){
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top()); // 2
        System.out.println(obj.pop()); // 2
        System.out.println(obj.top()); // 1
        obj.push(3);
        System.out.println(obj.top()); // 3
        System.out.println(obj.pop()); // 3
        System.out.println(obj.top()); // 1

    }
}
