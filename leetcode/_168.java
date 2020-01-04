

public class _168 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.convertToTitle(701));
	}

	static class Solution {
		public String convertToTitle(int n) {
			StringBuilder sb = new StringBuilder();
			
			while(n != 0 ) {
				int temp = (n -1)%26;
				sb.append(String.valueOf((char)(temp + 'A')));
				n = (n-1)/26;
				
			}
	      return sb.reverse().toString();
	    }
	}
}
