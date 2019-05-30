package algorithm.链表;

/**
 *
 * 19. 删除链表的倒数第N个节点
 *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 *  https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 */
public class _19 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            // 解题思路：可以用双指针操作，让一个指针先移动n位，然后两个指针同时移动
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode fast = head;
            // 先让快指针移动n位
            for (int i = 1; i < n; i++){
                fast = fast.next;
            }

            // 快慢指针同时移动
            ListNode slow = dummyHead;
            while (fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }

            if (slow.next != null){
                slow.next = slow.next.next;
            }

            return dummyHead.next;
        }
    }
}
