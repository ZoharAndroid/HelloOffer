package offer;

/**
 * 面试题24：反转链表
 *
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 *
 */
public class Problem24 {

    public ListNode ReverseList(ListNode head) {
        if (head == null ||head.m_nextNode == null){
            // 如果没有节点或者只有1个节点
            return head;
        }

        ListNode preNode = null;// 当前节点的前一个节点
        ListNode nextNode = null;// 当前节点的下一个节点
        ListNode curNode = head;// 当前节点

        while(curNode != null){
            nextNode = curNode.m_nextNode; // 保存一下当前的节点的下一个节点
            curNode.m_nextNode = preNode; // 让preNode指向当前节点的一个节点，保存这个链表不是断的，具体操作可以在书上画图连线更容易看出来
            preNode = curNode;//改变方向
            curNode = nextNode;

        }

        return preNode;
    }
}
