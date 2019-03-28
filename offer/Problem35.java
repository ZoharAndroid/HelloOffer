package offer;

/**
 * 面试题35：复杂链表的复制
 */
public class Problem35 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }

        // 第一步：插入新节点
        RandomListNode currNode = pHead;
        while (currNode != null){
            // 新建一个复制节点
            RandomListNode cloneNode = new RandomListNode(currNode.label);
            // 复制节点指向当前节点同一个后面的节点
            cloneNode.next = currNode.next;
            // 当前节点指向复制节点
            currNode.next = cloneNode;
            // 当前节点移动到后面的节点
            currNode = cloneNode.next;
        }

        // 第二步：为复制节点添加随机指向
        currNode = pHead;
        while (currNode != null){
            // curNode的后面一个节点其实就是复制节点
            RandomListNode cloneNode = currNode.next;
            if (currNode.random != null) {
                // 如果有随机指向的话,指向随机直接后面一个节点
                cloneNode.random = currNode.random.next;
            }
            // currnode移动到下一个节点
            currNode = cloneNode.next;
        }

        // 第三步：进行拆分，将原来的链表和复制的链表进行拆分
        currNode = pHead;
        RandomListNode pCloneHead = currNode.next;
        RandomListNode cloneNode = currNode.next;
        currNode.next = cloneNode.next;
        currNode = currNode.next;

        while (currNode != null){
            // 设置复制节点指向的目标
            cloneNode.next = currNode.next;
            // 移动复制目标的节点
            cloneNode = cloneNode.next;
            // 指向后面的当前节点
            currNode.next = cloneNode.next;
            // 移动下一个当前的节点
            currNode = currNode.next;

        }

        return pCloneHead;
    }
}
