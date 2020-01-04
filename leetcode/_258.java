
public class _258 {
	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		System.out.println(s1.addDigits(38));
	}

	static class Solution1 {
		public int addDigits(int num) {
			while (num / 10 > 0) {
				int sum = 0;
				while (num > 0) {
					sum += num % 10;
					num /= 10;
				}
				num = sum;
			}

			return num;
		}
	}

	/**
	 * 1 1 
	 * 2 2 
	 * 3 3 
	 * 4 4 
	 * 5 5 
	 * 6 6 
	 * 7 7 
	 * 8 8 
	 * 9 9 
	 * 10 1 
	 * 11 2 
	 * 12 3 
	 * 13 4 
	 * 14 5 
	 * 15 6 
	 * 16 7 
	 * 17 8
	 * 18 9 
	 * 19 1 
	 * 20 2
	 * 每9个一循环，所有大于9的数的树根都是对9取余，那么对于等于9的数对9取余就是0了，为了得到其本身，而且同样也要对大于9的数适用，我们就用(n-1)%9+1这个表达式来包括所有的情况
	 * @author zohar
	 *
	 */
	static class Solution2 {
		public int addDigits(int num) {
			return (num - 1)%9 + 1;
		}
	}
}
