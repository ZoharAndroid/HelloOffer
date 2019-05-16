package algorithm.链表;

/**
 *
 * 234. 回文链表
 *  请判断一个链表是否为回文链表。
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class _234 {

    class Solution {
        public boolean isPalindrome(ListNode head) {

            // 解题思路：首先通过快慢指针，找到链表中的中间节点，然后通过后半段链表进行反转，与前半段进行比较即可

            if (head == null || head.next == null){
                return true;
            }

            ListNode fast = head;
            ListNode slow = head;


            while(fast.next != null && fast.next.next != null){
                fast = fast.next.next; // 快指针移动到末尾的时候，慢指针就正好移动到中间的位置
                slow = slow.next;
            }

            //将后半段链表进行反转
            ListNode node = reverse2(slow.next);

            while(node != null){
                if (node.val != head.val){
                    return false;
                }
                node = node.next;
                head = head.next;
            }

            return true;
        }

        /**
         * 用迭代反转
         *
         * @param head
         * @return
         */
        private ListNode reverse1(ListNode head){
            if (head == null || head.next == null){
                return head;
            }

            ListNode pre = null;
            ListNode cur = head;

            while (cur != null){
                ListNode tempNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tempNode;
            }

            return pre;
        }


        private ListNode reverse2(ListNode head){
            if (head == null || head.next == null){
                return head;
            }

            ListNode newHead = reverse2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
