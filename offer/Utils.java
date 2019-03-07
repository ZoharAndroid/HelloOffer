package offer;

public class Utils {
    /**
     * 链表末尾添加节点
     *
     * @param head 头节点
     * @param value 要添加的值
     * @return
     *  头节点
     */
    public static ListNode addToTail(ListNode head,int value){
        ListNode newNode = new ListNode();
        newNode.m_nValue = value;
        newNode = null;

        if (head == null){
            // 如果当前的链表为空链表，那么就把当前要添加的节点当做头结点。
            head = newNode;
        }else{
            // 如果当前的链表不为空，则遍历到最后的末尾节点
            ListNode tempNode = head;
            while (tempNode.m_nextNode != null){
                tempNode = tempNode.m_nextNode;
            }
            //在末未进行添加节点
            tempNode.m_nextNode = newNode;
        }
        return head;
    }


    /**
     * 删除链表中指定的数据节点
     *
     * @param head
     * @param value
     */
    public static  void removeNode(ListNode head, int value){
        if (head == null) {
            return;
        }

        ListNode preNode = head;
        ListNode curNode = preNode;
        while (curNode != null){
            if (curNode.m_nValue == value){
                // 如果当前的节点正确
                preNode.m_nextNode = curNode.m_nextNode;//前面的节点指向后面的节点
            }
            //移动到一面的节点
            curNode = curNode.m_nextNode;
            preNode = preNode.m_nextNode;
        }
    }
}
