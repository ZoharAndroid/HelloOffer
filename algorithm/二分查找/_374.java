package algorithm.二分查找;

/**
 * 374. 猜数字大小
 *
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class _374 {

    public class Solution extends GuessGame {

        public int guessNumber(int n) {

            // 解题思路：简单的利用二分查找

            int start = 1;
            int end = n;
            while ( start <= end){
                int mid = start + (end - start)/2;
                if (guess(mid) == 0){
                    return mid;
                }else if (guess(mid) == -1){
                    // 猜大了
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

            return -1;
        }
    }

    class GuessGame{

        public int guess(int num){
            return -1;
        }
    }

}
