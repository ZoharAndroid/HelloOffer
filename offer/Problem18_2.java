package offer;

/**
 * 面试题18_2：删除链表中的重复节点
 * 测试平台：
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Problem18_2 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.m_nextNode == null) {
            return pHead;
        }

        ListNode next = pHead.m_nextNode;
        if (pHead.m_nValue == next.m_nValue){
            //如果存在相同的值
            while (next != null && pHead.m_nValue == next.m_nValue){
                next = next.m_nextNode;//移动到下面的节点
            }
            return deleteDuplication(next);
        }else{
            //如果有不相同的节点
            pHead.m_nextNode = deleteDuplication(pHead.m_nextNode);
            return pHead;
        }
    }
}
