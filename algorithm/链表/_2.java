package algorithm.链表;

/**
 *
 * 2. 两数相加
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，
 *  它们各自的位数是按照 逆序 的方式存储的，并且它们的
 *  每个节点只能存储 一位 数字。
 *  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *  https://leetcode-cn.com/problems/add-two-numbers/
 */
public class _2 {

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            // 解题思路：两个节点相加，然后如果有进位就向前加

            ListNode head = new ListNode(-1);
            ListNode node = head;

            boolean carry = false;

            while( l1 != null || l2 != null){

                int val = 0;

                if (l1 != null ){
                    val += l1.val;
                    l1 = l1.next;
                }

                if ( l2 != null){
                    val += l2.val;
                    l2 = l2.next;
                }

                if (carry) {
                    val = val + 1;
                    carry = false;
                }

                if (val >= 10) {
                    carry = true;
                    val = val - 10;
                }

                ListNode tempNode = new ListNode(val);
                node.next = tempNode;
                node = node.next;

            }

            // 判断哪个节点没有弄完
            if (carry){
                ListNode tempNode = new ListNode(1);
                node.next = tempNode;
                node = node.next;
            }
            node.next = null;


            return head.next;

        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        n2.next = n3;
        System.out.println(s.addTwoNumbers(n1,n2).next.next.val);
    }

}
