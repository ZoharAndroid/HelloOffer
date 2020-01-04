import java.util.HashMap;
import java.util.Map;

public class _447 {

	public static void main(String[] args) {

	}
	
	static class Solution {
		/**
		 * 解题思路：用Hashmap来解决这个题目。遍历所有的点，然后把距离相同的点记录下来。距离当做是key，value值距离相等的个数。然而，每个距离相等的个数的点，
		 * 有n*(n-1)中排列方式，比如：abc三个点，假如ab和ac两者的距离相等，也就是value为2，那么形成的三元组可以为：
		 * abc或者acb，这两种排列方式都是满足题目要求的。
		 * 
		 * @param points
		 * @return
		 * 执行用时：215 ms
		 */
	    public int numberOfBoomerangs(int[][] points) {
	        if (points == null) {
				return 0;
			}
	        int result = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < points.length; i++) {
	        	for (int j = 0; j < points.length; j++) {
	        		if (i == j) {
						continue;
					}
	        		//计算两点的距离
	        		int distance = calDistance(points[i], points[j]);
	        		//把相同的距离保存在同一位置上
//	        		if (map.containsKey(distance)) {
//						map.put(distance, map.get(distance) + 1);
//					}else {
//						map.put(distance, 1);
//					}
	        		map.put(distance, map.getOrDefault(distance, 0)+1);
				}
	        	//每次找完一轮，就进行计算
	        	for (Integer value : map.values()) {
					result += value * (value - 1);// n *(n-1)中排列方式
				}
	        	//清空一下，进行下一轮
	        	map.clear();
			}
	        return result;
	    }
	    
	    /**
	     * 计算两点的距离
	     * @param p1
	     * @param p2
	     * @return
	     */
	    private int calDistance(int[] p1,int[] p2) {
	    	return (p2[0] - p1[0]) * (p2[0] - p1[0]) +
	    			(p2[1] - p1[1])*(p2[1] - p1[1]);
	    }
	}

}
