//415.字符串相加
public class _415 {
	public static void main(String[] args) {
		
	}
	
	static class Solution {
		/**
		 * 解题思路：将字符串转换成字符数组，然后一位一位的相加，进位保存到下一次操作。最后判断是否有进位，有进位直接就是最高位。
		 * @param num1
		 * @param num2
		 * @return
		 * 执行用时: 27 ms, 在Add Strings的Java提交中击败了70.61% 的用户
		 */
	    public String addStrings(String num1, String num2) {
	        if (num1 == null || num1.length() == 0) {
				return num2;
			}else if (num2 == null || num2.length() == 0) {
				return num1;
			}
	        
	        int len1 = num1.length() - 1;
	        int len2 = num2.length() - 1;
	        char[] cnum1 = num1.toCharArray();
	        char[] cnum2 = num2.toCharArray();
	        int sum = 0;
	        int carry = 0;
	        StringBuilder sb = new StringBuilder();
	        while(len1 >= 0 || len2 >= 0) {
	        	sum = carry;
	        	
	        	if (len1 >= 0) {
					sum += Character.getNumericValue(cnum1[len1--]);
				}
	        	if (len2 >= 0) {
					sum += Character.getNumericValue(cnum2[len2--]);
				}
	        	
	        	carry = sum / 10;
	        	sb.append(sum%10);
	        }
	        
	        if (carry!=0) {
				sb.append(carry);
			}
	        return sb.reverse().toString();
	    }
	}
}
