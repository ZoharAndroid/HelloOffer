

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _349 {
	
	public static void main(String[] args) {
		
	}
	
	static class Solution {
	    public int[] intersection(int[] nums1, int[] nums2) {
	        Set<Integer> set1 = new HashSet<>();
	        Set<Integer> set2 = new HashSet<>();
	        
	        for (int i : nums1) {
				set1.add(i);
			}
	        
	        for (int i : nums2) {
				if (set1.contains(i)) {
					set2.add(i);
				}
			}
	        
	        int[] result = new int[set2.size()];
	        Iterator<Integer> iterator = set2.iterator();
	        int i = 0;
	        while (iterator.hasNext()) {
				result[i++] = iterator.next();
			}
	        
	        return result;
	    }
	}
}
