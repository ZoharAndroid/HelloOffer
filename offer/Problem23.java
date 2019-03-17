package offer;

/**
 * 面试题23：链表中的入口节点
 *
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem23 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.m_nextNode == null){
            // 如果头节点为null或者只有1个节点，无法形成环、
            return null;
        }

        ListNode fast  = pHead;
        ListNode slow = pHead;
        do{
            fast = fast.m_nextNode.m_nextNode;//fast节点以2倍的速度移动
            slow = slow.m_nextNode;//slow以一次移动一个节点的速度移动
        }while(fast != slow);//直到fast节点和slow节点相遇，这里也就意味着，fast节点比slow节点多走了一个圈的距离

        fast = pHead;//让fast节点重新回到头节点，slow节点保持位置不动
        while(fast != slow){
            slow = slow.m_nextNode;
            fast = fast.m_nextNode;//fast节点和slow节点同步移动
        }// 当两者的距离再次相遇的时候，此时的位置也就是入口的位置。
        // 具体原理也就是书本上所说的，关键在于如何找到环形节点的数目，然后让节点先移动环形节点数目的节点，直到相遇，也就是入口的位置。
        // 这里让两个节点相遇，也就是fast节点比slow节点多走了一个环形节点数目，再让fast从新回到头节点，相当于让slow节点提走了前环形数目个节点
        return slow;
    }
}
