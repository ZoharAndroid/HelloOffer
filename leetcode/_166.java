

import java.util.HashSet;
import java.util.Set;

public class _166 {
	
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        Set<ListNode> set = new HashSet<>();
	    	
	    	if (headA == null || headB == null) {
				return null;
			}
	    	
	    	while(headA != null) {
	    		set.add(headA);
	    		headA = headA.next;
	    	}
	    	
	    	while(headB != null) {
	    		if (set.contains(headB)) {
					return headB;
				}
	    		headB = headB.next;
	    	}
	        
	        return null;
	    }
	}

}
