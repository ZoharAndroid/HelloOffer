package algorithm.链表;

/**
 *
 * 21. 合并两个有序链表
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 */
public class _21 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            // 解题思路：新建一个链表的头，然后一次比较两个链表的节点，
            // 然后较小的添加到新建的头节点后，然后移动。如果有个链表遍历完了，
            // 如果有个链表遍历完了，而另外的一个链表还没有遍历完，那么直接把
            // 没有遍历玩的链表进行添加到新创建的链表后面。

            ListNode head = new ListNode(-1);
            ListNode node = head;
            while (l1 != null && l2 != null){
                if (l1.val < l2.val){
                    node .next = l1;
                    l1 = l1.next;
                }else{
                    node.next = l2;
                    l2 = l2.next;
                }
                node = node.next;
            }

            // 把后面没有弄完的进行添加
            if (l1 == null){
                node.next = l2;
            }else{
                node.next = l1;
            }

            return head.next;
        }
    }
}
