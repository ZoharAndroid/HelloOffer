package offer;

/**
 * 面试题22：
 * 链表中的倒数第K个节点
 *
 * 测试平台：
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 */
public class Problem22 {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0){
            return null;
        }

        ListNode p1 = head;
        while (p1 != null && k-- > 0){
            // p1先移动到第K个节点的位置
            p1 = p1.m_nextNode;
        }

        if (k > 0){
            // 如果此时的k还是大于0，说明节点数目不够移动k位
            return null;
        }

        ListNode p2 = head;//让p2个节点移动到head
        while (p1 != null){
            // 当P1移动到末尾，p2节点也就移动到了倒数第K个节点了
            p1 = p1.m_nextNode;
            p2 = p2.m_nextNode;
        }

        return p2;
    }

}




