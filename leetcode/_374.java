
public class _374 {
	
	public static void main(String[] args) {
		
	}

	/*
	 * The guess API is defined in the parent class GuessGame.
	 * 
	 * @param num, your guess
	 * 
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise return
	 * 0 int guess(int num);
	 */

	 static class Solution extends GuessGame {
		 //二分查找,还有就是需要注意一下题目的表述，我的数字比较小：意思是你猜大了；
		public int guessNumber(int n) {
			int low = 0;
			int high = n;
			while (low <= high) {
				int mid = low + (high - low)/2;
				if (guess(mid) == 0) {
					return mid;
				}else if(guess(mid) == 1) {
					low = mid + 1;
				}else if (guess(mid) == -1) {
					high = mid - 1;
				}
			}
			return -1;
		}
	}
	 
	 /**
	  * 模拟guess函数
	  * @author zohar
	  *
	  */
	static class GuessGame{
		 
		 public int guess(int num) {
			 return 0;
		 }
	 }
}
