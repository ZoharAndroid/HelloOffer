

public class _234 {
	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 * fast和slow两个指针，每次快指针走两步，慢指针走一步，等快指针走完时，慢指针的位置就是中点
		 * 在找到中点后，将后半段的链表翻转一下
		 * @param head
		 * @return
		 */
	    public boolean isPalindrome(ListNode head) {
	        if (head == null) {
				return true;
			}
	        
	        ListNode fast = head;
	        ListNode slow = head;
	        while (fast.next != null && fast.next.next != null  ) {
				fast = fast.next.next;//fast每次走两个
				slow = slow.next;//此时slow就位于中间位置
			}
	        
	        ListNode reverseHead = reverse(slow.next);//将后半段链表翻转一下好进行对比
	        ListNode firstHalfHead = head;
	        while (reverseHead != null && firstHalfHead != null) {
				if (reverseHead.val != firstHalfHead.val) {
					return false;
				}
				reverseHead = reverseHead.next;
				firstHalfHead = firstHalfHead.next;
			}
	        return true;
	    }
	    
	    /**
	     * 翻转链表（参考leetcode 206题）
	     * 输入: 1->2->3->4->5->NULL
		 * 输出: 5->4->3->2->1->NULL
	     * @param head
	     * @return
	     */
	    private ListNode reverse(ListNode head) {
	    	ListNode pre = null;
	    	while (head != null) {
				ListNode next = head.next;
				head.next = pre;
				pre = head;
				head = next;
			}
	    	return pre;
	    }
	}
}
