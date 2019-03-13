package offer;

/**
 * 面试题18_1：
 * 在o(1)时间类删除链表节点
 */
public class Problem18_1 {

    private ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null){
            return null;
        }

        if (tobeDelete.m_nextNode != null){
            // 如果不是末尾节点
            ListNode next = tobeDelete.m_nextNode;
            tobeDelete.m_nValue  = next.m_nValue;
            tobeDelete.m_nextNode = next.m_nextNode;//把要删除的节点用后面的节点值进行覆盖
        }else if (tobeDelete == head){
            // 只有1个节点
            head = null;
        }else{
            // 如果要删除的节点位于末尾
            // 这里就需要遍历，依次从头到末尾，找到最后一个节点的前一个节点
            ListNode cur = head;
            while (cur.m_nextNode != tobeDelete){
                cur = cur.m_nextNode;
            }

            cur.m_nextNode = null;
        }

        return head;
    }
}
