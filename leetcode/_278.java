
public class _278 {
	
	public static void main(String[] args) {
		
	}
	
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	
	static class Solution {
	    public int firstBadVersion(int n) {
	        //使用二分查找
	    	int high = n,low = 1;
	    	while (low < high) {
				int mid = low + (high - low) / 2;
				if (isBadVersion(mid)) {
					high = mid;
				}else {
					low = mid + 1;
				}
			}
	    	if (isBadVersion(low)) {
				return low;
			}
	    	return high;
	    	
	    }
	    
	    
	    /**
	     * 模拟而已，leetcode实际上已经实现了
	     * 
	     * @param version
	     * @return
	     */
	    private boolean isBadVersion(int version) {
	    	return  false;
	    }
	}
}
