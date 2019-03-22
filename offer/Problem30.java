package offer;


import java.util.Stack;

/**
 * 面试题30：包含min函数的栈
 *
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem30 {
    // 定义数据栈
    Stack<Integer> dataStack = new Stack<Integer>();
    // 定义最小栈
    Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 压栈操作
     *
     * @param node
     */
    public void push(int node) {
        // 不管怎么样，先把数据压入到栈中
        dataStack.push(node);
        // 如果min栈为空，那么最小值肯定就是当前要加入的节点，如果min栈不为空，那么就要与最小栈的顶部元素进行比较了
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
       return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
