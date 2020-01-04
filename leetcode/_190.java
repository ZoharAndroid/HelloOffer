

public class _190 {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.reverseBits(43261596));
		Solution2 s2 = new Solution2();
		System.out.println(s2.reverseBits(43261596));
	}
	
	
	static class Solution1 {
	    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
	        int result = 0;
	        for (int i = 0; i < 32; i++) {
				result += n & 1; 
				n >>>= 1;//n无符号左移动1位
				if (i < 31) {
					result <<= 1;
				}
			}
	        
	        return result;
	    }
	}
	
	static class Solution2 {
	    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
	        return Integer.reverse(n);
	    }
	}
}
