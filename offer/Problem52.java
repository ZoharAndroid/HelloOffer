package offer;

public class Problem52 {

    /**
     * 解题思路：
     * 就是获取两个链表的长度，然后让较长的先走几步，然后两个链表同时移动到同一个节点即可。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 获取两个链表的长度
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);

        ListNode nodeLong = null; // 长链表
        ListNode nodeShort = null; // 段链表
        int lengthDistance = 0; // 链表的距离
        if (length1 > length2){
            // 判断哪个链表比较长
            nodeLong = pHead1;
            nodeShort = pHead2;
            lengthDistance = length1 - length2;
        }else{
            nodeLong = pHead2;
            nodeShort = pHead1;
            lengthDistance = length2 - length1;
        }

        // 长链表就先走几步,然后保持平齐一起走
        for (int i = 0; i < lengthDistance; i++){
            nodeLong = nodeLong.m_nextNode;
        }

        // 共同移动到同一个节点
        while (nodeLong != null && nodeShort != null && nodeLong != nodeShort){
            nodeLong = nodeLong.m_nextNode;
            nodeShort = nodeShort.m_nextNode;
        }

        // 返回共同的节点
        return nodeLong;
    }

    /**
     * 获取链表的长度
     *
     * @param head
     * @return
     */
    private int getListLength(ListNode head){
        int length = 0;
        ListNode node = head;
        while (node != null){
            ++length;
            node = node.m_nextNode;
        }

        return length;
    }
}
