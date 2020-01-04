//405.数字转换为十六进制数
public class _405 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.toHex(-1));
	}
	
	static class Solution {
	    public String toHex(int num) {
	    	char[] hexChars = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	        String result = "";
	        for (int i = 0; i < 8 && num!=0; i++) {
				result = hexChars[num & 15] + result;
				num >>>= 4;
			}
	        return result.isEmpty()?"0":result;
	    }
	}

}
