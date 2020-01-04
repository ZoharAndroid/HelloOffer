

public class _237 {
	
	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 *  这道题没有head节点，而只给出了要删除的结点
		 * @param node
		 */
	    public void deleteNode(ListNode node) {
	        node.val = node.next.val;
	        node.next = node.next.next;
	    }
	}
}
