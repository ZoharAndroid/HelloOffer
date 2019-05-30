package algorithm.链表;

/**
 * 160. 相交链表
 *  编写一个程序，找到两个单链表相交的起始节点。
 *
 *  https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class _160 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            // 解题思路：先获取每个链表的长度，然后让较长的链表先移动|headA.length - headB.length|个节点，然后两个链表同时移动，
            // 判断是否有相同的节点

            if (headA == null || headB == null){
                return null;
            }

            // 两个链表移动到末尾
            ListNode node1 = headA;
            ListNode node2 = headB;
            //获取两个链表的长度
            int aLength = getListNodeLength(node1);
            int bLength = getListNodeLength(node2);

            node1 = headA;
            node2 = headB;
            if (aLength > bLength){
                // a链表较长，先移动相差个节点
                for (int i = 0; i < aLength - bLength; i++){
                    node1 = node1.next;
                }
            }else{
                for (int i = 0; i < bLength - aLength; i++){
                    node2 = node2.next;
                }
            }

            while (node1 != node2 && node1 != null && node2 != null){
                node1 = node1.next;
                node2 = node2.next;
            }

            return node1;
        }

        private int getListNodeLength(ListNode listnode){
            int count = 0;
            while (listnode != null){
                count++;
                listnode = listnode.next;
            }

            return count;
        }
    }
}
