package algorithm.链表;

/**
 *
 * 203. 移除链表元素
 *  删除链表中等于给定值 val 的所有节点。
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 */
public class _203 {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            // 解题思路：新建一个链表的头，然后就是遍历节点，如果没有相同的数，就添加到新建的链表后面，那么就直接移动到下一个节点，
            // 如果找到了相同的节点，那么跳过这个节点，不进行添加

            if (head == null ){
                return head;
            }

            ListNode newHead = new ListNode(-1);
            ListNode node = head;
            ListNode newNode = newHead;
            while (node != null){
                if (node.val != val){
                    newNode.next = node;
                    newNode = newNode.next;
                }
                node = node.next;
            }
            newNode.next = null;

            return newHead.next;
        }
    }
}
