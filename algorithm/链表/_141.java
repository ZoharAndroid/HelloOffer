package algorithm.链表;



/**
 *
 * 141. 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 */
public class _141 {


    public class Solution {
        public boolean hasCycle(ListNode head) {

            // 解题思路：用快慢指针来解决，如果快指针能够追赶上慢指针，那么说明是有环的。

            // 如果没有节点或者单个节点
            if (head == null || head.next == null){
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null){
                if (fast == slow){
                    return true;
                }

                fast = fast.next.next;
                slow = slow.next;
            }

            return false;


        }
    }
}
