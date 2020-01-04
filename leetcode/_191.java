

public class _191 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hammingWeight(0b00000000000000000000000000001011));
		Solution2 s2 = new Solution2();
		System.out.println(s2.hammingWeight(0b00000000000000000000000010000000));
	}
	
	static class Solution {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	    	int weight = 0;
	        for (int i = 0; i < 32; i++) {
				if ((n & 1) == 1) {
					weight++;
				}
				//right move
				n >>>= 1;
			}
	        
	        return weight;
	    }
	}
	
	static class Solution2 {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	    	int weight = 0;
	        for (int i = 0; i < 32; i++) {
				if ((n & 1) == 1) {
					weight++;
				}
				
				//如果判断n剩余的为0，则提前结束
				if (n == 0) {
					return weight;
				}
				
				//right move
				n >>>= 1;
			}
	        
	        return weight;
	    }
	}
}
