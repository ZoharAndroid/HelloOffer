//401.二进制手表
import java.util.ArrayList;
import java.util.List;

public class _401 {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.readBinaryWatch(2));
	}
	
	static class Solution {
	    public List<String> readBinaryWatch(int num) {
	    	List<String> list = new ArrayList<>();
	        for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 60; j++) {
					if (Integer.bitCount(i)+Integer.bitCount(j) == num) {
						//计算1的数目是否相等
						list.add(String.format("%d:%02d", i,j));
					}
				}
			}
	        return list;
	    }
	}
}
