package algorithm.链表;

/**
 *
 * 142. 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class _142 {

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            // 解题思路：用快慢指针，首先可以判断是否有环，当有环的时候，找到相遇的点，然后记录一下这个环有多少(假设有n)个节点，然后让快指针先移动n各节点
            // 然后慢指针从head开始，当两者相遇的时候，也就是环的入口点
            if (head == null || head.next == null)
                return null;

            ListNode meetNode = getMeetingNode(head);
            if (meetNode == null){
                return null;
            }

            // 得到环的个数
            int count = 1;
            ListNode node1 = meetNode;
            while (node1.next != meetNode){
                node1 = node1.next;
                count++;
            }

            // 先让node1移动count个节点
            node1 = head;
            for (int i = 0; i < count; i++){
                node1 = node1.next;
            }

            // 然后当两者相遇的时候
            ListNode node2 = head;
            while (node1 != node2){
                node1 = node1.next;
                node2 = node2.next;
            }

            return node1;

        }

        /**
         * 获取相遇的节点
         *
         * @param head
         * @return
         */
        private ListNode getMeetingNode(ListNode head){
            ListNode slow = head;
            ListNode fast = head.next;

            while(fast != null && fast.next != null){

                if (fast == slow){
                    return fast;
                }

                fast = fast.next.next;
                slow = slow.next;
            }

            return null;
        }
    }
}
