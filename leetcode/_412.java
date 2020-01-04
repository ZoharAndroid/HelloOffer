import java.util.ArrayList;
import java.util.List;

//412.Fizz Buzz

public class _412 {
	public static void main(String[] args) {
		System.out.println(new Solution().fizzBuzz(15).toString());
	}
	static class Solution {
	    public List<String> fizzBuzz(int n) {
	        List<String> result = new ArrayList<>();
	        for (int i = 1; i <= n; i++) {
				if (i%3==0 && i%5!=0) {
					result.add("Fizz");
				}else if(i%3!=0 && i%5==0) {
					result.add("Buzz");
				}else if(i%3==0 && i%5==0) {
					result.add("FizzBuzz");
				}else {
					result.add(i+"");
				}
			}
	        return result;
	    }
	}//执行用时: 3 ms, 在Fizz Buzz的Java提交中击败了85.90% 的用户
}
