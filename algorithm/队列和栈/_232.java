package algorithm.队列和栈;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232 {

    // 解题思路：用两个栈来实现队列

   static  class MyQueue {

       private Stack<Integer> stack1;
       private Stack<Integer> stack2;
       private int count;

       /**
        * Initialize your data structure here.
        */
       public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            count = 0;
       }

       /**
        * Push element x to the back of queue.
        */
       public void push(int x) {
            if (stack1.isEmpty() && stack2.isEmpty()){
                stack1.push(x);
            }else if (!stack1.isEmpty() && stack2.isEmpty()){
                stack2.push(x);
            }else if (stack1.isEmpty() && !stack2.isEmpty()){
                // 也就是stack1为空，Stack2不为空的情况，就先需要吧stck2中的数据加入到stack1中，然后在push到stack2中
                int size = stack2.size();
                for ( int i = 0; i < size; i++){
                    stack1.push(stack2.pop());
                }
                stack2.push(x);
            }else{
                stack2.push(x);
            }

            count++;
       }

       /**
        * Removes the element from in front of queue and returns that element.
        */
       public int pop() {
            if (stack1.isEmpty() && !stack2.isEmpty()){
                int size = stack2.size();
                for (int i = 0; i <size; i++){
                    stack1.push(stack2.pop());
                }
            }
            count--;
            return stack1.pop();
       }

       /**
        * Get the front element.
        */
       public int peek() {
           if (stack1.isEmpty() && !stack2.isEmpty()){
               int size = stack2.size();
               for (int i = 0; i <size; i++){
                   stack1.push(stack2.pop());
               }
           }
            return stack1.peek();
       }

       /**
        * Returns whether the queue is empty.
        */
       public boolean empty() {
            return count == 0 ? true : false;
       }

   }

   public static void main(String[] args){
       MyQueue queue = new MyQueue();
       queue.push(1);
       queue.push(2);
       System.out.println(queue.pop()); // 1
       queue.push(3);
       queue.push(4);
       System.out.println(queue.pop()); // 2
       System.out.println(queue.peek());
       //System.out.println(queue.pop()); // 1
       //System.out.println(queue.empty()); // false
   }

}
