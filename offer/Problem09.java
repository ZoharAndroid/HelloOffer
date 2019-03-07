package offer;

import java.util.Stack;

public class Problem09 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                // 如果stack2为空，stack1不为空，那么要把stack1的push到stack2中
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
