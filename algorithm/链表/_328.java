package algorithm.链表;

/**
 *
 * 328. 奇偶链表
 *
 *  给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 *  请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 */
public class _328 {

    class Solution {
        public ListNode oddEvenList(ListNode head) {

            // 解题思路：奇数偶数位分别用两个指针来进行处理，一个是指向开头，一个指向末尾.
            if (head == null || head.next == null){
                return head;
            }

            ListNode oddStart = head;
            ListNode oddEnd = head;
            ListNode evenStart = head.next;
            ListNode evenEnd = head.next;

            while (oddEnd.next != null && evenEnd.next != null){
                oddEnd.next = evenEnd.next; // 修改奇数位置指向的节点
                oddEnd = oddEnd.next; // 修改奇数链表末尾的节点
                evenEnd.next = oddEnd.next;// 修改偶数位置指向的节点
                evenEnd = evenEnd.next;
            }
            // 修改最后的奇数链表中末尾的位置
            oddEnd.next = evenStart;

            return head;
        }
    }
}
