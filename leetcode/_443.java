//443. 压缩字符串
public class _443 {

	public static void main(String[] args) {
		Solution s  = new Solution();
		System.out.println(s.compress(new char[] {'a','a','b','b','c','c','c'}));
	}

	
	static class Solution {
		/**
		 * 解题思路：这里需要注意的题目隐含的一点就是，字符数组已经按照 字符相同的在一组（在一起）。这题原地算法还没有实现，这里的解法用了额外的空间
		 * 来实现。
		 * @param chars
		 * @return
		 * 执行用时: 9 ms, 在String Compression的Java提交中击败了49.19% 的用户
		 */
	    public int compress(char[] chars) {
	        if (chars == null || chars.length == 0) {
				return 0;
			}
	        
	        char preChar = chars[0];
	        int count = 1;
	        StringBuilder sb = new StringBuilder();
	        for (int i = 1; i < chars.length; i++) {
				if (chars[i]==preChar) {
					//如果相等
					count++;
				}else {
					//如果不相等
					sb.append(preChar);
					if (count == 1) {
						
					}else {
						sb.append(count);
					}
					//重新赋值
					preChar = chars[i];
					count = 1;
				}
				
			}
	        //写入最后的一组字符
	        sb.append(preChar);
	        if (count != 1) {
				sb.append(count);
			}
	        //重新写入数组中
	        int i = 0;
	        for (char temp : sb.toString().toCharArray()) {
				chars[i++] = temp;
			}
	        return sb.length();
	    }
	}
}
