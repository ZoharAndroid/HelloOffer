package algorithm.链表;

/**
 *
 * 206. 反转链表
 *  反转一个单链表。
 *
 *  https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206 {

    class Solution {
        /**
         *  迭代方法
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {

            // 解题思路：利用两个节点，一个当前节点一个当前节点的前面一个节点，每次操作一步，然后就转变一下方向。

            if (head == null || head.next == null){
                return head;
            }

            ListNode prev = null;
            ListNode cur = head;
            while (cur != null){
                ListNode nextNode = cur.next; // 保存下一个节点
                cur.next = prev; // 转变方向
                prev = cur; // 移动节点
                cur = nextNode;
            }

            return prev;
        }


        /**
         * 递归方法
         *
         * @param head
         * @return
         */
        public ListNode reverseList2(ListNode head){

            // 解题思路：假设 nk+1 到m都已经反转了，
            // n1​→...→ nk−1 → nk → nk+1​←...←nm，
            // 那么反转nk 和 nk+1的操作就是： nk.next.next = nk
            // 这个等式的意思就是 nk.next 是 nk+1, 那么 nk+1.next 如果要转换方向那么只能 等于nk啦
            if (head == null || head.next == null){
                return head;
            }

            ListNode newHead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
