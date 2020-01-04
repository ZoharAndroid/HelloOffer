import java.util.Arrays;

//455. 分发饼干
public class _455 {

	public static void main(String[] args) {

	}
	
	static class Solution {
		/**
		 * 解题思路：贪心算法，对于这个题目就是让尽量多的饼干满足多的孩子的胃口，也就是先让小的饼干满足小的胃口的孩子
		 * @param g
		 * @param s
		 * @return
		 * 执行用时: 23 ms, 在Assign Cookies的Java提交中击败了24.95% 的用户
		 */
	    public int findContentChildren(int[] g, int[] s) {
	    	// 将儿童和蛋糕按照从小到大的顺序先排列
	        Arrays.sort(g);
	        Arrays.sort(s);
	        
	    	int childs = 0;
	    	int cookies = 0;
	        while(childs < g.length && cookies < s.length) {
	        	if (g[childs] <= s[cookies]) {
					childs++;
				}
	        	cookies++;
	        }
	        return childs;
	    }
	}

}
