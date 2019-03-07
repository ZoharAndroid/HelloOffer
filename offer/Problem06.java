package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem06 {

    /**
     * 面试题6：从头到尾打印链表
     * 使用堆栈方式
     * @param head
     * @return
     */
    private List<Integer> printListReversingly_Iteratively(ListNode head){
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.m_nValue);
            head = head.m_nextNode;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return  ret;
    }

    /**
     * 使用递归方法
     *
     * @param node
     * @return
     */
    private List<Integer> printListReversingly_Recursively(ListNode node){
        ArrayList<Integer> ret = new ArrayList<>();
        if (node != null){
                ret.addAll(printListReversingly_Recursively(node.m_nextNode));
                ret.add(node.m_nValue);
        }
        return ret;
    }

    public static void main(String[] args){

        Problem06 p = new Problem06();

        ListNode head = new ListNode();
        ListNode node1 = new ListNode();
        head.m_nValue = 1;
        node1.m_nValue = 2;
        head.m_nextNode = node1;

        System.out.println(p.printListReversingly_Iteratively(head));
        System.out.println(p.printListReversingly_Recursively(head));
    }
}
