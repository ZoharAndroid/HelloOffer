

public class _206 {
	
	public static void main(String[] args) {
		
	}
	
	static class Solution {
	    public ListNode reverseList(ListNode head) {
	    	ListNode newHead = null;
	        while(head != null) {
	        	ListNode next = head.next;
	        	head.next = newHead;
	        	newHead = head;
	        	head = next;
	        }
	        
	        return newHead;
	    }
	}

}
