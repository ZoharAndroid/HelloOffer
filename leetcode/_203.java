

public class _203 {

	public static void main(String[] args) {
	
	}

	static class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode temp = new ListNode(-1);
			temp.next = head;
			ListNode cur = head;
			ListNode pre = temp;
			
			while(cur != null) {
				if (cur.val == val) {
					pre.next = cur.next;
				}else {
					pre = pre.next;
				}
				cur = cur.next;
			}
			
			return temp.next;
			
		}
	}

}
